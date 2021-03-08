package it.previnet.progettofermi.application.adapter;

import it.previnet.progettofermi.application.adapter.mapper.ExampleEntityExampleInfoMapper;
import it.previnet.progettofermi.application.adapter.util.BeanUtil;
import it.previnet.progettofermi.application.port.ExampleManager;
import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.ExampleEntity;
import it.previnet.progettofermi.repository.port.ExampleRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class ExampleManagerImpl implements ExampleManager {

    private static final Logger logger = Logger.getLogger(ExampleManagerImpl.class);

    @Inject
    ExampleRepository exampleRepository;

    @Inject
    ExampleEntityExampleInfoMapper exampleEntityExampleInfoMapper;

    @Inject
    BeanUtil beanUtil;

    @Override
    @Transactional
    public List<ExampleInfo> fetch(ExampleSearch exampleSearch) {
        return exampleRepository.fetch(exampleSearch).stream().map(exampleEntityExampleInfoMapper::mapEntityToBean).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ExampleInfo insert(ExampleInfo exampleInfo) {
        ExampleEntity exampleEntity = exampleEntityExampleInfoMapper.mapBeanToEntity(exampleInfo);
        exampleRepository.persist(exampleEntity);

        return exampleEntityExampleInfoMapper.mapEntityToBean(exampleEntity);
    }

}
