package it.previnet.progettofermi.application.adapter.mapper;


import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.model.NominativoEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NominativoEntityNominativoInfoMapper extends AbstractMapper<NominativoEntity, ExampleInfo> {

    @Inject
    TipoSessoEntityTipoSessoInfoMapper statoEntityStatoInfoMapper;

    @Override
    public ExampleInfo mapEntityToBean(NominativoEntity entity) {
        return mapEntityToBean(entity,new ExampleInfo());
    }

    @Override
    public ExampleInfo mapEntityToBean(NominativoEntity entity, ExampleInfo bean) {
        bean.setToken(entity.getTokenNominativo());
        bean.setStatoInfo(statoEntityStatoInfoMapper.mapEntityToBean(entity.getTipoSesso()));
        return bean;
    }

    @Override
    public NominativoEntity mapBeanToEntity(ExampleInfo bean) {
        return mapBeanToEntity(bean,new NominativoEntity());
    }


    @Override
    public NominativoEntity mapBeanToEntity(ExampleInfo bean, NominativoEntity entity) {
        entity.setTokenNominativo(bean.getToken());
        entity.setTipoSesso(statoEntityStatoInfoMapper.mapBeanToEntity(bean.getStatoInfo()));
        return entity;
    }


}
