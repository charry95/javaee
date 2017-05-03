package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by Charry on 03/05/2017.
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
public class Color implements Serializable {
    private static final long serialVersionUID = 1L;

    public Color() {
    }

    public Color(String nom) {
        this.nom = nom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    @ManyToMany
    private Collection<Estacio> estacions;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public Collection<Estacio> getEstacions() {
        estacions.size();
        return estacions;
    }

    public void setEstacions(List<Estacio> es) {
        this.estacions = es;
    }

    public void addEstacio(Estacio estacio) {
        estacions.add(estacio);
    }
}
