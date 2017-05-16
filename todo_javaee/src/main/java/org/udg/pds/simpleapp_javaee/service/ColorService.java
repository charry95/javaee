package org.udg.pds.simpleapp_javaee.service;

/**
 * Created by Charry on 14/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Color;
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
public class ColorService {

    @PersistenceContext
    protected EntityManager em;


    public Collection<Color> getColors() {
        try {
            return em.createQuery("SELECT color FROM Color color").getResultList();
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }

    public Color getColor(Long id) {
        try {
            Color c = em.find(Color.class, id);
            return c;
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an EJBException
            // We catch the normal exception and then transform it in a EJBException
            throw new EJBException(ex);
        }
    }
}



