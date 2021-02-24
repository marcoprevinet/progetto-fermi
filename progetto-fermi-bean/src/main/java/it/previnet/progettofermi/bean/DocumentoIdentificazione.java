package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DocumentoIdentificazione {
    private int tokenDocumentoIdentificazion;
    private int tokenNominativo;
    private TipoDocumentoIdentificazione tipoDocumentoIdentificazione;
    private String codDocumentoIdentificazione;
    private LocalDate dataRilascio;
    private LocalDate dataScadenza;
    private String denEnteRilascio;
    private String denLocalitaRilascio;
    private String codSiglaProvinciaRilascio;
    private String codNazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalDateTime dataTimestamp;
    private String denLogin;
    private byte[] content;

    public int getTokenDocumentoIdentificazion() {
        return tokenDocumentoIdentificazion;
    }

    public void setTokenDocumentoIdentificazion(int tokenDocumentoIdentificazion) {
        this.tokenDocumentoIdentificazion = tokenDocumentoIdentificazion;
    }

    public int getTokenNominativo() {
        return tokenNominativo;
    }

    public void setTokenNominativo(int tokenNominativo) {
        this.tokenNominativo = tokenNominativo;
    }

    public TipoDocumentoIdentificazione getTipoDocumentoIdentificazione() {
        return tipoDocumentoIdentificazione;
    }

    public void setTipoDocumentoIdentificazione(TipoDocumentoIdentificazione tipoDocumentoIdentificazione) {
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

    public String getCodNazione() {
        return codNazione;
    }

    public void setCodNazione(String codNazione) {
        this.codNazione = codNazione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public LocalDateTime getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(LocalDateTime dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    public String getDenLogin() {
        return denLogin;
    }

    public void setDenLogin(String denLogin) {
        this.denLogin = denLogin;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DocumentoIdentificazione{" +
                "tokenDocumentoIdentificazion=" + tokenDocumentoIdentificazion +
                ", tokenNominativo=" + tokenNominativo +
                ", tipoDocumentoIdentificazione=" + tipoDocumentoIdentificazione +
                ", codDocumentoIdentificazione='" + codDocumentoIdentificazione + '\'' +
                ", dataRilascio=" + dataRilascio +
                ", dataScadenza=" + dataScadenza +
                ", denEnteRilascio='" + denEnteRilascio + '\'' +
                ", denLocalitaRilascio='" + denLocalitaRilascio + '\'' +
                ", codSiglaProvinciaRilascio='" + codSiglaProvinciaRilascio + '\'' +
                ", codNazione='" + codNazione + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", dataTimestamp=" + dataTimestamp +
                ", denLogin='" + denLogin + '\'' +
                ", content=[array of " + (content != null ? content.length : 0) + " bytes]" +
                '}';
    }
}
