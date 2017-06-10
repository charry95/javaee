package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by u1933 on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.udg.pds.simpleapp_javaee.rest.serializer.CustomEstacioSerializer;

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
    public Tram(Integer hora, Integer minut, Ruta ruta) {
        this.hora = hora;
        this.minut = minut;
        this.estacio = new Estacio();
        this.ruta = ruta;
        //this.ruta = new Ruta();
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
    @JsonView(Views.Public.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private Integer hora;

    @NotNull
    @JsonView(Views.Public.class)
    private Integer minut;

    /** Relacio ManyToOne amb la classe Estacio
     *  Relacio ManyToOne amb la classe Ruta */

    @ManyToOne
    @JsonView(Views.Public.class)
    @JsonSerialize(using = CustomEstacioSerializer.class)
    private Estacio estacio;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Ruta ruta;

    /** Funcions de la classe Tram */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getMinut() { return minut; }

    public void setMinut(Integer minut) { this.minut = minut; }

    public Estacio getEstacio() { return estacio; }

    public void setEstacio(Estacio estacio) { this.estacio = estacio; }

    public Ruta getRuta() { return ruta; }

    public void setRuta(Ruta ruta) { this.ruta = ruta; }
}
