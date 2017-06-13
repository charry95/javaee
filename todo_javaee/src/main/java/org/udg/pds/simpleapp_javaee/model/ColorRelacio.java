package org.udg.pds.simpleapp_javaee.model;

/**
 * Created by Charry on 12/06/2017.
 */

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class ColorRelacio {

    public ColorRelacio() {
    }

    public ColorRelacio(Color c1, Color c2) {
        this.coloract = c1;
        this.colorrel = c2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;

    @OneToOne
    @JsonIgnore
    private Color coloract;

    @OneToOne
    @JsonIgnore
    private Color colorrel;
}
