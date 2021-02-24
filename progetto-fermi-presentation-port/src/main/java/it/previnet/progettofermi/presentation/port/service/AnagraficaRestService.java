package it.previnet.progettofermi.presentation.port.service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("anagrafica")
public interface AnagraficaRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    Response getAnagrafica();

    /*
    @POST
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    @PermitAll
    String postAnagrafica();
    */
}
