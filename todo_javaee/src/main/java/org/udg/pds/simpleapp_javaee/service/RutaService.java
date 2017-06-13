package org.udg.pds.simpleapp_javaee.service;

import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Ruta;
import org.udg.pds.simpleapp_javaee.model.Color;

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
            return rutes;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
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

    public Collection<Ruta> llistatRutes(Color c, Estacio origen) {
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
}
