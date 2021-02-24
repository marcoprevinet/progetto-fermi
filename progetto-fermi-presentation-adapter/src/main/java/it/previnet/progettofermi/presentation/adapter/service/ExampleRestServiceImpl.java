package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.presentation.port.service.ExampleRestService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ExampleRestServiceImpl implements ExampleRestService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(ExampleRestServiceImpl.class);

    @Inject
    ExampleManager exampleManager;

    @Override
    public List<ExampleInfo> fetch(NominativoSearch exampleSearch) {
        return exampleManager.fetch(exampleSearch);
    }

    @Override
    public ExampleInfo fetch(Integer token) {
        NominativoSearch exampleSearch= new NominativoSearch();
        exampleSearch.setToken(token);
        Optional<ExampleInfo> optionalExampleInfo= exampleManager.fetch(exampleSearch).stream().findFirst();
        if (optionalExampleInfo.isPresent()){
            return optionalExampleInfo.get();
        } else {
            return null;
        }
    }

}
