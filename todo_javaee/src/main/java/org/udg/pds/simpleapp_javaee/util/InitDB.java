/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udg.pds.simpleapp_javaee.util;

import org.udg.pds.simpleapp_javaee.model.*;

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


        // modificacions
        Incidencia incidencia_test = new Incidencia("test incidencia",Long.decode("10"),Boolean.TRUE);
        em.persist(incidencia_test);

        Ruta r1 = new Ruta("dreta");
        em.persist(r1);

        Ruta r2 = new Ruta("dreta");
        em.persist(r2);

        Ruta r3 = new Ruta("esquerra");
        em.persist(r3);

        Ruta r4 = new Ruta("dreta");
        em.persist(r4);

        Ruta r5 = new Ruta("esquerra");
        em.persist(r5);

        Color c1 = new Color("r1");
        em.persist(c1);
        Color c11 = new Color("r11");
        em.persist(c11);
        r1.setColor(c11);
        r2.setColor(c11);
        r3.setColor(c11);
        r4.setColor(c11);
        r5.setColor(c11);
        Color c8 = new Color("r8");
        em.persist(c8);
        Color c2 = new Color("r2");
        em.persist(c2);

        /*ColorRelacio cr1 = new ColorRelacio(c1,c2);
        em.persist(cr1);
        c1.addColorcolor(cr1);
        ColorRelacio cr2 = new ColorRelacio(c2,c1);
        em.persist(cr2);
        c2.addColorcolor(cr2);*/
        //c1.addColor(c3);

        Estacio e1 = new Estacio(new Long(79315), "Portbou",42.424462,3.157686, null);

        em.persist(e1);
        e1.addColor(c11);
        //e1.addColor(c2);

        Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
        em.persist(e2);
        e2.addColor(c11);
        //e2.addColor(c2);

        Estacio e3 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
        em.persist(e3);
        e3.addColor(c11);
        //e3.addColor(c2);

        Estacio e4 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
        em.persist(e4);
        e4.addColor(c11);
        e4.addColor(c1);
        e4.addColor(c2);

        Estacio e5 = new Estacio(new Long(79604), "Pineda de mar",41.772461,2.674072, null);
        em.persist(e5);
        e5.addColor(c1);

        Estacio e6 = new Estacio(new Long(72209), "Martorell",41.747698,2.631290, null);
        em.persist(e6);
        e6.addColor(c8);

        Estacio e7 = new Estacio(new Long(79100), "Granollers Centre",41.747698,2.631290, null);
        em.persist(e7);
        e7.addColor(c11);
        e7.addColor(c8);

        Tram tram1 = new Tram(6,23,r1);
        em.persist(tram1);
        tram1.setEstacio(e1);

        Tram tram2 = new Tram(7,13,r1);
        em.persist(tram2);
        tram2.setEstacio(e2);

        Tram tram3 = new Tram(7,29,r1);
        em.persist(tram3);
        tram3.setEstacio(e3);

        Tram tram4 = new Tram(7,35,r1);
        em.persist(tram3);
        tram4.setEstacio(e4);

        Tram tram5 = new Tram(10,19,r2);
        em.persist(tram5);
        tram5.setEstacio(e2);

        Tram tram6 = new Tram(10,33,r2);
        em.persist(tram6);
        tram6.setEstacio(e3);

        Tram tram7 = new Tram(10,39,r2);
        em.persist(tram7);
        tram7.setEstacio(e4);

        Tram tram8 = new Tram(6,51,r3);
        em.persist(tram8);
        tram8.setEstacio(e4);

        Tram tram9 = new Tram(6,57,r3);
        em.persist(tram9);
        tram9.setEstacio(e3);

        Tram tram10 = new Tram(7,13,r3);
        em.persist(tram10);
        tram10.setEstacio(e2);

        Tram tram11 = new Tram(14,33,r4);
        em.persist(tram11);
        tram11.setEstacio(e1);

        Tram tram12 = new Tram(15,36,r4);
        em.persist(tram12);
        tram12.setEstacio(e2);

        Tram tram13 = new Tram(15,55,r4);
        em.persist(tram13);
        tram13.setEstacio(e3);

        Tram tram14 = new Tram(16,1,r4);
        em.persist(tram14);
        tram14.setEstacio(e4);

        Tram tram15 = new Tram(20,26,r5);
        em.persist(tram15);
        tram15.setEstacio(e4);

        Tram tram16 = new Tram(20,32,r5);
        em.persist(tram16);
        tram16.setEstacio(e3);

        Tram tram17 = new Tram(20,54,r5);
        em.persist(tram17);
        tram17.setEstacio(e2);

        Tram tram18 = new Tram(21,55,r5);
        em.persist(tram18);
        tram18.setEstacio(e1);

        incidencia_test.setColor(c1);

        em.flush();

        /*e1.getColors().add(c1);
        e2.getColors().add(c1);
        e3.getColors().add(c1);
        e3.getColors().add(c2);*/

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
}
