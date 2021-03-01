package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.CodeDescription;
import it.previnet.progettofermi.bean.enums.TipoPersona;

import java.util.List;

public interface TipoManager {

    List<CodeDescription> getTipoSesso(TipoPersona tipoPersona);

    List<CodeDescription> getTipoRecapito(TipoPersona tipoPersona);

    List<CodeDescription> getTipoDocumento(TipoPersona tipoPersona);
}
