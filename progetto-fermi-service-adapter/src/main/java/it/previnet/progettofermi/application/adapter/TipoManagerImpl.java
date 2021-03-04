package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.port.TipoManager;
import it.previnet.progettofermi.bean.CodeDescription;
import it.previnet.progettofermi.model.TipoDocumentoIdentificazioneEntity;
import it.previnet.progettofermi.model.TipoRecapitoNominativoEntity;
import it.previnet.progettofermi.model.TipoSessoEntity;
import it.previnet.progettofermi.repository.port.TipoDocumentoIdentificativoRepository;
import it.previnet.progettofermi.repository.port.TipoRecapitoNominativoRepository;
import it.previnet.progettofermi.repository.port.TipoSessoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TipoManagerImpl implements TipoManager {

    @Inject
    TipoSessoRepository tipoSessoRepository;

    @Inject
    TipoRecapitoNominativoRepository tipoRecapitoNominativoRepository;

    @Inject
    TipoDocumentoIdentificativoRepository tipoDocumentoIdentificativoRepository;

    @Override
    public List<CodeDescription> getTipoSesso() {
        List<TipoSessoEntity> fetch = tipoSessoRepository.fetch();

        List<CodeDescription> list = fetch.stream().map(t -> {
            CodeDescription cd = new CodeDescription();
            cd.setCode(t.getTipoSesso());
            cd.setDescription(t.getDenSesso());
            return cd;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<CodeDescription> getTipoRecapito() {
        List<TipoRecapitoNominativoEntity> fetch = tipoRecapitoNominativoRepository.fetch();

        List<CodeDescription> list = fetch.stream().map(t -> {
            CodeDescription cd = new CodeDescription();
            cd.setCode(t.getTipoRecapitoNominativo());
            cd.setDescription(t.getDenRecapitoNominativo());
            return cd;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<CodeDescription> getTipoDocumento() {
        List<TipoDocumentoIdentificazioneEntity> fetch = tipoDocumentoIdentificativoRepository.fetch();

        List<CodeDescription> list = fetch.stream().map(t -> {
            CodeDescription cd = new CodeDescription();
            cd.setCode(t.getTipoDocumentoIdentificazione());
            cd.setDescription(t.getDenDocumentoIdentificazione());
            return cd;
        }).collect(Collectors.toList());

        return list;

    }
}
