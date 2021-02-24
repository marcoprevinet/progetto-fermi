package it.previnet.progettofermi.presentation.port.service;

import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.NominativoSearch;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("example")
public interface ExampleRestService {

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    List<ExampleInfo> fetch(@BeanParam NominativoSearch applicazioneSearch);

    @GET
    @Path("/search/{token}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    ExampleInfo fetch(@NotNull @PathParam("token") Integer token);

}
