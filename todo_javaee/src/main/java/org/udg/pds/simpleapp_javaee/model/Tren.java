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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nom"}))
public class Tren implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Constructor per defecte */
    public Tren() {
    }

    /** Constructor per parametres */
    public Tren(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
        //this.rutes = new ArrayList<>();
    }

    /**
     * Atributs de la classe Tren:
     * - id (clau primaria)
     * - nom
     * - tipus
     * - array de rutes
      */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    @JsonView(Views.Public.class)
    private String tipus;


    /** Relacio OneToMany amb la classe Ruta */

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "tren")
    @JsonView(Views.Complete.class)
    private Collection<Ruta> rutes;*/

    /** Funcions de la classe Tren */
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

    public String getTipus() { return tipus; }

    public void setTipus(String tipus) { this.tipus = tipus; }

    /*public Collection<Ruta> getRutes() { return rutes; }

    public void setRutes(Collection<Ruta> rutes) { this.rutes = rutes; }*/
}
