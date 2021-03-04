package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.port.TipoManager;
import it.previnet.progettofermi.bean.CodeDescription;
import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;
import it.previnet.progettofermi.bean.enums.TipoPersona;
import it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo;
import it.previnet.progettofermi.bean.enums.TipoSesso;
import it.previnet.progettofermi.model.TipoDocumentoIdentificazioneEntity;
import it.previnet.progettofermi.model.TipoRecapitoNominativoEntity;
import it.previnet.progettofermi.model.TipoSessoEntity;
import it.previnet.progettofermi.repository.port.TipoDocumentoIdentificativoRepository;
import it.previnet.progettofermi.repository.port.TipoRecapitoNominativoRepository;
import it.previnet.progettofermi.repository.port.TipoSessoRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.CARTA_IDENTITA;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.PASSAPORTO;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.PATENTE;
import static it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione.VISURA_CAMERALE;
import static it.previnet.progettofermi.bean.enums.TipoPersona.FISICA;
import static it.previnet.progettofermi.bean.enums.TipoPersona.GIURIDICA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.INVIO_CORRISPONDENZA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.RESIDENZA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.SEDE_AMMINISTRATIVA;
import static it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo.SEDE_LEGALE;
import static it.previnet.progettofermi.bean.enums.TipoSesso.FEMMINA;
import static it.previnet.progettofermi.bean.enums.TipoSesso.GIURIDICO;
import static it.previnet.progettofermi.bean.enums.TipoSesso.MASCHIO;

@ApplicationScoped
public class TipoManagerImpl implements TipoManager {

    @Inject
    TipoSessoRepository tipoSessoRepository;

    @Inject
    TipoRecapitoNominativoRepository tipoRecapitoNominativoRepository;

    @Inject
    TipoDocumentoIdentificativoRepository tipoDocumentoIdentificativoRepository;

    private static Map<TipoPersona, List<TipoSesso>> TIPO_SESSO_MAP = new HashMap<>();
    private static Map<TipoPersona, List<TipoRecapitoNominativo>> TIPO_RECAPITO_MAP = new HashMap<>();
    private static Map<TipoPersona, List<TipoDocumentoIdentificazione>> TIPO_DOCUMENTO_MAP = new HashMap<>();

    @PostConstruct
    private void init() {
        TIPO_SESSO_MAP.put(FISICA, Arrays.asList(FEMMINA, MASCHIO));
        TIPO_SESSO_MAP.put(GIURIDICA, Arrays.asList(GIURIDICO));

        TIPO_RECAPITO_MAP.put(FISICA, Arrays.asList(RESIDENZA, INVIO_CORRISPONDENZA));
        TIPO_RECAPITO_MAP.put(GIURIDICA, Arrays.asList(SEDE_LEGALE, SEDE_AMMINISTRATIVA));

        TIPO_DOCUMENTO_MAP.put(FISICA, Arrays.asList(CARTA_IDENTITA, PATENTE, PASSAPORTO));
        TIPO_DOCUMENTO_MAP.put(GIURIDICA, Arrays.asList(VISURA_CAMERALE));
    }

    @Override
    public List<CodeDescription> getTipoSesso(TipoPersona tipoPersona) {
        List<TipoSessoEntity> fetch = tipoSessoRepository.fetch();

        List<CodeDescription> list = fetch.stream()
                .filter(t -> {
                    if (tipoPersona == null) {
                        return true;
                    }

                    TipoSesso tipoSesso = TipoSesso.lookup(t.getTipoSesso());
                    if (tipoSesso != null) {
                        List<TipoSesso> tipoSessoList = TIPO_SESSO_MAP.get(tipoPersona);
                        return tipoSessoList != null && tipoSessoList.contains(tipoSesso);
                    }

                    return false;
                })
                .map(t -> {
                    CodeDescription cd = new CodeDescription();
                    cd.setCode(t.getTipoSesso());
                    cd.setDescription(t.getDenSesso());
                    return cd;
                }).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<CodeDescription> getTipoRecapito(TipoPersona tipoPersona) {
        List<TipoRecapitoNominativoEntity> fetch = tipoRecapitoNominativoRepository.fetch();

        List<CodeDescription> list = fetch.stream()
                .filter(t -> {
                    if (tipoPersona == null) {
                        return true;
                    }

                    TipoRecapitoNominativo tipoRecapito = TipoRecapitoNominativo.lookup(t.getTipoRecapitoNominativo());
                    if (tipoRecapito != null) {
                        List<TipoRecapitoNominativo> tipoRecapitoList = TIPO_RECAPITO_MAP.get(tipoPersona);
                        return tipoRecapitoList != null && tipoRecapitoList.contains(tipoRecapito);
                    }

                    return false;
                })
                .map(t -> {
                    CodeDescription cd = new CodeDescription();
                    cd.setCode(t.getTipoRecapitoNominativo());
                    cd.setDescription(t.getDenRecapitoNominativo());
                    return cd;
                }).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<CodeDescription> getTipoDocumento(TipoPersona tipoPersona) {
        List<TipoDocumentoIdentificazioneEntity> fetch = tipoDocumentoIdentificativoRepository.fetch();

        List<CodeDescription> list = fetch.stream()
                .filter(t -> {
                    if (tipoPersona == null) {
                        return true;
                    }

                    TipoDocumentoIdentificazione tipoRecapito = TipoDocumentoIdentificazione.lookup(t.getTipoDocumentoIdentificazione());
                    if (tipoRecapito != null) {
                        List<TipoDocumentoIdentificazione> tipoDocumentoList = TIPO_DOCUMENTO_MAP.get(tipoPersona);
                        return tipoDocumentoList != null && tipoDocumentoList.contains(tipoRecapito);
                    }

                    return false;
                })
                .map(t -> {
                    CodeDescription cd = new CodeDescription();
                    cd.setCode(t.getTipoDocumentoIdentificazione());
                    cd.setDescription(t.getDenDocumentoIdentificazione());
                    return cd;
                }).collect(Collectors.toList());

        return list;

    }
}
