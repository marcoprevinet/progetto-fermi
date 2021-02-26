package it.previnet.progettofermi.application.adapter.mapper;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.previnet.progettofermi.bean.DocumentoIdentificazione;
import it.previnet.progettofermi.model.DocumentoIdentificazioneEntity;

@ApplicationScoped
public class DocumentoIdentificazioneEntityDocumentoIdentificazioneMapper extends AbstractMapper<DocumentoIdentificazioneEntity, DocumentoIdentificazione> {

    @Inject
    TipoDocumentoIdentificazioneEntityTipoDocumentoIdentificazioneMapper tipoDocumentoIdentificazioneEntityTipoDocumentoIdentificazioneMapper;

    @Override
    public DocumentoIdentificazione mapEntityToBean(DocumentoIdentificazioneEntity entity) {
        return mapEntityToBean(entity,new DocumentoIdentificazione());
    }

    @Override
    public DocumentoIdentificazione mapEntityToBean(DocumentoIdentificazioneEntity entity, DocumentoIdentificazione bean) {
        bean.setTokenDocumentoIdentificazion(entity.getTokenDocumentoIdentificazion());
        bean.setCodDocumentoIdentificazione(entity.getCodDocumentoIdentificazione());
        bean.setCodNazione(entity.getCodNazione());
        bean.setCodSiglaProvinciaRilascio(entity.getCodSiglaProvinciaRilascio());
        bean.setContent(entity.getContent());
        bean.setDataFine(entity.getDataFine());
        bean.setDataInizio(entity.getDataInizio());
        bean.setDataRilascio(entity.getDataRilascio());
        bean.setDataScadenza(entity.getDataScadenza());
        bean.setDataTimestamp(entity.getDataTimestamp());
        bean.setDenEnteRilascio(entity.getDenEnteRilascio());
        bean.setDenLocalitaRilascio(entity.getDenLocalitaRilascio());
        bean.setDenLogin(entity.getDenLogin());
        bean.setTipoDocumentoIdentificazione(entity.getTipoDocumentoIdentificazione() == null ? null : tipoDocumentoIdentificazioneEntityTipoDocumentoIdentificazioneMapper.mapEntityToBean(entity.getTipoDocumentoIdentificazione()));
        bean.setTokenNominativo(entity.getNominativo().getTokenNominativo());
        return bean;
    }

    @Override
    public DocumentoIdentificazioneEntity mapBeanToEntity(DocumentoIdentificazione bean) {
        return mapBeanToEntity(bean,new DocumentoIdentificazioneEntity());
    }


    @Override
    public DocumentoIdentificazioneEntity mapBeanToEntity(DocumentoIdentificazione bean, DocumentoIdentificazioneEntity entity) {
        entity.setTokenDocumentoIdentificazion(bean.getTokenDocumentoIdentificazion());
        entity.setTokenDocumentoIdentificazion(bean.getTokenDocumentoIdentificazion());
        entity.setCodDocumentoIdentificazione(bean.getCodDocumentoIdentificazione());
        entity.setCodNazione(bean.getCodNazione());
        entity.setCodSiglaProvinciaRilascio(bean.getCodSiglaProvinciaRilascio());
        entity.setContent(bean.getContent());
        entity.setDataFine(bean.getDataFine());
        entity.setDataInizio(bean.getDataInizio());
        entity.setDataRilascio(bean.getDataRilascio());
        entity.setDataScadenza(bean.getDataScadenza());
        entity.setDataTimestamp(bean.getDataTimestamp());
        entity.setDenEnteRilascio(bean.getDenEnteRilascio());
        entity.setDenLocalitaRilascio(bean.getDenLocalitaRilascio());
        entity.setDenLogin(bean.getDenLogin());
        entity.setTipoDocumentoIdentificazione(bean.getTipoDocumentoIdentificazione() == null ? null : tipoDocumentoIdentificazioneEntityTipoDocumentoIdentificazioneMapper.mapBeanToEntity(bean.getTipoDocumentoIdentificazione()));
        return entity;
    }


}
