package org.udg.pds.simpleapp_javaee.rest;

import org.udg.pds.simpleapp_javaee.model.Comentari;
import org.udg.pds.simpleapp_javaee.service.ComentariService;
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

/**
 * Created by u1933 on 14/06/2017.
 */

@Path("/comentari")
@RequestScoped
public class ComentariRESTService {
    @EJB
    ComentariService comentariService;

    @Inject
    ToJSON toJSON;

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void putComentari(@Context HttpServletRequest req,
                             @QueryParam("email") String email,
                             @QueryParam("assumpte") String assumpte,
                             @QueryParam("text") String text) {
        Comentari com = new Comentari(email,assumpte,text);
        comentariService.addComentari(com);
    }
}