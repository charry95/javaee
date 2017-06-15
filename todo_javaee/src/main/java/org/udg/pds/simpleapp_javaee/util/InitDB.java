/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.udg.pds.simpleapp_javaee.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
        Incidencia incidencia_test = new Incidencia("test incidencia",Long.decode("10"),Boolean.FALSE);
        em.persist(incidencia_test);
        Incidencia inc = new Incidencia("Atropellament d'una persona a l'estació de Girona",Long.decode("20"), Boolean.TRUE);
        em.persist(inc);

        Tren reg = new Tren("Serie 447", "Regional");
        em.persist(reg);

        Tren md = new Tren("Serie 449", "MD");
        em.persist(md);

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
        /****/
        Ruta r6 = new Ruta("esquerra");
        em.persist(r6);
        /****/

        Ruta r7 = new Ruta("dreta");
        em.persist(r7);

        Ruta r8 = new Ruta("dreta");
        em.persist(r8);

        Ruta r9 = new Ruta("esquerra");
        em.persist(r9);

        Ruta r10 = new Ruta("esquerra");
        em.persist(r10);

        Ruta r11 = new Ruta("dreta");
        em.persist(r11);

        Ruta r12 = new Ruta("dreta");
        em.persist(r12);

        Ruta r13 = new Ruta("dreta");
        em.persist(r13);

        Ruta r14 = new Ruta("esquerra");
        em.persist(r14);

        r1.setTren(reg);
        r2.setTren(reg);
        r3.setTren(md);
        r4.setTren(md);
        r5.setTren(reg);
        r6.setTren(reg);
        r7.setTren(reg);
        r8.setTren(reg);
        r9.setTren(reg);
        r10.setTren(reg);
        r11.setTren(reg);
        r12.setTren(reg);
        r13.setTren(reg);
        r14.setTren(reg);


        Color c1 = new Color("r1");
        em.persist(c1);
        r6.setColor(c1);
        r7.setColor(c1);
        r8.setColor(c1);
        r9.setColor(c1);

        Color c11 = new Color("r11");
        em.persist(c11);
        r1.setColor(c11);
        r2.setColor(c11);
        r3.setColor(c11);
        r4.setColor(c11);
        r5.setColor(c11);

        Color c8 = new Color("r8");
        em.persist(c8);
        r10.setColor(c8);
        r11.setColor(c8);
        r12.setColor(c8);

        Color c2 = new Color("r2");
        em.persist(c2);
        r13.setColor(c2);
        r14.setColor(c2);



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
        e1.addColor(c1);

        Estacio e2 = new Estacio(new Long(79300), "Girona",41.979116,2.817076, null);
        em.persist(e2);
        e2.addColor(c11);
        e2.addColor(c1);

        Estacio e3 = new Estacio(new Long(79202),"Sils",41.807685,2.744855, null);
        em.persist(e3);
        e3.addColor(c11);
        e3.addColor(c1);

        Estacio e4 = new Estacio(new Long(79200), "Maçanet-Massanes",41.772461,2.674072, null);
        em.persist(e4);
        e4.addColor(c11);
        e4.addColor(c1);
        e4.addColor(c2);

        Estacio e5 = new Estacio(new Long(79604), "Pineda de Mar",41.772461,2.674072, null);
        em.persist(e5);
        e5.addColor(c1);

        Estacio e6 = new Estacio(new Long(72209), "Martorell",41.747698,2.631290, null);
        em.persist(e6);
        e6.addColor(c8);

        Estacio e7 = new Estacio(new Long(79100), "Granollers Centre",41.747698,2.631290, null);
        em.persist(e7);
        e7.addColor(c11);
        e7.addColor(c8);
        e7.addColor(c2);

        Estacio e8 = new Estacio(new Long(72305),"L'Hospitalet de Llobregat",41.747698,2.631290,null);
        em.persist(e8);
        e8.addColor(c1);

        Estacio e9 = new Estacio(new Long(79500),"Mataró",41.747698,2.631290,null);
        em.persist(e9);
        e9.addColor(c1);

        Estacio e10 = new Estacio(new Long(71801),"Barcelona-Sants",41.747698,2.631290,null);
        em.persist(e10);
        e10.addColor(c1);
        e10.addColor(c11);
        e10.addColor(c2);

        Estacio e11 = new Estacio(new Long(79009), "Barcelona-El Clot Aragó",41.747698,2.631290,null);
        em.persist(e11);
        e11.addColor(c1);
        e11.addColor(c11);
        e11.addColor(c2);

        Estacio e12 = new Estacio(new Long(79404),"Badalona",41.747698,2.631290,null);
        em.persist(e12);
        e12.addColor(c1);

        Estacio e13 = new Estacio(new Long(79603),"Calella",41.747698,2.631290,null);
        em.persist(e13);
        e13.addColor(c1);

        Estacio e14 = new Estacio(new Long(79606),"Blanes",41.747698,2.631290,null);
        em.persist(e14);
        e14.addColor(c1);

        Estacio e15 = new Estacio(new Long(79309),"Figueres",41.747698,2.631290,null);
        em.persist(e15);
        e15.addColor(c1);
        e15.addColor(c11);

        Estacio e16 = new Estacio(new Long(71705),"Castelldefels",41.747698,2.631290,null);
        em.persist(e16);
        e16.addColor(c2);

        Tram tram21 = new Tram(6,8,r7);
        em.persist(tram21);
        tram21.setEstacio(e8);

        Tram tram22 = new Tram(6,16,r7);
        em.persist(tram22);
        tram22.setEstacio(e10);

        Tram tram23 = new Tram(6,27,r7);
        em.persist(tram23);
        tram23.setEstacio(e11);

        Tram tram24 = new Tram(6,40,r7);
        em.persist(tram24);
        tram24.setEstacio(e12);

        Tram tram25 = new Tram(7,04,r7);
        em.persist(tram25);
        tram25.setEstacio(e9);

        Tram tram26 = new Tram(7,28,r7);
        em.persist(tram26);
        tram26.setEstacio(e13);

        Tram tram27 = new Tram(7,33,r7);
        em.persist(tram27);
        tram27.setEstacio(e5);

        Tram tram28 = new Tram(7,45,r7);
        em.persist(tram28);
        tram28.setEstacio(e14);

        Tram tram29 = new Tram(8,00,r7);
        em.persist(tram29);
        tram29.setEstacio(e4);

        Tram tram30 = new Tram(8,07,r7);
        em.persist(tram30);
        tram30.setEstacio(e3);

        Tram tram31 = new Tram(8,26,r7);
        em.persist(tram31);
        tram31.setEstacio(e2);

        Tram tram32 = new Tram(9,03,r7);
        em.persist(tram32);
        tram32.setEstacio(e15);

        Tram tram33 = new Tram(11,38,r8);
        em.persist(tram33);
        tram33.setEstacio(e8);

        Tram tram34 = new Tram(11,46,r8);
        em.persist(tram34);
        tram34.setEstacio(e10);

        Tram tram35 = new Tram(11,57,r8);
        em.persist(tram35);
        tram35.setEstacio(e11);

        Tram tram36 = new Tram(12,10,r8);
        em.persist(tram36);
        tram36.setEstacio(e12);

        Tram tram37 = new Tram(12,34,r8);
        em.persist(tram37);
        tram37.setEstacio(e9);

        Tram tram38 = new Tram(12,53,r8);
        em.persist(tram38);
        tram38.setEstacio(e13);

        Tram tram39 = new Tram(13,03,r8);
        em.persist(tram39);
        tram39.setEstacio(e5);

        Tram tram40 = new Tram(13,15,r8);
        em.persist(tram40);
        tram40.setEstacio(e14);

        Tram tram41 = new Tram(13,30,r8);
        em.persist(tram41);
        tram41.setEstacio(e4);

        Tram tram42 = new Tram(13,37,r8);
        em.persist(tram42);
        tram42.setEstacio(e3);

        Tram tram43 = new Tram(13,56,r8);
        em.persist(tram43);
        tram43.setEstacio(e2);

        Tram tram44 = new Tram(14,33,r8);
        em.persist(tram44);
        tram44.setEstacio(e15);

        Tram tram45 = new Tram(14,56,r8);
        em.persist(tram45);
        tram45.setEstacio(e1);

        Tram tram46 = new Tram(7,38,r6);
        em.persist(tram46);
        tram46.setEstacio(e1);

        Tram tram47 = new Tram(8,01,r6);
        em.persist(tram47);
        tram47.setEstacio(e15);

        Tram tram48 = new Tram(8,38,r6);
        em.persist(tram48);
        tram48.setEstacio(e2);

        Tram tram49 = new Tram(8,57,r6);
        em.persist(tram49);
        tram49.setEstacio(e3);

        Tram tram50 = new Tram(9,04,r6);
        em.persist(tram50);
        tram50.setEstacio(e4);

        Tram tram51 = new Tram(9,16,r6);
        em.persist(tram51);
        tram51.setEstacio(e14);

        Tram tram52 = new Tram(9,26,r6);
        em.persist(tram52);
        tram52.setEstacio(e5);

        Tram tram53 = new Tram(9,29,r6);
        em.persist(tram53);
        tram53.setEstacio(e13);

        Tram tram54 = new Tram(9,53,r6);
        em.persist(tram54);
        tram54.setEstacio(e9);

        Tram tram55 = new Tram(10,16,r6);
        em.persist(tram55);
        tram55.setEstacio(e12);

        Tram tram56 = new Tram(10,29,r6);
        em.persist(tram56);
        tram56.setEstacio(e11);

        Tram tram57 = new Tram(10,41,r6);
        em.persist(tram57);
        tram57.setEstacio(e10);

        Tram tram58 = new Tram(10,48,r6);
        em.persist(tram58);
        tram58.setEstacio(e8);

        Tram tram59 = new Tram(18,56,r9);
        em.persist(tram59);
        tram59.setEstacio(e15);

        Tram tram60 = new Tram(19,35,r9);
        em.persist(tram60);
        tram60.setEstacio(e2);

        Tram tram61 = new Tram(19,54,r9);
        em.persist(tram61);
        tram61.setEstacio(e3);

        Tram tram62 = new Tram(20,01,r9);
        em.persist(tram62);
        tram62.setEstacio(e4);

        Tram tram63 = new Tram(20,13,r9);
        em.persist(tram63);
        tram63.setEstacio(e14);

        Tram tram64 = new Tram(20,24,r9);
        em.persist(tram64);
        tram64.setEstacio(e5);

        Tram tram65 = new Tram(20,28,r9);
        em.persist(tram65);
        tram65.setEstacio(e13);

        Tram tram66 = new Tram(20,53,r9);
        em.persist(tram66);
        tram66.setEstacio(e9);

        Tram tram67 = new Tram(21,16,r9);
        em.persist(tram67);
        tram67.setEstacio(e12);

        Tram tram68 = new Tram(21,28,r9);
        em.persist(tram68);
        tram68.setEstacio(e11);

        Tram tram69 = new Tram(21,40,r9);
        em.persist(tram69);
        tram69.setEstacio(e10);

        Tram tram70 = new Tram(21,47,r9);
        em.persist(tram70);
        tram70.setEstacio(e8);

        Tram tram71 = new Tram(9,16,r1);
        em.persist(tram71);
        tram71.setEstacio(e10);

        Tram tram72 = new Tram(9,24,r1);
        em.persist(tram72);
        tram72.setEstacio(e11);

        Tram tram73 = new Tram(9,46,r1);
        em.persist(tram73);
        tram73.setEstacio(e7);

        Tram tram74 = new Tram(10,22,r1);
        em.persist(tram74);
        tram74.setEstacio(e4);

        Tram tram75 = new Tram(10,28,r1);
        em.persist(tram75);
        tram75.setEstacio(e3);

        Tram tram76 = new Tram(10,49,r1);
        em.persist(tram76);
        tram76.setEstacio(e2);

        Tram tram77 = new Tram(11,29,r1);
        em.persist(tram77);
        tram77.setEstacio(e15);

        Tram tram78 = new Tram(11,53,r1);
        em.persist(tram78);
        tram78.setEstacio(e1);

        Tram tram79 = new Tram(19,16,r2);
        em.persist(tram79);
        tram79.setEstacio(e10);

        Tram tram80 = new Tram(19,24,r2);
        em.persist(tram80);
        tram80.setEstacio(e11);

        Tram tram81 = new Tram(19,47,r2);
        em.persist(tram81);
        tram81.setEstacio(e7);

        Tram tram82 = new Tram(20,26,r2);
        em.persist(tram82);
        tram82.setEstacio(e4);

        Tram tram83 = new Tram(20,32,r2);
        em.persist(tram83);
        tram83.setEstacio(e3);

        Tram tram84 = new Tram(20,54,r2);
        em.persist(tram84);
        tram84.setEstacio(e2);

        Tram tram85 = new Tram(21,30,r2);
        em.persist(tram85);
        tram85.setEstacio(e15);

        Tram tram86 = new Tram(21,55,r2);
        em.persist(tram86);
        tram86.setEstacio(e1);

        Tram tram87 = new Tram(13,27,r3);
        em.persist(tram87);
        tram87.setEstacio(e1);

        Tram tram88 = new Tram(13,49,r3);
        em.persist(tram88);
        tram88.setEstacio(e15);

        Tram tram89 = new Tram(14,19,r3);
        em.persist(tram89);
        tram89.setEstacio(e2);

        Tram tram90 = new Tram(14,33,r3);
        em.persist(tram90);
        tram90.setEstacio(e3);

        Tram tram91 = new Tram(14,39,r3);
        em.persist(tram91);
        tram91.setEstacio(e4);

        Tram tram92 = new Tram(15,29,r3);
        em.persist(tram92);
        tram92.setEstacio(e11);

        Tram tram93 = new Tram(15,39,r3);
        em.persist(tram93);
        tram93.setEstacio(e10);

        Tram tram94 = new Tram(18,16,r4);
        em.persist(tram94);
        tram94.setEstacio(e10);

        Tram tram95 = new Tram(18,25,r4);
        em.persist(tram95);
        tram95.setEstacio(e11);

        Tram tram96 = new Tram(19,13,r4);
        em.persist(tram96);
        tram96.setEstacio(e4);

        Tram tram97 = new Tram(19,19,r4);
        em.persist(tram97);
        tram97.setEstacio(e3);

        Tram tram98 = new Tram(19,35,r4);
        em.persist(tram98);
        tram98.setEstacio(e2);

        Tram tram99 = new Tram(20,06,r4);
        em.persist(tram99);
        tram99.setEstacio(e15);

        Tram tram100 = new Tram(8,33,r5);
        em.persist(tram100);
        tram100.setEstacio(e1);

        Tram tram101 = new Tram(8,58,r5);
        em.persist(tram101);
        tram101.setEstacio(e15);

        Tram tram102 = new Tram(9,36,r5);
        em.persist(tram102);
        tram102.setEstacio(e2);

        Tram tram103 = new Tram(9,55,r5);
        em.persist(tram103);
        tram103.setEstacio(e3);

        Tram tram104 = new Tram(10,01,r5);
        em.persist(tram104);
        tram104.setEstacio(e4);

        Tram tram105 = new Tram(10,35,r5);
        em.persist(tram105);
        tram105.setEstacio(e7);

        Tram tram106 = new Tram(10,59,r5);
        em.persist(tram106);
        tram106.setEstacio(e11);

        Tram tram107 = new Tram(11,10,r5);
        em.persist(tram107);
        tram107.setEstacio(e10);

        Tram tram108 = new Tram(10,32,r10);
        em.persist(tram108);
        tram108.setEstacio(e7);

        Tram tram109 = new Tram(11,11,r10);
        em.persist(tram109);
        tram109.setEstacio(e6);

        Tram tram110 = new Tram(8,18,r11);
        em.persist(tram110);
        tram110.setEstacio(e6);

        Tram tram111 = new Tram(9,00,r11);
        em.persist(tram111);
        tram111.setEstacio(e7);

        Tram tram112 = new Tram(19,30,r12);
        em.persist(tram112);
        tram112.setEstacio(e6);

        Tram tram113 = new Tram(20,13,r12);
        em.persist(tram113);
        tram113.setEstacio(e7);

        Tram tram114 = new Tram(7,03,r13);
        em.persist(tram114);
        tram114.setEstacio(e4);

        Tram tram115 = new Tram(7,43,r13);
        em.persist(tram115);
        tram115.setEstacio(e7);

        Tram tram116 = new Tram(8,10,r13);
        em.persist(tram116);
        tram116.setEstacio(e11);

        Tram tram117 = new Tram(8,23,r13);
        em.persist(tram117);
        tram117.setEstacio(e10);

        Tram tram118 = new Tram(8,45,r13);
        em.persist(tram118);
        tram118.setEstacio(e16);

        Tram tram119 = new Tram(19,24,r14);
        em.persist(tram119);
        tram119.setEstacio(e16);

        Tram tram120 = new Tram(19,49,r14);
        em.persist(tram120);
        tram120.setEstacio(e10);

        Tram tram121 = new Tram(19,59,r14);
        em.persist(tram121);
        tram121.setEstacio(e11);

        Tram tram122 = new Tram(20,27,r14);
        em.persist(tram122);
        tram122.setEstacio(e7);

        Tram tram123 = new Tram(21,06,r14);
        em.persist(tram123);
        tram123.setEstacio(e4);







        incidencia_test.setColor(c1);
        inc.setColor(c1);


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
