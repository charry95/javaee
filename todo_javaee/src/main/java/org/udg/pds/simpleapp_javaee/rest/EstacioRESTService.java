package org.udg.pds.simpleapp_javaee.rest;

/**
 * Created by Charry on 02/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Views;
import org.udg.pds.simpleapp_javaee.service.EstacioService;
import org.udg.pds.simpleapp_javaee.util.ToJSON;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/estacio")
@RequestScoped
public class EstacioRESTService extends RESTService{
    @EJB
    EstacioService estacioService;

    @Inject
    ToJSON toJSON;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEstacions(@Context HttpServletRequest req) {
        Collection<Estacio> estacions = estacioService.getEstacions();
        return buildResponseWithView(Views.Public.class, estacions);
        //return buildResponse(estacioService.getEstacions());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstacio(@Context HttpServletRequest req,
                            @PathParam("id") Long id) {
        Estacio e = estacioService.getEstacio(id);
        return buildResponseWithView(Views.Private.class, e);
    }
}
