/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udg.pds.simpleapp_javaee.util;

import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Tram;
import org.udg.pds.simpleapp_javaee.model.Color;
import org.udg.pds.simpleapp_javaee.model.Task;
import org.udg.pds.simpleapp_javaee.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class InitDB {

  @Inject
  private Logger log;

  @PersistenceContext
  private EntityManager em;

  @PostConstruct
  private void init() {
    log.log(Level.INFO, "INIT PDS DATABASE");

    try {
      User exists = em.find(User.class, 1L);
      if (exists == null) {
        User u = new User("jo", "jo@hotmail.com", "jo");
        em.persist(u);
        Task t1 = new Task(new Date(), new Date(), false, "Tasca numero 1");
        u.addTask(t1);
        t1.setUser(u);

        User u2 = new User("tu", "tu@hotmail.com", "tu");
        em.persist(u2);
        Task t2 = new Task(new Date(), new Date(), false, "Tasca numero 2");
        u2.addTask(t2);
        t2.setUser(u2);

        //afegirEstacions();
        //afegirColors();

        /*Color c1 = new Color("r11");
        Color c2 = new Color("r1");

        Estacio e1 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
        em.persist(e1);
        e1.addColor(c1);
        c1.addEstacio(e1);
        Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
        em.persist(e2);
        e2.addColor(c1);
        c1.addEstacio(e2);
        Estacio e3 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
        em.persist(e3);
        e3.addColor(c1);
        c1.addEstacio(e3);
        e3.addColor(c1);
        c2.addEstacio(e3);*/

        Color c1 = new Color("r11");
        em.persist(c1);
        Color c2 = new Color("r1");
        em.persist(c2);

        Estacio e1 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
        em.persist(e1);
        Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
        em.persist(e2);
        Estacio e3 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
        em.persist(e3);

        Tram tram1 = new Tram(7,22);
        em.persist(tram1);
        tram1.setEstacio(e3);

        Tram tram2 = new Tram(7,28);
        em.persist(tram2);
        tram2.setEstacio(e1);

        Tram tram3 = new Tram(7,48);
        em.persist(tram3);
        tram3.setEstacio(e2);

        Tram tram4 = new Tram(10,22);
        em.persist(tram4);
        tram4.setEstacio(e3);

        Tram tram5 = new Tram(10,28);
        em.persist(tram5);
        tram5.setEstacio(e1);

        Tram tram6 = new Tram(10,48);
        em.persist(tram6);
        tram6.setEstacio(e2);

        Tram tram7 = new Tram(12,22);
        em.persist(tram7);
        tram7.setEstacio(e3);

        Tram tram8 = new Tram(12,28);
        em.persist(tram8);
        tram8.setEstacio(e1);

        Tram tram9 = new Tram(12,48);
        em.persist(tram9);
        tram9.setEstacio(e2);


        e1.getColors().add(c1);
        e2.getColors().add(c1);
        e3.getColors().add(c1);
        e3.getColors().add(c2);

        /*e1.getTrams().add(tram2);
        e1.getTrams().add(tram5);
        e1.getTrams().add(tram8);
        e2.getTrams().add(tram3);
        e2.getTrams().add(tram6);
        e2.getTrams().add(tram9);
        e3.getTrams().add(tram1);
        e3.getTrams().add(tram4);
        e3.getTrams().add(tram7);*/

        /*c1.getEstacions().add(e1);
        c1.getEstacions().add(e2);
        c1.getEstacions().add(e3);
        c2.getEstacions().add(e3);*/

        /*e1.getColors().add(c1);
        c1.addEstacio(e1);
        e2.getColors().add(c1);
        c1.addEstacio(e2);
        e3.addColor(c1);
        c1.addEstacio(e3);
        e3.addColor(c2);
        c2.addEstacio(e3);*/

      } else {
        log.log(Level.INFO, "Initial user already exists");
      }

    } catch (Exception ex) {
      log.log(Level.INFO, "Error initializing database");
    }
  }

  private void afegirEstacions(){
    Estacio e1 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
    em.persist(e1);

    Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
    em.persist(e2);

    Estacio e3 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
    em.persist(e3);
  }

  private void afegirColors(){
    Color c1 = new Color("r11");
    em.persist(c1);

    Color c2 = new Color("r1");
    em.persist(c2);
  }
}
