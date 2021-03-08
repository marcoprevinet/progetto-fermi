package it.previnet.progettofermi.presentation.port.service;

import io.vertx.ext.web.multipart.MultipartForm;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

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
    List<ExampleInfo> fetch(@BeanParam ExampleSearch applicazioneSearch);

    @GET
    @Path("/search/{token}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @PermitAll
    ExampleInfo fetch(@PathParam("token") @NotNull Integer token);

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @PermitAll
    ExampleInfo insert(MultipartFormDataInput input);
}
