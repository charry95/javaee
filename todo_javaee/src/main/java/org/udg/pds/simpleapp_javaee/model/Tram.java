package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by u1933 on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Tram implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Tram() {
    }

    /** Constructor per parametres */
    public Tram(Long hora, Long minut) {
        this.hora = hora;
        this.minut = minut;
        //this.estacio = new Estacio();
        this.ruta = new Ruta();
    }

    /**
     * Atributs de la classe Tram:
     * - id (clau primaria)
     * - hora
     * - minut
     * - estacio (clau forana)
     * - ruta (clau forana)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private Long hora;

    @JsonView(Views.Public.class)
    private Long minut;

    /** Relacio ManyToOne amb la classe Estacio
     *  Relacio ManyToOne amb la classe Ruta */
/*
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Estacio estacio;
*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Ruta ruta;


    /** Funcions de la classe Tram */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public Long getMinut() { return minut; }

    public void setMinut(Long minut) { this.minut = minut; }
/*
    public Estacio getEstacio() { return estacio; }

    public void setEstacio(Estacio estacio) { this.estacio = estacio; }
*/
    public Ruta getRuta() { return ruta; }

    public void setRuta(Ruta ruta) { this.ruta = ruta; }
}
