package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;

import java.io.InputStream;
import java.util.List;

public interface AnagraficaManager {

    List<Nominativo> getAnagrafica();

    Nominativo insertAnagrafica(AnagraficaRequest request, InputStream file);
}
