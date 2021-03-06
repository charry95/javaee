package org.udg.pds.simpleapp_javaee.service;

import org.udg.pds.simpleapp_javaee.model.*;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Charry on 17/05/2017.
 */

@Stateless
@LocalBean
public class RutaService {

    @PersistenceContext
    protected EntityManager em;

    public Collection<Ruta> getRutesNoTransbord(Color c, Estacio origen, Estacio desti) {
        try {
            Query q = em.createQuery("SELECT ruta FROM Ruta ruta WHERE ruta.color=:c");
            q.setParameter("c",c);
            List<Ruta> rutes = q.getResultList();
            eliminarRutesPerDireccio(rutes,origen.getId(),desti.getId());

           // Collection<Incidencia> llistaIncidencies = c.getIncidencies();
            //if(llistaIncidencies.size() != 0) {
            //    rutes = filtrarRutesIncidencies(rutes,llistaIncidencies);
            //}
            return rutes;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public Collection<Ruta> getRutesTransbord(ArrayList<Color> colors, Estacio origen, Estacio desti){
        //obtenir id estacio colisio entre 2 colors
        //obtenir rutes color: 1. que passin per origen i colisio 2. que passin per colisio
        // unir cadascuna de les rutes 1 amb la més propera de rutes 2
        //
        return null;
    }

    public void eliminarRutesPerDireccio(List<Ruta> rutes, Long origen, Long desti){
        List<Integer> indexRemove = new ArrayList<>();
        Integer contador = 0;
        for(Ruta act : rutes){
            if(!act.direccioCorrecte(origen,desti))
                indexRemove.add(contador);
            contador++;
        }
        Integer esborrats = 0;
        for(Integer index : indexRemove){
            rutes.remove((index-esborrats));
            esborrats++;
        }
    }

    public Collection<Ruta> getRutesColorEstacio(Color c, Estacio origen) {
        try {
            Query q = em.createQuery("SELECT ruta FROM Ruta ruta WHERE ruta.color=:c");
            q.setParameter("c",c);
            List<Ruta> rutes = q.getResultList();
            eliminarRutesSenseEstacio(rutes,origen.getId());
            return rutes;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public void eliminarRutesSenseEstacio(List<Ruta> rutes, Long origen){
        List<Integer> indexRemove = new ArrayList<>();
        Integer contador = 0;
        for(Ruta act : rutes){
            if(!act.conteEstacio(origen))
                indexRemove.add(contador);
            contador++;
        }
        Integer esborrats = 0;
        for(Integer index : indexRemove){
            rutes.remove((index-esborrats));
            esborrats++;
        }
    }

    public List<Ruta> filtrarRutesIncidencies(List<Ruta> rutes, Collection<Incidencia> llistaIncidencies) {
        Integer retardTotal = 0;
        for(Incidencia in : llistaIncidencies){
            if(in.getActiva()) {
                retardTotal = retardTotal + in.getRetard().intValue();
            }
        }
        for(Ruta rut : rutes) {
            rut.sumarRetard(retardTotal);
        }
        return rutes;
    }

    public void unirLlistatRutes (List<Ruta> llistatRutesEsq, List<Ruta> llistatRutesDre, Long idEstacioOrigen) {
        Integer contador = 0;
        for(Ruta r_dreta : llistatRutesDre){
            contador = 0;
            Integer horaIniciDreta = r_dreta.getTram(idEstacioOrigen).getHora();
            Integer minIniciDreta = r_dreta.getTram(idEstacioOrigen).getMinut();
            for(Ruta r_esquerra : llistatRutesEsq) {
                Integer horaIniciEsq = r_esquerra.getTram(idEstacioOrigen).getHora();
                Integer minIniciEsq = r_esquerra.getTram(idEstacioOrigen).getMinut();
                if(horaIniciDreta < horaIniciEsq || ((horaIniciDreta == horaIniciEsq) && (minIniciDreta < minIniciEsq))) {
                    break;
                }
                contador++;
            }
            llistatRutesEsq.add(contador,r_dreta);
        }
    }
}
