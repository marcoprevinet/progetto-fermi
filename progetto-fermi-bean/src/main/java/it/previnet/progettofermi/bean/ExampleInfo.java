package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.StatoInfo;
import it.previnet.progettofermi.bean.intf.WithToken;

public class ExampleInfo implements WithToken {

    private Integer token;
    private StatoInfo statoInfo;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public StatoInfo getStatoInfo() {
        return statoInfo;
    }

    public void setStatoInfo(StatoInfo statoInfo) {
        this.statoInfo = statoInfo;
    }
}
