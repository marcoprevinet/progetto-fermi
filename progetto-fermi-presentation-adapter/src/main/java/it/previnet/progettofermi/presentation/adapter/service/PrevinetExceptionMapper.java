package it.previnet.progettofermi.presentation.adapter.service;

import java.util.Locale;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.previnet.progettofermi.application.port.FermiException;


@Provider
public class PrevinetExceptionMapper implements ExceptionMapper<FermiException> {
    private static final Logger logger = LoggerFactory.getLogger(PrevinetExceptionMapper.class);
    private static final int RESPONSE_STATUS_ERROR_MESSAGES_ERROR = 444;

    private Response handlePrevinetBusinessLogicException(FermiException e, Locale locale) {
        logger.debug("PrevinetExceptionMapper.handlePrevinetBusinessLogicException", e);
        return Response.status(RESPONSE_STATUS_ERROR_MESSAGES_ERROR).entity(e.getMessages()).type(MediaType.APPLICATION_JSON + ";charset=UTF-8")
                .build();
    }

    @Override
    public Response toResponse(FermiException e) {
        Locale locale = Locale.getDefault();
        return this.handlePrevinetBusinessLogicException(e, locale);
    }
}
