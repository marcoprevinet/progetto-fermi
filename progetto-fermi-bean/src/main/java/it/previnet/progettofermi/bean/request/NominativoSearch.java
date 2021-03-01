package it.previnet.progettofermi.bean.request;

import javax.ws.rs.QueryParam;

public class NominativoSearch {
    @QueryParam("token")
    private Integer token;

    @QueryParam("denCognome")
    private String denCognome;

    @QueryParam("denNome")
    private String denNome;

    @QueryParam("denRagioneSociale")
    private String denRagioneSociale;

    @QueryParam("codFiscale")
    private String codFiscale;

    @QueryParam("codPartitaIva")
    private String codPartitaIva;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getDenCognome() {
        return denCognome;
    }

    public void setDenCognome(String denCognome) {
        this.denCognome = denCognome;
    }

    public String getDenNome() {
        return denNome;
    }

    public void setDenNome(String denNome) {
        this.denNome = denNome;
    }

    public String getDenRagioneSociale() {
        return denRagioneSociale;
    }

    public void setDenRagioneSociale(String denRagioneSociale) {
        this.denRagioneSociale = denRagioneSociale;
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getCodPartitaIva() {
        return codPartitaIva;
    }

    public void setCodPartitaIva(String codPartitaIva) {
        this.codPartitaIva = codPartitaIva;
    }
}
