package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.bean.request.ExampleSearch;
import it.previnet.progettofermi.model.ExampleEntity;
import it.previnet.progettofermi.repository.port.ExampleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@TransactionalTest
public class TestExampleRepository {

    @Inject
    ExampleRepository exampleRepository;

    @Disabled
    @Test
    public void testFetch() throws Exception {
        ExampleSearch search = new ExampleSearch();
        search.setToken(-999);

        List<ExampleEntity> fetch = exampleRepository.fetch(search);
        Assertions.assertNotNull(fetch);
        Assertions.assertEquals(1, fetch.size());
    }
}
