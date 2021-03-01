package it.previnet.progettofermi.application.adapter.mapper;


import it.previnet.progettofermi.bean.RecapitoNominativo;
import it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo;
import it.previnet.progettofermi.model.RecapitoNominativoEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RecapitoNominativoEntityRecapitoNominativoMapper extends AbstractMapper<RecapitoNominativoEntity, RecapitoNominativo> {

    @Override
    public RecapitoNominativo mapEntityToBean(RecapitoNominativoEntity entity) {
        return mapEntityToBean(entity, new RecapitoNominativo());
    }

    @Override
    public RecapitoNominativo mapEntityToBean(RecapitoNominativoEntity entity, RecapitoNominativo bean) {
        bean.setTokenRecapitoNominativo(entity.getTokenRecapitoNominativo());
        bean.setCodCap(entity.getCodCap());
        bean.setCodNazione(entity.getCodNazione());
        bean.setCodProvincia(entity.getCodProvincia());
        bean.setDataFine(entity.getDataFine());
        bean.setDataInizio(entity.getDataInizio());
        bean.setDataTimestamp(entity.getDataTimestamp());
        bean.setDenIndirizzo(entity.getDenIndirizzo());
        bean.setDenLocalita(entity.getDenLocalita());
        bean.setDenLogin(entity.getDenLogin());
        bean.setDenNumeroCivico(entity.getDenNumeroCivico());
        bean.setDenPresso(entity.getDenPresso());
        bean.setTipoRecapitoNominativo(entity.getTipoRecapitoNominativo() == null ? null : TipoRecapitoNominativo.lookup(entity.getTipoRecapitoNominativo()));
        bean.setTokenNominativo(entity.getNominativo().getTokenNominativo());
        return bean;
    }

    @Override
    public RecapitoNominativoEntity mapBeanToEntity(RecapitoNominativo bean) {
        return mapBeanToEntity(bean, new RecapitoNominativoEntity());
    }

    @Override
    public RecapitoNominativoEntity mapBeanToEntity(RecapitoNominativo bean, RecapitoNominativoEntity entity) {
        entity.setTokenRecapitoNominativo(bean.getTokenRecapitoNominativo());
        entity.setCodCap(bean.getCodCap());
        entity.setCodNazione(bean.getCodNazione());
        entity.setCodProvincia(bean.getCodProvincia());
        entity.setDataFine(bean.getDataFine());
        entity.setDataInizio(bean.getDataInizio());
        entity.setDataTimestamp(bean.getDataTimestamp());
        entity.setDenIndirizzo(bean.getDenIndirizzo());
        entity.setDenLocalita(bean.getDenLocalita());
        entity.setDenLogin(bean.getDenLogin());
        entity.setDenNumeroCivico(bean.getDenNumeroCivico());
        entity.setDenPresso(bean.getDenPresso());
        entity.setTipoRecapitoNominativo(bean.getTipoRecapitoNominativo() == null ? null : bean.getTipoRecapitoNominativo().value);
        return entity;
    }
}