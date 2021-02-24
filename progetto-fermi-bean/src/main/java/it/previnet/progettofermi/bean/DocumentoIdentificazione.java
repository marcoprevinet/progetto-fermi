package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.TipoDocumentoIdentificazione;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DocumentoIdentificazione {
    private int tokenDocumentoIdentificazion;
    private int tokenNominativo;
    private TipoDocumentoIdentificazione tipoDocumentoIdentificazione;
    private String codDocumentoIdentificazione;
    private LocalDateTime dataRilascio;
    private LocalDateTime dataScadenza;
    private String denEnteRilascio;
    private String denLocalitaRilascio;
    private String codSiglaProvinciaRilascio;
    private String codNazione;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
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

    public LocalDateTime getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(LocalDateTime dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDateTime dataScadenza) {
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

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
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
