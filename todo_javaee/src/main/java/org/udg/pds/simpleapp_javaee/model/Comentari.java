package org.udg.pds.simpleapp_javaee.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.udg.pds.simpleapp_javaee.rest.serializer.CustomEstacioListSerializer;

import javax.naming.CompositeName;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * Created by u1933 on 14/06/2017.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Comentari implements Serializable {
    private static final long serialVersionUID = 1L;

    public Comentari() {
        this.data = new Date();
    }

    public Comentari(String email, String assumpte, String text) {
        this.data = new Date();
        this.email = email;
        this.assumpte = assumpte;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    protected Long id;

    @JsonView(Views.Public.class)
    private String email;

    @JsonView(Views.Public.class)
    private String assumpte;

    @JsonView(Views.Public.class)
    private String text;

    @JsonView(Views.Public.class)
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssumpte() {
        return assumpte;
    }

    public void setAssumpte(String assumpte) {
        this.assumpte = assumpte;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date d) {
        this.data = data;
    }
}

