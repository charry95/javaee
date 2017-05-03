package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by Charry on 02/05/2017.
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
public class Estacio implements Serializable {
    private static final long serialVersionUID = 1L;

    public Estacio() {
        this.colors = new ArrayList<>();
    }

    public Estacio(Long id, String nom, Double latitud, Double longitud, Long tlf) {
        this.id = id;
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tlf = tlf;
        this.colors = new ArrayList<>();
    }

    @Id
    @JsonView(Views.Private.class)
    protected Long id;

    @NotNull
    @JsonView(Views.Public.class)
    private String nom;

    @JsonView(Views.Public.class)
    private Double latitud;

    @JsonView(Views.Public.class)
    private Double longitud;

    @JsonView(Views.Public.class)
    private Long tlf;

    @ManyToMany(mappedBy = "estacions")
    private Collection<Color> colors;

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
}