package org.udg.pds.simpleapp_javaee.rest;

/**
 * Created by Charry on 14/05/2017.
 */


import org.udg.pds.simpleapp_javaee.model.Color;
import org.udg.pds.simpleapp_javaee.model.Views;
import org.udg.pds.simpleapp_javaee.service.ColorService;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/color")
@RequestScoped
public class ColorRESTService extends RESTService{
    @EJB
    ColorService colorService;

    @Inject
    ToJSON toJSON;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllColors(@Context HttpServletRequest req) {
        Collection<Color> colors = colorService.getColors();
        return buildResponseWithView(Views.Public.class, colors);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColor(@Context HttpServletRequest req,
                               @PathParam("id") Long id) {
        Color c = colorService.getColor(id);
        return buildResponseWithView(Views.Complete.class, c);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColor(@Context HttpServletRequest req) {
        Color c1 = colorService.getColor(new Long(1));
        Color c8 = colorService.getColor(new Long(3));
        Color c11 = colorService.getColor(new Long(2));
        Collection<Color> r1 = colorService.getColorsEstacio(new Long(79604));
        //r1.add(c11);
        Collection<Color> r8 = colorService.getColorsEstacio(new Long(79100));
        //r8.add(c11);

        return buildResponseWithView(Views.Public.class, colorService.obtenirMinimaPermutacioColors(r1,r8));
    }
}

