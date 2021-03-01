package it.previnet.progettofermi.presentation.adapter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.previnet.progettofermi.application.port.AnagraficaManager;
import it.previnet.progettofermi.application.port.FermiException;
import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.presentation.port.service.AnagraficaRestService;
import org.apache.commons.collections4.CollectionUtils;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class AnagraficaRestServiceImpl implements AnagraficaRestService {
    private static final Logger logger = Logger.getLogger(AnagraficaRestServiceImpl.class);

    private static final Pattern FILENAME_PATTERN = Pattern.compile(".*filename=\"(.*)\"");

    @Inject
    ObjectMapper objectMapper;

    @Inject
    AnagraficaManager anagraficaManager;

    @Override
    public Response getAnagrafica(NominativoSearch search) {
        logger.info("REST SERVICE getAnagrafica");
        List<Nominativo> anagrafica = anagraficaManager.getAnagrafica(search);
        return Response.ok(anagrafica).build();
    }

    @Override
    public Response postAnagrafica(MultipartFormDataInput input) {
        logger.info("REST SERVICE postAnagrafica");

        List<String> errors = new ArrayList<>();
        AnagraficaRequest anagraficaRequest = null;
        InputStream file = null;

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> dataParts = uploadForm.get("data");
        if (CollectionUtils.isEmpty(dataParts)) {
            errors.add("Missing data part");
        } else {
            InputPart dataPart = dataParts.get(0);
            try {
                String body = dataPart.getBody(String.class, null);
                anagraficaRequest = objectMapper.readValue(body, AnagraficaRequest.class);
            } catch (Exception e) {
                logger.error("catching exception", e);
                throw new FermiException(Arrays.asList("invalid data part", e.getMessage()));
            }
        }

        List<InputPart> fileParts = uploadForm.get("file");
        if (CollectionUtils.isEmpty(fileParts)) {
            logger.error("missing file part");
            errors.add("Missing file part");
        } else {
            InputPart filePart = fileParts.get(0);
            String filename = "";
            try {
                file = filePart.getBody(InputStream.class, null);
                MultivaluedMap<String, String> headers = filePart.getHeaders();
                if (!Objects.isNull(headers)) {
                    String partHeader = headers.getFirst("Content-Disposition");
                    Matcher matcher = FILENAME_PATTERN.matcher(partHeader);
                    if (matcher.matches()) {
                        filename = matcher.group(1);
                        logger.info("reading uploaded file: " + filename);
                    } else {
                        logger.info("reading uploaded file");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                errors.add(e.getMessage());
            }
        }

        if (!errors.isEmpty()) {
            throw new FermiException(errors);
        }

        Nominativo nominativo = anagraficaManager.insertAnagrafica(anagraficaRequest, file);

        return Response.ok(nominativo).build();
    }
}
