package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.model.TipoSessoEntity;

import java.util.List;

public interface TipoSessoRepository extends AbstractRepository<TipoSessoEntity> {

    List<TipoSessoEntity> fetch();
}
