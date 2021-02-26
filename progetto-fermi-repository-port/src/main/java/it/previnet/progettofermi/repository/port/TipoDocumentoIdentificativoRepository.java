package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.model.TipoDocumentoIdentificazioneEntity;

import java.util.List;

public interface TipoDocumentoIdentificativoRepository extends AbstractRepository<TipoDocumentoIdentificazioneEntity> {

    List<TipoDocumentoIdentificazioneEntity> fetch();
}
