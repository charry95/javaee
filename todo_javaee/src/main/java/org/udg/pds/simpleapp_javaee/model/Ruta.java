package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by u1933 on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.udg.pds.simpleapp_javaee.rest.serializer.CustomColorRutaSerializer;
import org.udg.pds.simpleapp_javaee.rest.serializer.CustomTrenRutaSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Ruta() {
    }

    /** Constructor per parametres */
    public Ruta(String direccio) {
        this.direccio = direccio;
        //this.incidencies = new ArrayList<>();
        //this.trams = new ArrayList<>();
        //this.tren = new Tren();
        this.color = null;
    }

    /**
     * Atributs de la classe Ruta:
     * - id (clau primaria)
     * - tren_id (clau forana)
     * - color_id (clau forana)
     * - array d'incidencies
     * - array de trams
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    protected Long id;

    @JsonView(Views.Public.class)
    private String direccio;

    @JsonView(Views.Public.class)
    @JsonSerialize(using = CustomColorRutaSerializer.class)
    @ManyToOne
    private Color color;

    @ManyToOne
    @JsonView(Views.Public.class)
    @JsonSerialize(using = CustomTrenRutaSerializer.class)
    private Tren tren;

    @OneToMany(mappedBy = "ruta")
    @JsonView(Views.Public.class)
    private Collection<Tram> trams;



    /** Relacio OneToMany amb la classe Incidencia
     *  Relacio OneToMany amb la classe Tram
     *  Relacio ManyToOne amb la classe Tren
     *  Relacio ManyToOne amb la classe Color */

/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")


    @JsonView(Views.Complete.class)
    private Collection<Incidencia> incidencies;*/

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta")
    @JsonView(Views.Complete.class)
    private Collection<Tram> trams;*/

   /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Tren tren;
*/



    /** Funcions de la classe Ruta */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Collection<Incidencia> getIncidencies() { return incidencies; }

    public void setIncidencies(Collection<Incidencia> incidencies) { this.incidencies = incidencies; }

    public Tren getTren() { return tren; }

    public void setTren(Tren tren) { this.tren = tren; }
*/
    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public Collection<Tram> getTrams() { return trams; }

    public Tram getTram(Long idEstacio) {
        Tram tram = null;
        for(Tram actual : trams) {
            if(actual.getEstacio().getId().equals(idEstacio)) tram = actual;
        }
        return tram;
    }

    public void setTrams(Collection<Tram> trams) { this.trams = trams; }

    public Tren getTren(){
        return tren;
    }

    public void setTren(Tren t){
        this.tren = t;
    }

    public Boolean direccioCorrecte(Long origen, Long desti){
        Boolean origenPrimer = false;
        Boolean destiInclos = false;
        for(Tram actual : trams){
            if(actual.getEstacio().getId().equals(origen) && !destiInclos)
                origenPrimer = true;
            else if(actual.getEstacio().getId().equals(desti))
                destiInclos = true;
        }
        return origenPrimer && destiInclos;
    }

    public Boolean conteEstacio(Long origen) {
        Boolean estacioTrobada = false;
        for(Tram actual : trams) {
            if(actual.getEstacio().getId().equals(origen)) estacioTrobada = true;
        }
        return estacioTrobada;
    }

    public void sumarRetard(Integer retard) {
        for(Tram t : trams) {
            Integer hora = t.getHora();
            Integer min = t.getMinut();
            min += retard;
            while(min >= 60) {
                min -= 60;
                hora += 1;
            }
            t.setMinut(min);
            t.setHora(hora);
        }
    }
}
