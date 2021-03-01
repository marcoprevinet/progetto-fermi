package it.previnet.progettofermi.application.adapter.mapper;

import it.previnet.progettofermi.bean.enums.StatoInfo;
import it.previnet.progettofermi.model.enums.StatoEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StringStatoInfoMapper extends AbstractMapper<String, StatoInfo> {


    @Override
    public StatoInfo mapEntityToBean(String entity) {
        if (entity==null){
            return null;
        }
        return StatoInfo.valueOf(entity);
    }

    @Override
    public StatoInfo mapEntityToBean(String entity, StatoInfo bean) {
        return null;
    }

    @Override
    public String mapBeanToEntity(StatoInfo bean) {
        if (bean==null){
            return null;
        }
        return bean.toString();
    }


    @Override
    public String mapBeanToEntity(StatoInfo bean, String entity) {
        return null;
    }


}
