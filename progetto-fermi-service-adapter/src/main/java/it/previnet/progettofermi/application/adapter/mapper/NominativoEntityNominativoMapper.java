package it.previnet.progettofermi.application.adapter.mapper;


import java.util.HashSet;

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
        bean.setDocumentoIdentificazione(entity.getDocumentoIdentificazione() == null ? null : documentoIdentificazioneEntityDocumentoIdentificazioneMapper.mapEntityToBean(entity.getDocumentoIdentificazione().stream().findFirst().orElseGet(null) ));
        bean.setRecapitoNominativo(entity.getRecapitoNominativo() == null ? null : recapitoNominativoEntityRecapitoNominativoMapper.mapEntityToBean( entity.getRecapitoNominativo().stream().findFirst().orElseGet(null) ));
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
        entity.setTokenNominativo(entity.getTokenNominativo());
        entity.setCodFiscale(entity.getCodFiscale());
        entity.setCodNazioneCittadinanza(entity.getCodNazioneCittadinanza());
        entity.setCodPartitaIva(entity.getCodPartitaIva());
        entity.setCodProvinciaNascita(entity.getCodProvinciaNascita());
        entity.setDataNascita(entity.getDataNascita());
        entity.setDataTimestamp(entity.getDataTimestamp());
        entity.setDenCognome(entity.getDenCognome());
        entity.setDenComuneNascita(bean.getDenComuneNascita());
        entity.setDenEmail(entity.getDenEmail());
        entity.setDenLogin(entity.getDenLogin());
        entity.setDenNome(entity.getDenNome());
        entity.setDenRagioneSociale(entity.getDenRagioneSociale());
        entity.setDenTelefono(entity.getDenTelefono());
        entity.setDocumentoIdentificazione(bean.getDocumentoIdentificazione() == null ? null : new HashSet<DocumentoIdentificazioneEntity>() {{ documentoIdentificazioneEntityDocumentoIdentificazioneMapper.mapBeanToEntity(bean.getDocumentoIdentificazione()); }} );
        entity.setRecapitoNominativo(bean.getRecapitoNominativo() == null ? null : new HashSet<RecapitoNominativoEntity>() {{ recapitoNominativoEntityRecapitoNominativoMapper.mapBeanToEntity( bean.getRecapitoNominativo()); }});
        entity.setTipoSesso(entity.getTipoSesso() == null ? null : tipoSessoEntityTipoSessoMapper.mapBeanToEntity(bean.getTipoSesso()));
        return entity;
    }


}
