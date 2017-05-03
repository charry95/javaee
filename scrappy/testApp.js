var scrapy = require('node-scrapy')
	, url = 'http://rodalies.gencat.cat/ca/'
	, model = {
		maintainers: {
			selector: '.first option:not(:first-child)',
			get: 'value'
		}
	}
	var fs = require('fs');

console.log("Starting scrapy...");
scrapy.scrape(url,model, function(err,ids){
	if(err)
		console.log(err);
	else{
		console.log("Ids achieved.");
		model.maintainers.get = 'text';
		scrapy.scrape(url,model, function(err,names){
			if(err)
				console.log(err);
			else{
				console.log("Names achieved.");
				console.log("Fusioning...")
				for(index in ids.maintainers){
					var name = names.maintainers[index].replace(/'/g,"\\'");
					var insert = 'INSERT INTO `estacio` (`idEstacio`,`nomEstacio`) VALUES ('+ids.maintainers[index]+",'"+name+"');\n"
					fs.appendFile('insert_estacions.sql', insert, function (err) {
					  if (err) throw err;
					  console.log('Saved!');
					});
				}
			}

		});
	}
});
