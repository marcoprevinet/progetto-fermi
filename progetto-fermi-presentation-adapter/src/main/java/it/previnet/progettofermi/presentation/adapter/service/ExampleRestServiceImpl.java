package it.previnet.progettofermi.presentation.adapter.service;

import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.application.port.FermiException;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.presentation.port.service.ExampleRestService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ExampleRestServiceImpl implements ExampleRestService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(ExampleRestServiceImpl.class);

    @Inject
    ExampleManager exampleManager;

    @Override
    public List<ExampleInfo> fetch(ExampleSearch exampleSearch) {
        if(1==1) {
            List<String> messages = new ArrayList<String>();
            messages.add("messaggio 1");
            messages.add("messaggio 2");
            throw new FermiException(messages);
        }
        return exampleManager.fetch(exampleSearch);
    }

    @Override
    public ExampleInfo fetch(Long token) {
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
