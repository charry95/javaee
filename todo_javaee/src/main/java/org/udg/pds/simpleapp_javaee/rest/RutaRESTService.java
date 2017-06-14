package org.udg.pds.simpleapp_javaee.rest;

/**
 * Created by Charry on 17/05/2017.
 */

import org.udg.pds.simpleapp_javaee.model.Color;
import org.udg.pds.simpleapp_javaee.model.Estacio;
import org.udg.pds.simpleapp_javaee.model.Ruta;
import org.udg.pds.simpleapp_javaee.model.Views;
import org.udg.pds.simpleapp_javaee.service.ColorService;
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

    @EJB
    ColorService colorService;

    @Inject
    ToJSON toJSON;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRutes(@Context HttpServletRequest req,
                             @QueryParam("origen") Long idOrigen,
                             @QueryParam("desti") Long idDesti) {
        List<Ruta> rutes = new ArrayList<>();
        Estacio origen = estacioService.getEstacio(idOrigen);
        Estacio desti = estacioService.getEstacio(idDesti);
        if(origen!=null && desti!=null){
            List<Color> colorsOrigen = new ArrayList<Color>(origen.getColors());
            List<Color> colorsDesti = new ArrayList<Color>(desti.getColors());

            if(colorsDesti!=null && colorsOrigen!= null){
                ArrayList<ArrayList<Color>> permutacions = colorService.obtenirMinimaPermutacioColors(colorsOrigen, colorsDesti);
                Boolean transbord = false;
                for(ArrayList<Color> permutacio : permutacions){
                    transbord = permutacio.size()>1;
                    if(transbord)
                        break;
                }
                if(!transbord){
                    for(ArrayList<Color> permutacio : permutacions){
                        List<Ruta> rutesColor = new ArrayList<>();
                        Collection<Ruta> rutaColor = rutaService.getRutesNoTransbord(permutacio.get(0),origen,desti);
                        rutesColor.addAll(rutaColor);
                        rutaService.unirLlistatRutes(rutes, rutesColor, origen.getId());
                    }
                }
                /*else{
                    for(ArrayList<Color> permutacio : permutacions){
                        List<Ruta> listRutesPermutacio = new ArrayList<>();
                        Collection<Ruta> rutesPermutacio = rutaService.getRutesTransbord(permutacio,origen,desti);
                        listRutesPermutacio.addAll(rutesPermutacio);
                        //fusionar listRutesPermutacio amb rutes
                    }
                    //podar per hora darribada/sortida
                }*/
            }
        }
        return buildResponseWithView(Views.Complete.class, rutes);
    }
}
