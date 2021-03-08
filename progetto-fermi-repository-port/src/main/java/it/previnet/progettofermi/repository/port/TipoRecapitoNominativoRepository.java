package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.model.TipoRecapitoNominativoEntity;
import it.previnet.progettofermi.model.TipoSessoEntity;

import java.util.List;

public interface TipoRecapitoNominativoRepository extends AbstractRepository<TipoRecapitoNominativoEntity> {

    List<TipoRecapitoNominativoEntity> fetch();
}
