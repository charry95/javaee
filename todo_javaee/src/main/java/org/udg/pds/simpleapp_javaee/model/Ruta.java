package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by u1933 on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Ruta() {
    }

    /** Constructor per parametres */
    public Ruta(Long id) {
        this.id = id;
        //this.incidencies = new ArrayList<>();
        //this.trams = new ArrayList<>();
        //this.tren = new Tren();
        this.color = new Color();
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
    @JsonView(Views.Private.class)
    protected Long id;

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
    @JsonIgnore
    @ManyToOne
    private Color color;


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

    public Collection<Tram> getTrams() { return trams; }

    public void setTrams(Collection<Tram> trams) { this.trams = trams; }

    public Tren getTren() { return tren; }

    public void setTren(Tren tren) { this.tren = tren; }
*/
    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

}
