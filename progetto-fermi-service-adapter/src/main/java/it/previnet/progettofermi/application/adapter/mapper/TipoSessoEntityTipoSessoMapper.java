package it.previnet.progettofermi.application.adapter.mapper;

import it.previnet.progettofermi.bean.enums.TipoSesso;
import it.previnet.progettofermi.model.enums.TipoSessoEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoSessoEntityTipoSessoMapper extends AbstractMapper<TipoSessoEntity, TipoSesso> {


    @Override
    public TipoSesso mapEntityToBean(TipoSessoEntity entity) {
        if (entity==null){
            return null;
        }
        return TipoSesso.valueOf(entity.toString());
    }

    @Override
    public TipoSesso mapEntityToBean(TipoSessoEntity entity, TipoSesso bean) {
        return null;
    }

    @Override
    public TipoSessoEntity mapBeanToEntity(TipoSesso bean) {
        if (bean==null){
            return null;
        }
        return TipoSessoEntity.valueOf(bean.toString());
    }


    @Override
    public TipoSessoEntity mapBeanToEntity(TipoSesso bean, TipoSessoEntity entity) {
        return null;
    }


}
