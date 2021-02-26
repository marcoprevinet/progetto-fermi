package it.previnet.progettofermi.application.adapter.mapper;

import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;
import it.previnet.progettofermi.model.enums.TipoDocumentoIdentificazioneEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDocumentoIdentificazioneEntityTipoDocumentoIdentificazioneMapper extends AbstractMapper<TipoDocumentoIdentificazioneEntity, TipoDocumentoIdentificazione> {


    @Override
    public TipoDocumentoIdentificazione mapEntityToBean(TipoDocumentoIdentificazioneEntity entity) {
        if (entity==null){
            return null;
        }
        return TipoDocumentoIdentificazione.valueOf(entity.toString());
    }

    @Override
    public TipoDocumentoIdentificazione mapEntityToBean(TipoDocumentoIdentificazioneEntity entity, TipoDocumentoIdentificazione bean) {
        return null;
    }

    @Override
    public TipoDocumentoIdentificazioneEntity mapBeanToEntity(TipoDocumentoIdentificazione bean) {
        if (bean==null){
            return null;
        }
        return TipoDocumentoIdentificazioneEntity.valueOf(bean.toString());
    }


    @Override
    public TipoDocumentoIdentificazioneEntity mapBeanToEntity(TipoDocumentoIdentificazione bean, TipoDocumentoIdentificazioneEntity entity) {
        return null;
    }


}
