package it.previnet.progettofermi.application.port;

import it.previnet.progettofermi.bean.ExampleInfo;
import it.previnet.progettofermi.bean.request.NominativoSearch;
import java.util.List;

public interface ExampleManager {
    
    List<ExampleInfo> fetch(NominativoSearch search);

}
