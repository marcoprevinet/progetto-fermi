package it.previnet.progettofermi.presentation.port.service;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("anagrafica")
public interface AnagraficaRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    @Path("/search")
    Response getAnagrafica();

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    @Path("/insert")
    Response postAnagrafica(MultipartFormDataInput input);
}
