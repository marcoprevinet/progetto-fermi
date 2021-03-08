package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.model.TipoRecapitoNominativoEntity;
import it.previnet.progettofermi.model.TipoSessoEntity;
import it.previnet.progettofermi.repository.port.TipoRecapitoNominativoRepository;
import it.previnet.progettofermi.repository.port.TipoSessoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TipoRecapitoNominativoRepositoryImpl extends AbstractRepositoryImpl<TipoRecapitoNominativoEntity> implements TipoRecapitoNominativoRepository {

    @Override
    public List<TipoRecapitoNominativoEntity> fetch() {
        String queryStr = "SELECT n FROM TipoRecapitoNominativoEntity n";

        TypedQuery<TipoRecapitoNominativoEntity> query = this.getEntityManager().createQuery(queryStr, TipoRecapitoNominativoEntity.class);

        return query.getResultList();
    }
}
