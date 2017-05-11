package org.udg.pds.simpleapp_javaee.service;

/**
 * Created by Charry on 03/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.rest.RESTService;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Stateless
@LocalBean
public class EstacioService {

    @PersistenceContext
    protected EntityManager em;


    public Collection<Estacio> getEstacions() {
        try {
            return em.createQuery("SELECT estacio FROM Estacio estacio").getResultList();
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public Estacio getEstacio(Long id) {
        try {
            Estacio e = em.find(Estacio.class, id);
            return e;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }
}
