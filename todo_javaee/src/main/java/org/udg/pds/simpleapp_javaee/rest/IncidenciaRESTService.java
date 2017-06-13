package org.udg.pds.simpleapp_javaee.rest;

import org.udg.pds.simpleapp_javaee.model.Incidencia;
import org.udg.pds.simpleapp_javaee.model.Views;
import org.udg.pds.simpleapp_javaee.service.IncidenciaService;
import org.udg.pds.simpleapp_javaee.util.ToJSON;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by u1933 on 13/06/2017.
 */

@Path("/incidencia")
@RequestScoped
public class IncidenciaRESTService extends RESTService {
    @EJB
    IncidenciaService incidenciaService;

    @Inject
    ToJSON toJSON;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIncidencies(@Context HttpServletRequest req) {
        Collection<Incidencia> incidencies = incidenciaService.getIncidencies();
        return buildResponseWithView(Views.Public.class, incidencies);
    }
}
