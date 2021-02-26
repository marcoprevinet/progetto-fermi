package it.previnet.progettofermi.presentation.port.service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tipo")
public interface TipoRestService {

    @GET
    @Path("sesso")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    Response getTipoSesso();

    @GET
    @Path("recapito")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    Response getTipoRecapito();

    @GET
    @Path("documento")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    Response getTipoDocumento();
}
