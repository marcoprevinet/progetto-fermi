package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.TipoManager;
import it.previnet.progettofermi.bean.CodeDescription;
import it.previnet.progettofermi.presentation.port.service.TipoRestService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class TipoRestServiceImpl implements TipoRestService {

    @Inject
    TipoManager tipoManager;

    @Override
    public Response getTipoSesso() {
        List<CodeDescription> tipoSessoList = tipoManager.getTipoSesso();
        return Response.ok(tipoSessoList).build();
    }

    @Override
    public Response getTipoRecapito() {
        List<CodeDescription> tipoRecapitoList = tipoManager.getTipoRecapito();
        return Response.ok(tipoRecapitoList).build();
    }

    @Override
    public Response getTipoDocumento() {
        List<CodeDescription> tipoDocumentoList = tipoManager.getTipoDocumento();
        return Response.ok(tipoDocumentoList).build();
    }
}
