package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.presentation.port.service.ExampleRestService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ExampleRestServiceImpl implements ExampleRestService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(ExampleRestServiceImpl.class);

    @Inject
    ExampleManager exampleManager;

    @Override
    public List<ExampleInfo> fetch(ExampleSearch exampleSearch) {
        return exampleManager.fetch(exampleSearch);
    }

    @Override
    public ExampleInfo fetch(@NotNull Integer token) {
        ExampleSearch exampleSearch= new ExampleSearch();
        exampleSearch.setToken(token);
        Optional<ExampleInfo> optionalExampleInfo= exampleManager.fetch(exampleSearch).stream().findFirst();
        if (optionalExampleInfo.isPresent()){
            return optionalExampleInfo.get();
        } else {
            return null;
        }
    }

}
