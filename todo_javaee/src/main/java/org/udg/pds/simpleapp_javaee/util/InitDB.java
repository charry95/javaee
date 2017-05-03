/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udg.pds.simpleapp_javaee.util;

import org.udg.pds.simpleapp_javaee.model.Estacio;
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

        Color c1 = new Color("r11");
        Color c2 = new Color("r1");

        Estacio e1 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
        Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
        Estacio e3 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);

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
