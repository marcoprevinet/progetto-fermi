package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.StatoInfo;
import it.previnet.progettofermi.bean.intf.WithToken;

public class ExampleInfo implements WithToken {

    private Long token;
    private StatoInfo statoInfo;

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }

    public StatoInfo getStatoInfo() {
        return statoInfo;
    }

    public void setStatoInfo(StatoInfo statoInfo) {
        this.statoInfo = statoInfo;
    }
}
