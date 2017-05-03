package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by u1933 on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","nom"}))
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Ruta() {
    }

    /** Constructor per parametres */
    public Ruta(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Atributs de la classe Ruta:
     * - id (clau primaria)
     * - nom
     * - color_id (clau forana)
     * - tren_id (clau forana)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    /** Falten les claus foranes */


    /** Relacio OneToMany amb la classe Incidencia
     *  Relacio OneToMany amb la classe Tram
     *  Relacio ManyToOne amb la classe Tren
     *  Relacio ManyToOne amb la classe Color */


    /** Funcions de la classe Ruta */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /** funcions de les claus foranes! */

}
