package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by Charry on 02/05/2017.
 */

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nom"}))
public class Estacio implements Serializable {
    private static final long serialVersionUID = 1L;

    public Estacio() {
        this.colors = new ArrayList<>();
        this.trams = new ArrayList<>();
    }

    public Estacio(Long id, String nom, Double latitud, Double longitud, Long tlf) {
        this.id = id;
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tlf = tlf;
        this.colors = new ArrayList<>();
        this.trams = new ArrayList<>();
    }

    @Id
    @JsonView(Views.Public.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    @JsonView(Views.Private.class)
    private Double latitud;

    @JsonView(Views.Private.class)
    private Double longitud;

    @JsonView(Views.Private.class)
    private Long tlf;

    //@JsonIgnore
    @ManyToMany
    @JsonView(Views.Private.class)
    @JsonManagedReference
    private List<Color> colors;

    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacio")
    @JsonView(Views.Complete.class)
    private List<Tram> trams;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Long getTlf() {
        return tlf;
    }

    public void setTlf(Long tlf) {
        this.tlf = tlf;
    }

    public Long getId() {
        return id;
    }

    public Collection<Color> getColors() {
        colors.size();
        return colors;
    }

    public void setColors(List<Color> cl) {
        this.colors = cl;
    }

    public void addColor(Color color) {
        colors.add(color);
    }

    public Collection<Tram> getTrams() {
        trams.size();
        return trams;
    }

    public void setTrams(List<Tram> tr) {
        this.trams = tr;
    }

    public void addTram(Tram tram) {
        trams.add(tram);
    }
}
