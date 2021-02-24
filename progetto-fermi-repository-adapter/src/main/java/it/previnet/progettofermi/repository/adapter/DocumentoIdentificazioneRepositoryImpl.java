package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.model.DocumentoIdentificazioneEntity;
import it.previnet.progettofermi.model.RecapitoNominativoEntity;
import it.previnet.progettofermi.repository.port.DocumentoIdentificazioneRepository;
import it.previnet.progettofermi.repository.port.ModelUtils;
import it.previnet.progettofermi.repository.port.RecapitoNominativoRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DocumentoIdentificazioneRepositoryImpl extends AbstractRepositoryImpl<RecapitoNominativoEntity> implements DocumentoIdentificazioneRepository {

    private static final Logger logger = Logger.getLogger(DocumentoIdentificazioneRepositoryImpl.class);

    private ModelUtils modelUtils;

    @Override
    public List<DocumentoIdentificazioneEntity> fetch(NominativoSearch nominativoSearch) {
        StringBuilder strQuery = new StringBuilder("SELECT n FROM documentoIdentificazione n WHERE 1=1");
        Map<String, Object> parameters = new HashMap<>();

        if(nominativoSearch.getToken() != null) {
            strQuery.append(" AND n.tokenNominativo = :tokenNominativo ");
            parameters.put("tokenNominativo", nominativoSearch.getToken());
        }

//        if (filter.getDataFine() == null) {
//            strQuery.append(" AND (a.dataFine is null OR a.dataFine > :dataFine ) "); //tecnicamente le date dovrebbero essere tutte salvate
//            parameters.put("dataFine", LocalDateTime.now());
//        } else {
//            strQuery.append(" AND (a.dataFine is null OR a.dataFine > :dataFine ) "); //implementazione di default, non ragionata da cambiare in caso
//            parameters.put("dataFine", filter.getDataFine());
//        }

        TypedQuery<DocumentoIdentificazioneEntity> query = this.getEntityManager().createQuery(strQuery.toString(), DocumentoIdentificazioneEntity.class);
        parameters.forEach((k, v) -> query.setParameter(k, v));
        return query.getResultList();
    }
}
