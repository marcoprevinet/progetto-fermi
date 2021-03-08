package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.ExampleSearch;

import java.util.List;

public interface ExampleManager {
    
    List<ExampleInfo> fetch(ExampleSearch search);

    ExampleInfo insert(ExampleInfo exampleInfo);

}
