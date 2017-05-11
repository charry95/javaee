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
public class Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Incidencia() {
    }

    /** Constructor per parametres */
    public Incidencia(String descripcio, Long retard, Boolean activa) {
        this.descripcio = descripcio;
        this.retard = retard;
        this.activa = activa;
        //this.ruta = new Ruta();
    }

    /**
     * Atributs de la classe Incidencia:
     * - id (clau primaria)
     * - descripcio
     * - retard
     * - activa
     * - ruta (clau forana)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String descripcio;

    @JsonView(Views.Public.class)
    private Long retard;

    @JsonView(Views.Public.class)
    private Boolean activa;

    /** Relacio ManyToOne amb la classe Ruta */
    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Ruta ruta;*/

    /** Funcions de la classe Incidencia */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Long getRetard() { return retard; }

    public void setRetard(Long retard) { this.retard = retard; }

    public Boolean getActiva() { return activa; }

    public void setActiva(Boolean activa) { this.activa = activa; }

    /*public Ruta getRuta() { return ruta; }

    public void setRuta(Ruta ruta) { this.ruta = ruta; }*/
}
