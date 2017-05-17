package org.udg.pds.simpleapp_javaee.service;

import org.udg.pds.simpleapp_javaee.model.Ruta;
import org.udg.pds.simpleapp_javaee.model.Color;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Charry on 17/05/2017.
 */

@Stateless
@LocalBean
public class RutaService {

    @PersistenceContext
    protected EntityManager em;

    public Collection<Ruta> getRutes(Color c) {
        try {
            return em.createQuery("SELECT ruta FROM Ruta ruta WHERE ruta.color=: c").getResultList();
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }
}
