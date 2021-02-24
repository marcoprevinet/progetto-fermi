package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.bean.request.NominativoSearch;
import it.previnet.progettofermi.model.DocumentoIdentificazioneEntity;
import it.previnet.progettofermi.model.RecapitoNominativoEntity;

import java.util.List;

public interface DocumentoIdentificazioneRepository extends AbstractRepository<DocumentoIdentificazioneEntity> {
    
    List<DocumentoIdentificazioneEntity> fetch(NominativoSearch nominativoSearch);

}
