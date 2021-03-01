package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.TipoManager;
import it.previnet.progettofermi.bean.CodeDescription;
import it.previnet.progettofermi.bean.enums.TipoPersona;
import it.previnet.progettofermi.presentation.port.service.TipoRestService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class TipoRestServiceImpl implements TipoRestService {

    @Inject
    private TipoManager tipoManager;

    @Override
    public Response getTipoSesso(String persona) {
        List<CodeDescription> tipoSessoList = tipoManager.getTipoSesso(TipoPersona.lookup(persona));
        return Response.ok(tipoSessoList).build();
    }

    @Override
    public Response getTipoRecapito(String persona) {
        List<CodeDescription> tipoRecapitoList = tipoManager.getTipoRecapito(TipoPersona.lookup(persona));
        return Response.ok(tipoRecapitoList).build();
    }

    @Override
    public Response getTipoDocumento(String persona) {
        List<CodeDescription> tipoDocumentoList = tipoManager.getTipoDocumento(TipoPersona.lookup(persona));
        return Response.ok(tipoDocumentoList).build();
    }
}
