package it.previnet.progettofermi.presentation.adapter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.application.port.FermiException;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;
import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.presentation.port.service.ExampleRestService;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;

@ApplicationScoped
public class ExampleRestServiceImpl implements ExampleRestService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(ExampleRestServiceImpl.class);

    @Inject
    ObjectMapper objectMapper; // converte JSON in oggetti Java e viceversa

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

    @Override
    public ExampleInfo insert(MultipartFormDataInput input) {
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();

        ExampleInfo exampleInfo = null;
        InputStream file = null;

        // leggo la parte "data" che contiene il JSON con i dati da inserire
        List<InputPart> dataParts = uploadForm.get("data");
        if (dataParts != null && !dataParts.isEmpty()) {
            InputPart dataPart = dataParts.get(0);
            try {
                String body = dataPart.getBody(String.class, null);
                exampleInfo = objectMapper.readValue(body, ExampleInfo.class);
            } catch (Exception e) {
                logger.error("catching exception", e);
            }
        }

        // leggo la parte "file" che contiene il file da salvare
        List<InputPart> fileParts = uploadForm.get("file");
        if (fileParts != null && !fileParts.isEmpty()) {
            InputPart filePart = fileParts.get(0);
            String filename = "";
            try {
                file = filePart.getBody(InputStream.class, null);
            } catch (Exception e) {
                logger.error("catching exception", e);
            }
        }

        if (exampleInfo != null && file != null) {
            return exampleManager.insert(exampleInfo);
        }

        return null;
    }

}
