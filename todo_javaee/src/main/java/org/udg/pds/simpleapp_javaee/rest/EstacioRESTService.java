package org.udg.pds.simpleapp_javaee.rest;

/**
 * Created by Charry on 02/05/2017.
 */

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

        return buildResponse(estacioService.getEstacions());
    }
}
