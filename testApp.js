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

				console.log(found);
			}

		});
	}
})


/*app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.post('/edad', function(request, response) {
	console.log("Request received.")
	var mongoose = require('mongoose');
	var Schema = mongoose.Schema;
	var userSchema = new Schema({
	});
	mongoose.connect("mongodb://charry95:1326lerper@ds011382.mlab.com:11382/charrytest");
	var connection = mongoose.connection;
	connection.on('error', function(err){
		console.log('Mongoose connection error: ' + err);
		process.exit(0);
	});
	connection.once('open',function(){
		console.log("Connected to MongoDB.");
		var value = parseInt(request.body.edad);
		console.log(value);
		var User = mongoose.model('users',userSchema);
		User.find({'edad': value}, function(err,users){
			console.log(users.length);
			if(err){
				console.log('Error en la busqueda.');
				response.status(404).send('Find error');
			}
			else if (!users.length){
				console.log("Busqueda buida.");
				response.status(204).send("busqueda buida.");
			}
			else{
				console.log('Busqueda correcta.');
				response.status(200).send(users);
			}
			connection.close();
		});

	});
});

app.get('/',function(request, response){
	response.send("entrada directe 2");
});

app.listen(8080);*/
