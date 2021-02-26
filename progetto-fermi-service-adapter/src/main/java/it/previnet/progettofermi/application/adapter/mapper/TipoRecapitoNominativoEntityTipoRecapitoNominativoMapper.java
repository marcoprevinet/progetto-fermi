package it.previnet.progettofermi.application.adapter.mapper;

import it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo;
import it.previnet.progettofermi.model.enums.TipoRecapitoNominativoEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoRecapitoNominativoEntityTipoRecapitoNominativoMapper extends AbstractMapper<TipoRecapitoNominativoEntity, TipoRecapitoNominativo> {


    @Override
    public TipoRecapitoNominativo mapEntityToBean(TipoRecapitoNominativoEntity entity) {
        if (entity==null){
            return null;
        }
        return TipoRecapitoNominativo.valueOf(entity.toString());
    }

    @Override
    public TipoRecapitoNominativo mapEntityToBean(TipoRecapitoNominativoEntity entity, TipoRecapitoNominativo bean) {
        return null;
    }

    @Override
    public TipoRecapitoNominativoEntity mapBeanToEntity(TipoRecapitoNominativo bean) {
        if (bean==null){
            return null;
        }
        return TipoRecapitoNominativoEntity.valueOf(bean.toString());
    }


    @Override
    public TipoRecapitoNominativoEntity mapBeanToEntity(TipoRecapitoNominativo bean, TipoRecapitoNominativoEntity entity) {
        return null;
    }


}
