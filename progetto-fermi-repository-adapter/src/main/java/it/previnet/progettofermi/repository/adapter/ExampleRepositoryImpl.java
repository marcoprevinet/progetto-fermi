package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.repository.port.ExampleRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ExampleRepositoryImpl extends AbstractRepositoryImpl<NominativoEntity> implements ExampleRepository {

    private static final Logger logger = Logger.getLogger(ExampleRepositoryImpl.class);

    @Override
    public List<NominativoEntity> fetch(ExampleSearch applicazioneSearch) {
        StringBuilder strQuery = new StringBuilder("SELECT e FROM ExampleEntity e WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();
        TypedQuery<NominativoEntity> query = this.getEntityManager().createQuery(strQuery.toString(), NominativoEntity.class);
        parameters.forEach((k, v) -> query.setParameter(k, v));
        return query.getResultList();
    }

}
