package it.previnet.progettofermi.repository.port;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.ExampleEntity;

import java.util.List;

public interface ExampleRepository extends AbstractRepository<ExampleEntity> {

    List<ExampleEntity> fetch(ExampleSearch exampleSearch);
}
