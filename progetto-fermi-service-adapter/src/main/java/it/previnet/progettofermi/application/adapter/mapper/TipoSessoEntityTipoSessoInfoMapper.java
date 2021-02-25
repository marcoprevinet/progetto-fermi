package it.previnet.progettofermi.application.adapter.mapper;

import it.previnet.progettofermi.bean.enums.StatoInfo;
import it.previnet.progettofermi.model.enums.TipoSessoEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoSessoEntityTipoSessoInfoMapper extends AbstractMapper<TipoSessoEntity, StatoInfo> {


    @Override
    public StatoInfo mapEntityToBean(TipoSessoEntity entity) {
        if (entity==null){
            return null;
        }
        return StatoInfo.valueOf(entity.toString());
    }

    @Override
    public StatoInfo mapEntityToBean(TipoSessoEntity entity, StatoInfo bean) {
        return null;
    }

    @Override
    public TipoSessoEntity mapBeanToEntity(StatoInfo bean) {
        if (bean==null){
            return null;
        }
        return TipoSessoEntity.valueOf(bean.toString());
    }


    @Override
    public TipoSessoEntity mapBeanToEntity(StatoInfo bean, TipoSessoEntity entity) {
        return null;
    }


}
