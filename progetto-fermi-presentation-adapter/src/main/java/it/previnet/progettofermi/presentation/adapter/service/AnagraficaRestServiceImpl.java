package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.AnagraficaManager;
import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.presentation.port.service.AnagraficaRestService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class AnagraficaRestServiceImpl implements AnagraficaRestService {
    private static final Logger logger = Logger.getLogger(AnagraficaRestServiceImpl.class);

    @Inject
    private AnagraficaManager anagraficaManager;

    @Override
    public Response getAnagrafica() {
        logger.info("REST SERVICE getAnagrafica");
        List<Nominativo> anagrafica = anagraficaManager.getAnagrafica();
        return Response.ok(anagrafica).build();
    }
}
