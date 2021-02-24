package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.NominativoEntity;

import java.util.List;

public interface ExampleRepository extends AbstractRepository<NominativoEntity> {
    
    List<NominativoEntity> fetch(ExampleSearch applicazioneSearch);

}
