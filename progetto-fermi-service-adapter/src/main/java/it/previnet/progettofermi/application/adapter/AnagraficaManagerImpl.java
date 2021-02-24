package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.port.AnagraficaManager;
import it.previnet.progettofermi.bean.DocumentoIdentificazione;
import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.bean.RecapitoNominativo;
import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;
import it.previnet.progettofermi.bean.request.AnagraficaRequest;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.CARTA_IDENTITA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.RESIDENZA;
import static it.previnet.progettofermi.bean.enums.TipoSesso.MASCHIO;

@ApplicationScoped
public class AnagraficaManagerImpl implements AnagraficaManager {
    private static final Logger logger = Logger.getLogger(AnagraficaManagerImpl.class);

    private static Nominativo n;

    @PostConstruct
    private void init() {
        // FIXME rimuovere
        n = new Nominativo();
        n.setDenCognome("ROSSI");
        n.setDenNome("MARIO");
        n.setDataNascita(LocalDateTime.now());
        n.setCodFiscale("RSSMRA");
        n.setTipoSesso(MASCHIO);

        RecapitoNominativo rn = new RecapitoNominativo();
        rn.setCodNazione("ITA");
        rn.setCodProvincia("TV");
        rn.setDenLocalita("PREGANZIOL");
        rn.setDenNumeroCivico("24");
        rn.setDenIndirizzo("VIA FORLANINI");
        rn.setCodCap("31022");
        rn.setTipoRecapitoNominativo(RESIDENZA);
        n.setRecapitoNominativo(rn);

        DocumentoIdentificazione di = new DocumentoIdentificazione();
        di.setTipoDocumentoIdentificazione(CARTA_IDENTITA);
        di.setDenEnteRilascio("COMUNE DI PREGANZIOL");
        di.setDataRilascio(LocalDateTime.now());
        di.setCodDocumentoIdentificazione("AB00000XY");
        n.setDocumentoIdentificazione(di);

    }

    @Override
    @Transactional
    public List<Nominativo> getAnagrafica() {
        logger.info("MANAGER getAnagrafica");

        // TODO: invocazione repository
        List<Nominativo> list = new ArrayList<>();
        list.add(n);

        return list;
    }

    @Override
    @Transactional
    public Nominativo insertAnagrafica(AnagraficaRequest request, InputStream file) {
        logger.info("MANAGER insertAnagrafica");

        // TODO: invocazione repository

        return n;
    }
}
