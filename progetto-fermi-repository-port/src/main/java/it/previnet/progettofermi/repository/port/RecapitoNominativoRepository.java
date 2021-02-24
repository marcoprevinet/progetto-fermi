package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.model.NominativoEntity;
import it.previnet.progettofermi.model.RecapitoNominativoEntity;

import java.util.List;

public interface RecapitoNominativoRepository extends AbstractRepository<RecapitoNominativoEntity> {
    
    List<RecapitoNominativoEntity> fetch(NominativoSearch nominativoSearch);

}
