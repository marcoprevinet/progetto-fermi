package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.CodeDescription;

import java.util.List;

public interface TipoManager {

    List<CodeDescription> getTipoSesso();

    List<CodeDescription> getTipoRecapito();

    List<CodeDescription> getTipoDocumento();
}
