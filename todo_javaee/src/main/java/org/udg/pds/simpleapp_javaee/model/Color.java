package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by Charry on 03/05/2017.
 */

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.udg.pds.simpleapp_javaee.rest.serializer.CustomEstacioSerializer;

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
        this.rutes = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    @ManyToMany(mappedBy = "colors")
    @JsonView(Views.Complete.class)
    @JsonSerialize(using = CustomEstacioSerializer.class)
    private List<Estacio> estacions;

    @OneToMany(mappedBy = "color")
    @JsonView(Views.Public.class)
    private Collection<Ruta> rutes;

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

    public Collection<Ruta> getRutes() {
        rutes.size();
        return rutes;
    }

    public void setRutes(List<Ruta> es) {
        this.rutes = es;
    }

    public void addRuta(Ruta r) {
        rutes.add(r);
    }
}
