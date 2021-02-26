package it.previnet.progettofermi.application.adapter.mapper;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.previnet.progettofermi.bean.Nominativo;
import it.previnet.progettofermi.model.DocumentoIdentificazioneEntity;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.model.RecapitoNominativoEntity;

@ApplicationScoped
public class NominativoEntityNominativoMapper extends AbstractMapper<NominativoEntity, Nominativo> {

    @Inject
    TipoSessoEntityTipoSessoMapper tipoSessoEntityTipoSessoMapper;
    
    @Inject
    RecapitoNominativoEntityRecapitoNominativoMapper recapitoNominativoEntityRecapitoNominativoMapper;
    
    @Inject
    DocumentoIdentificazioneEntityDocumentoIdentificazioneMapper documentoIdentificazioneEntityDocumentoIdentificazioneMapper;

    @Override
    public Nominativo mapEntityToBean(NominativoEntity entity) {
        return mapEntityToBean(entity,new Nominativo());
    }

    @Override
    public Nominativo mapEntityToBean(NominativoEntity entity, Nominativo bean) {
        bean.setTokenNominativo(entity.getTokenNominativo());
        bean.setCodFiscale(entity.getCodFiscale());
        bean.setCodNazioneCittadinanza(entity.getCodNazioneCittadinanza());
        bean.setCodPartitaIva(entity.getCodPartitaIva());
        bean.setCodProvinciaNascita(entity.getCodProvinciaNascita());
        bean.setDataNascita(entity.getDataNascita());
        bean.setDataTimestamp(entity.getDataTimestamp());
        bean.setDenCognome(entity.getDenCognome());
        bean.setDenComuneNascita(bean.getDenComuneNascita());
        bean.setDenEmail(entity.getDenEmail());
        bean.setDenLogin(entity.getDenLogin());
        bean.setDenNome(entity.getDenNome());
        bean.setDenRagioneSociale(entity.getDenRagioneSociale());
        bean.setDenTelefono(entity.getDenTelefono());
        bean.setDocumentoIdentificazione(entity.getDocumentoIdentificazione() == null || entity.getDocumentoIdentificazione().size() == 0 ? null : documentoIdentificazioneEntityDocumentoIdentificazioneMapper.mapEntityToBean(entity.getDocumentoIdentificazione().stream().findFirst().orElseGet(null) ));
        bean.setRecapitoNominativo(entity.getRecapitoNominativo() == null || entity.getRecapitoNominativo().size() == 0 ? null : recapitoNominativoEntityRecapitoNominativoMapper.mapEntityToBean( entity.getRecapitoNominativo().stream().findFirst().orElseGet(null) ));
        bean.setTipoSesso(entity.getTipoSesso() == null ? null : tipoSessoEntityTipoSessoMapper.mapEntityToBean(entity.getTipoSesso()));
        return bean;
    }

    @Override
    public NominativoEntity mapBeanToEntity(Nominativo bean) {
        return mapBeanToEntity(bean,new NominativoEntity());
    }


    @Override
    public NominativoEntity mapBeanToEntity(Nominativo bean, NominativoEntity entity) {
        entity.setTokenNominativo(bean.getTokenNominativo());
        entity.setTokenNominativo(bean.getTokenNominativo());
        entity.setCodFiscale(bean.getCodFiscale());
        entity.setCodNazioneCittadinanza(bean.getCodNazioneCittadinanza());
        entity.setCodPartitaIva(bean.getCodPartitaIva());
        entity.setCodProvinciaNascita(bean.getCodProvinciaNascita());
        entity.setDataNascita(bean.getDataNascita());
        entity.setDataTimestamp(bean.getDataTimestamp());
        entity.setDenCognome(bean.getDenCognome());
        entity.setDenComuneNascita(bean.getDenComuneNascita());
        entity.setDenEmail(bean.getDenEmail());
        entity.setDenLogin(bean.getDenLogin());
        entity.setDenNome(bean.getDenNome());
        entity.setDenRagioneSociale(bean.getDenRagioneSociale());
        entity.setDenTelefono(bean.getDenTelefono());
        if(bean.getDocumentoIdentificazione() != null) {
            Set<DocumentoIdentificazioneEntity> documentoIdentificazione = new HashSet<>(Arrays.asList(
                    documentoIdentificazioneEntityDocumentoIdentificazioneMapper.mapBeanToEntity(bean.getDocumentoIdentificazione())
            ));
            entity.setDocumentoIdentificazione(documentoIdentificazione);
        }
        entity.setRecapitoNominativo(bean.getRecapitoNominativo() == null ? null : new HashSet<RecapitoNominativoEntity>() {{ add(recapitoNominativoEntityRecapitoNominativoMapper.mapBeanToEntity( bean.getRecapitoNominativo())); }});
        entity.setTipoSesso(bean.getTipoSesso() == null ? null : tipoSessoEntityTipoSessoMapper.mapBeanToEntity(bean.getTipoSesso()));
        entity.getRecapitoNominativo().forEach(rn -> {
            rn.setNominativo(entity);
        });
        entity.getDocumentoIdentificazione().forEach(di -> {
            di.setNominativo(entity);
        });
        return entity;
    }


}
