package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.repository.port.ModelUtils;
import it.previnet.progettofermi.repository.port.NominativoRepository;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class NominativoRepositoryImpl extends AbstractRepositoryImpl<NominativoEntity> implements NominativoRepository {

    private static final Logger logger = Logger.getLogger(NominativoRepositoryImpl.class);

    private ModelUtils modelUtils;

    @Override
    public List<NominativoEntity> fetch(ExampleSearch applicazioneSearch) {
        StringBuilder strQuery = new StringBuilder("SELECT e FROM ExampleEntity e WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();
        TypedQuery<NominativoEntity> query = this.getEntityManager().createQuery(strQuery.toString(), NominativoEntity.class);
        parameters.forEach((k, v) -> query.setParameter(k, v));
        return query.getResultList();
    }
}
