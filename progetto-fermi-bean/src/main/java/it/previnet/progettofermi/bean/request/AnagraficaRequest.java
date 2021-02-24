package it.previnet.progettofermi.bean.request;

import java.time.LocalDate;

public class AnagraficaRequest {
    // nominativo
    private String codFiscale;
    private String codPartitaIva;
    private String denCognome;
    private String denNome;
    private String denRagioneSociale;
    private String tipoSesso;
    private LocalDate dataNascita;
    private String codProvinciaNascita;
    private String denComuneNascita;
    private String codNazioneCittadinanza;
    private String denEmail;
    private String denTelefono;

    // recapito
    private String tipoRecapitoNominativo;
    private String denPresso;
    private String denNumeroCivico;
    private String codCap;
    private String denLocalita;
    private String codProvincia;
    private String codNazione;
    private String denIndirizzo;

    // documento
    private String tipoDocumentoIdentificazione;
    private String codDocumentoIdentificazione;
    private LocalDate dataRilascio;
    private LocalDate dataScadenza;
    private String denEnteRilascio;
    private String denLocalitaRilascio;
    private String codSiglaProvinciaRilascio;
    private String codNazioneRilascio;

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

    public String getTipoSesso() {
        return tipoSesso;
    }

    public void setTipoSesso(String tipoSesso) {
        this.tipoSesso = tipoSesso;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCodProvinciaNascita() {
        return codProvinciaNascita;
    }

    public void setCodProvinciaNascita(String codProvinciaNascita) {
        this.codProvinciaNascita = codProvinciaNascita;
    }

    public String getDenComuneNascita() {
        return denComuneNascita;
    }

    public void setDenComuneNascita(String denComuneNascita) {
        this.denComuneNascita = denComuneNascita;
    }

    public String getCodNazioneCittadinanza() {
        return codNazioneCittadinanza;
    }

    public void setCodNazioneCittadinanza(String codNazioneCittadinanza) {
        this.codNazioneCittadinanza = codNazioneCittadinanza;
    }

    public String getDenEmail() {
        return denEmail;
    }

    public void setDenEmail(String denEmail) {
        this.denEmail = denEmail;
    }

    public String getDenTelefono() {
        return denTelefono;
    }

    public void setDenTelefono(String denTelefono) {
        this.denTelefono = denTelefono;
    }

    public String getTipoRecapitoNominativo() {
        return tipoRecapitoNominativo;
    }

    public void setTipoRecapitoNominativo(String tipoRecapitoNominativo) {
        this.tipoRecapitoNominativo = tipoRecapitoNominativo;
    }

    public String getDenPresso() {
        return denPresso;
    }

    public void setDenPresso(String denPresso) {
        this.denPresso = denPresso;
    }

    public String getDenNumeroCivico() {
        return denNumeroCivico;
    }

    public void setDenNumeroCivico(String denNumeroCivico) {
        this.denNumeroCivico = denNumeroCivico;
    }

    public String getCodCap() {
        return codCap;
    }

    public void setCodCap(String codCap) {
        this.codCap = codCap;
    }

    public String getDenLocalita() {
        return denLocalita;
    }

    public void setDenLocalita(String denLocalita) {
        this.denLocalita = denLocalita;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodNazione() {
        return codNazione;
    }

    public void setCodNazione(String codNazione) {
        this.codNazione = codNazione;
    }

    public String getDenIndirizzo() {
        return denIndirizzo;
    }

    public void setDenIndirizzo(String denIndirizzo) {
        this.denIndirizzo = denIndirizzo;
    }

    public String getTipoDocumentoIdentificazione() {
        return tipoDocumentoIdentificazione;
    }

    public void setTipoDocumentoIdentificazione(String tipoDocumentoIdentificazione) {
        this.tipoDocumentoIdentificazione = tipoDocumentoIdentificazione;
    }

    public String getCodDocumentoIdentificazione() {
        return codDocumentoIdentificazione;
    }

    public void setCodDocumentoIdentificazione(String codDocumentoIdentificazione) {
        this.codDocumentoIdentificazione = codDocumentoIdentificazione;
    }

    public LocalDate getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(LocalDate dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getDenEnteRilascio() {
        return denEnteRilascio;
    }

    public void setDenEnteRilascio(String denEnteRilascio) {
        this.denEnteRilascio = denEnteRilascio;
    }

    public String getDenLocalitaRilascio() {
        return denLocalitaRilascio;
    }

    public void setDenLocalitaRilascio(String denLocalitaRilascio) {
        this.denLocalitaRilascio = denLocalitaRilascio;
    }

    public String getCodSiglaProvinciaRilascio() {
        return codSiglaProvinciaRilascio;
    }

    public void setCodSiglaProvinciaRilascio(String codSiglaProvinciaRilascio) {
        this.codSiglaProvinciaRilascio = codSiglaProvinciaRilascio;
    }

    public String getCodNazioneRilascio() {
        return codNazioneRilascio;
    }

    public void setCodNazioneRilascio(String codNazioneRilascio) {
        this.codNazioneRilascio = codNazioneRilascio;
    }

    @Override
    public String toString() {
        return "AnagraficaRequest{" +
                "codFiscale='" + codFiscale + '\'' +
                ", codPartitaIva='" + codPartitaIva + '\'' +
                ", denCognome='" + denCognome + '\'' +
                ", denNome='" + denNome + '\'' +
                ", denRagioneSociale='" + denRagioneSociale + '\'' +
                ", tipoSesso='" + tipoSesso + '\'' +
                ", dataNascita=" + dataNascita +
                ", codProvinciaNascita='" + codProvinciaNascita + '\'' +
                ", denComuneNascita='" + denComuneNascita + '\'' +
                ", codNazioneCittadinanza='" + codNazioneCittadinanza + '\'' +
                ", denEmail='" + denEmail + '\'' +
                ", denTelefono='" + denTelefono + '\'' +
                ", tipoRecapitoNominativo='" + tipoRecapitoNominativo + '\'' +
                ", denPresso='" + denPresso + '\'' +
                ", denNumeroCivico='" + denNumeroCivico + '\'' +
                ", codCap='" + codCap + '\'' +
                ", denLocalita='" + denLocalita + '\'' +
                ", codProvincia='" + codProvincia + '\'' +
                ", codNazione='" + codNazione + '\'' +
                ", denIndirizzo='" + denIndirizzo + '\'' +
                ", tipoDocumentoIdentificazione='" + tipoDocumentoIdentificazione + '\'' +
                ", codDocumentoIdentificazione='" + codDocumentoIdentificazione + '\'' +
                ", dataRilascio=" + dataRilascio +
                ", dataScadenza=" + dataScadenza +
                ", denEnteRilascio='" + denEnteRilascio + '\'' +
                ", denLocalitaRilascio='" + denLocalitaRilascio + '\'' +
                ", codSiglaProvinciaRilascio='" + codSiglaProvinciaRilascio + '\'' +
                ", codNazioneRilascio='" + codNazioneRilascio + '\'' +
                '}';
    }
}
