package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;
import it.previnet.progettofermi.bean.request.NominativoSearch;

import java.io.InputStream;
import java.util.List;

public interface AnagraficaManager {

    List<Nominativo> getAnagrafica(NominativoSearch search);

    Nominativo insertAnagrafica(AnagraficaRequest request, InputStream file);
}
