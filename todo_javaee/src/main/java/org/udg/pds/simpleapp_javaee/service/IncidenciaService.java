package org.udg.pds.simpleapp_javaee.service;

import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Incidencia;
import org.udg.pds.simpleapp_javaee.rest.RESTService;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by u1933 on 13/06/2017.
 */

@Stateless
@LocalBean
public class IncidenciaService {
    @PersistenceContext
    protected EntityManager em;


    public Collection<Incidencia> getIncidencies() {
        try {
            return em.createQuery("SELECT incidencia FROM Incidencia incidencia").getResultList();
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }
}