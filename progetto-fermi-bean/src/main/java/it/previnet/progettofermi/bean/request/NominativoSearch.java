package it.previnet.progettofermi.bean.request;

import javax.ws.rs.QueryParam;

public class NominativoSearch {
    @QueryParam("token")
    private Integer token;
    
    private String stato;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String tipo) {
        this.stato = tipo;
    }
    
    
}
