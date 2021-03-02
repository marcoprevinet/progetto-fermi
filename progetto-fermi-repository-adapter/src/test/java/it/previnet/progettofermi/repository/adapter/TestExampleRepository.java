package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.ExampleEntity;
import it.previnet.progettofermi.repository.port.ExampleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class TestExampleRepository {

    @Inject
    ExampleRepository exampleRepository;

    @Disabled
    @TestTransaction
    @Test
    public void testFetch() throws Exception {
        ExampleSearch search = new ExampleSearch();
        search.setToken(-999);

        List<ExampleEntity> fetch = exampleRepository.fetch(search);
        Assertions.assertNotNull(fetch);
        Assertions.assertEquals(1, fetch.size());
    }
    
    @Disabled
    @TestTransaction
    @Test
    public void testInsertFetch() throws Exception {
        ExampleEntity newEntity = new ExampleEntity();
        newEntity.setStato("roundtrip");
        exampleRepository.persist(newEntity);
        
        ExampleSearch search = new ExampleSearch();
        search.setStato("roundtrip");
        List<ExampleEntity> fetch = exampleRepository.fetch(search);
        Assertions.assertNotNull(fetch);
        Assertions.assertEquals(1, fetch.size());
    }
    
}
