package it.previnet.progettofermi.bean.request;

import javax.ws.rs.QueryParam;

public class NominativoSearch {
    @QueryParam("token")
    private Integer token;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }
}