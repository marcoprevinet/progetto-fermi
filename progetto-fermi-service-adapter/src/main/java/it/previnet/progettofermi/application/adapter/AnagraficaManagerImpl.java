package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.adapter.mapper.NominativoEntityNominativoMapper;
import it.previnet.progettofermi.application.port.AnagraficaManager;
import it.previnet.progettofermi.application.port.FermiException;
import it.previnet.progettofermi.bean.DocumentoIdentificazione;
import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.bean.RecapitoNominativo;
import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;
import it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo;
import it.previnet.progettofermi.bean.enums.TipoSesso;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.repository.port.DocumentoIdentificazioneRepository;
import it.previnet.progettofermi.repository.port.NominativoRepository;
import it.previnet.progettofermi.repository.port.RecapitoNominativoRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.CARTA_IDENTITA;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.PASSAPORTO;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.PATENTE;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.VISURA_CAMERALE;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.INVIO_CORRISPONDENZA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.RESIDENZA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.SEDE_AMMINISTRATIVA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.SEDE_LEGALE;
import static it.previnet.progettofermi.bean.enums.TipoSesso.FEMMINA;
import static it.previnet.progettofermi.bean.enums.TipoSesso.GIURIDICO;
import static it.previnet.progettofermi.bean.enums.TipoSesso.MASCHIO;
import static org.apache.commons.io.IOUtils.toByteArray;
import static org.apache.commons.lang3.StringUtils.isAnyBlank;

@ApplicationScoped
public class AnagraficaManagerImpl implements AnagraficaManager {
    private static final Logger logger = Logger.getLogger(AnagraficaManagerImpl.class);

    @Inject
    NominativoRepository nominativoRepository;

    @Inject
    RecapitoNominativoRepository recapitoNominativoRepository;

    @Inject
    DocumentoIdentificazioneRepository documentoIdentificazioneRepository;

    @Inject
    NominativoEntityNominativoMapper nominativoEntityNominativoMapper;

    @Override
    @Transactional
    public List<Nominativo> getAnagrafica(NominativoSearch search) {
        logger.info("MANAGER getAnagrafica");

        if (search == null) {
            search = new NominativoSearch();
        }

        return nominativoEntityNominativoMapper.mapEntitiesToBeans(nominativoRepository.fetch(search));
    }

    @Override
    @Transactional
    public Nominativo insertAnagrafica(AnagraficaRequest request, InputStream file) {
        logger.info("MANAGER insertAnagrafica");

        TipoSesso tipoSesso = TipoSesso.lookup(request.getTipoSesso());
        TipoRecapitoNominativo tipoRecapitoNominativo = TipoRecapitoNominativo.lookup(request.getTipoRecapitoNominativo());
        TipoDocumentoIdentificazione tipoDocumentoIdentificazione = TipoDocumentoIdentificazione.lookup(request.getTipoDocumentoIdentificazione());

        logger.debug("request is: " + request);

        boolean personaFisica = !isAnyBlank(request.getDenCognome(), request.getDenNome(), request.getCodFiscale());
        boolean personaGiuridica = !isAnyBlank(request.getDenRagioneSociale(), request.getCodPartitaIva());

        List<String> errors = new ArrayList<>();

        if (!personaFisica && !personaGiuridica) {
            errors.add("Dati anagrafici mancanti");
        }

        if (personaFisica && personaGiuridica) {
            errors.add("Dati anagrafici incoerenti");
        }

        if (personaFisica && !(tipoSesso == MASCHIO || tipoSesso == FEMMINA)) {
            errors.add("Tipo sesso non valido per la persona fisica");
        }

        if (personaFisica && request.getDataNascita() == null) {
            errors.add("Data nascita mancante per la persona fisica");
        }

        if (personaFisica && !(tipoRecapitoNominativo == RESIDENZA || tipoRecapitoNominativo == INVIO_CORRISPONDENZA)) {
            errors.add("Tipo recapito non valido per la persona fisica");
        }

        if (personaFisica && !(tipoDocumentoIdentificazione == CARTA_IDENTITA || tipoDocumentoIdentificazione == PATENTE || tipoDocumentoIdentificazione == PASSAPORTO)) {
            errors.add("Tipo documento non valido per la persona fisica");
        }

        if (personaGiuridica && tipoSesso != GIURIDICO) {
            errors.add("Tipo sesso non valido per la persona giuridica");
        }

        if (personaGiuridica && !(tipoRecapitoNominativo == SEDE_LEGALE || tipoRecapitoNominativo == SEDE_AMMINISTRATIVA)) {
            errors.add("Tipo recapito non valido per la persona giuridica");
        }

        if (personaGiuridica && tipoDocumentoIdentificazione != VISURA_CAMERALE) {
            errors.add("Tipo documento non valido per la persona fisica");
        }

        Nominativo nominativo = new Nominativo();
        nominativo.setCodFiscale(request.getCodFiscale());
        nominativo.setCodPartitaIva(request.getCodPartitaIva());
        nominativo.setDenCognome(request.getDenCognome());
        nominativo.setDenNome(request.getDenNome());
        nominativo.setDenRagioneSociale(request.getDenRagioneSociale());
        nominativo.setTipoSesso(tipoSesso);
        nominativo.setDataNascita(request.getDataNascita());
        nominativo.setCodProvinciaNascita(request.getCodProvinciaNascita());
        nominativo.setDenComuneNascita(request.getDenComuneNascita());
        nominativo.setCodNazioneCittadinanza(request.getCodNazioneCittadinanza());
        nominativo.setDenEmail(request.getDenEmail());
        nominativo.setDenTelefono(request.getDenTelefono());
        nominativo.setDataTimestamp(LocalDateTime.now());
        nominativo.setDenLogin("INSERT");

        RecapitoNominativo recapitoNominativo = new RecapitoNominativo();
        recapitoNominativo.setTipoRecapitoNominativo(tipoRecapitoNominativo);
        recapitoNominativo.setDenPresso(request.getDenPresso());
        recapitoNominativo.setDenNumeroCivico(request.getDenNumeroCivico());
        recapitoNominativo.setCodCap(request.getCodCap());
        recapitoNominativo.setDenLocalita(request.getDenLocalita());
        recapitoNominativo.setCodProvincia(request.getCodProvincia());
        recapitoNominativo.setCodNazione(request.getCodNazione());
        recapitoNominativo.setDenIndirizzo(request.getDenIndirizzo());
        recapitoNominativo.setDataInizio(LocalDate.now());
        recapitoNominativo.setDataTimestamp(LocalDateTime.now());
        recapitoNominativo.setDenLogin("INSERT");
        nominativo.setRecapitoNominativo(recapitoNominativo);

        DocumentoIdentificazione documentoIdentificazione = new DocumentoIdentificazione();
        documentoIdentificazione.setTipoDocumentoIdentificazione(tipoDocumentoIdentificazione);
        documentoIdentificazione.setCodDocumentoIdentificazione(request.getCodDocumentoIdentificazione());
        documentoIdentificazione.setDataRilascio(request.getDataRilascio());
        documentoIdentificazione.setDataScadenza(request.getDataScadenza());
        documentoIdentificazione.setDenEnteRilascio(request.getDenEnteRilascio());
        documentoIdentificazione.setCodSiglaProvinciaRilascio(request.getCodSiglaProvinciaRilascio());
        documentoIdentificazione.setCodNazione(request.getCodNazioneRilascio());
        documentoIdentificazione.setDataInizio(LocalDate.now());
        documentoIdentificazione.setDataTimestamp(LocalDateTime.now());
        documentoIdentificazione.setDenLogin("INSERT");

        if (file != null) {
            try {
                documentoIdentificazione.setContent(toByteArray(file));
            } catch (IOException e) {
                logger.error("catching exception", e);
                errors.add("Impossibile elaborare il documento");
                errors.add(e.getMessage());
            }
        }

        if (!errors.isEmpty()) {
            throw new FermiException(errors);
        }

        nominativo.setDocumentoIdentificazione(documentoIdentificazione);

        NominativoEntity nominativoEntity = nominativoEntityNominativoMapper.mapBeanToEntity(nominativo);

        nominativoRepository.persist(nominativoEntity);
        nominativoEntity.getRecapitoNominativo().forEach(rn -> {
            recapitoNominativoRepository.persist(rn);
        });
        nominativoEntity.getDocumentoIdentificazione().forEach(di -> {
            documentoIdentificazioneRepository.persist(di);
        });

        return nominativoEntityNominativoMapper.mapEntityToBean(nominativoEntity);
    }
}
