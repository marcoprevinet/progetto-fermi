package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.repository.port.ModelUtils;
import it.previnet.progettofermi.repository.port.NominativoRepository;
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
    public List<NominativoEntity> fetch(NominativoSearch nominativoSearch) {
        StringBuilder strQuery = new StringBuilder("SELECT n FROM NominativoEntity n WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if(nominativoSearch.getToken() != null) {
            strQuery.append(" AND n.tokenNominativo = :tokenNominativo ");
            parameters.put("tokenNominativo", nominativoSearch.getToken());
        }

        TypedQuery<NominativoEntity> query = this.getEntityManager().createQuery(strQuery.toString(), NominativoEntity.class);
        parameters.forEach((k, v) -> query.setParameter(k, v));
        return query.getResultList();
    }
}
