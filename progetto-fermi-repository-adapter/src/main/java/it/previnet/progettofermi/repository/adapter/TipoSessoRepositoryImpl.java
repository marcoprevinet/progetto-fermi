package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.model.TipoSessoEntity;
import it.previnet.progettofermi.repository.port.TipoSessoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TipoSessoRepositoryImpl extends AbstractRepositoryImpl<TipoSessoEntity> implements TipoSessoRepository {

    @Override
    public List<TipoSessoEntity> fetch() {
        String queryStr = "SELECT n FROM TipoSessoEntity n";

        TypedQuery<TipoSessoEntity> query = this.getEntityManager().createQuery(queryStr, TipoSessoEntity.class);

        return query.getResultList();
    }
}
