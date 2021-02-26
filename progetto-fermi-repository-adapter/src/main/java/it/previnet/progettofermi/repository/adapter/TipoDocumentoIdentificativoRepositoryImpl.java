package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.model.TipoDocumentoIdentificazioneEntity;
import it.previnet.progettofermi.repository.port.TipoDocumentoIdentificativoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TipoDocumentoIdentificativoRepositoryImpl extends AbstractRepositoryImpl<TipoDocumentoIdentificazioneEntity> implements TipoDocumentoIdentificativoRepository {

    @Override
    public List<TipoDocumentoIdentificazioneEntity> fetch() {
        String queryStr = "SELECT n FROM TipoDocumentoIdentificazioneEntity n";

        TypedQuery<TipoDocumentoIdentificazioneEntity> query = this.getEntityManager().createQuery(queryStr, TipoDocumentoIdentificazioneEntity.class);

        return query.getResultList();
    }
}
