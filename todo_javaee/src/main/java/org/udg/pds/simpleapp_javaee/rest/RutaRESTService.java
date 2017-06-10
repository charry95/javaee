package org.udg.pds.simpleapp_javaee.rest;

/**
 * Created by Charry on 17/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Color;
import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Ruta;
import org.udg.pds.simpleapp_javaee.model.Views;
import org.udg.pds.simpleapp_javaee.service.EstacioService;
import org.udg.pds.simpleapp_javaee.service.RutaService;
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

@Path("/ruta")
@RequestScoped
public class RutaRESTService extends RESTService{
    @EJB
    RutaService rutaService;

    @EJB
    EstacioService estacioService;

    @Inject
    ToJSON toJSON;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColor(@Context HttpServletRequest req,
                             @QueryParam("origen") Long idOrigen,
                             @QueryParam("desti") Long idDesti) {
        Collection<Ruta> rutes = null;
        estacioService.getEstacions();
        Estacio origen = estacioService.getEstacio(idOrigen);
        Estacio desti = estacioService.getEstacio(idDesti);
        if(origen!=null && desti!=null){
            List<Color> colorsOrigen = new ArrayList<Color>(origen.getColors());
            List<Color> colorsDesti = new ArrayList<Color>(desti.getColors());

            if(colorsDesti!=null && colorsOrigen!= null && colorsOrigen.get(0).getId().equals(colorsDesti.get(0).getId())){
                rutes = rutaService.getRutesNoTransbord(colorsOrigen.get(0),origen,desti);
            }
        }
        return buildResponseWithView(Views.Complete.class, rutes);
    }
}
