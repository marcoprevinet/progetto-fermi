package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.TipoRecapitoNominativo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RecapitoNominativo {
    private int tokenRecapitoNominativo;
    private TipoRecapitoNominativo tipoRecapitoNominativo;
    private int tokenNominativo;
    private String denPresso;
    private String denNumeroCivico;
    private String codCap;
    private String denLocalita;
    private String codProvincia;
    private String codNazione;
    private String denIndirizzo;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalDateTime dataTimestamp;
    private String denLogin;

    public int getTokenRecapitoNominativo() {
        return tokenRecapitoNominativo;
    }

    public void setTokenRecapitoNominativo(int tokenRecapitoNominativo) {
        this.tokenRecapitoNominativo = tokenRecapitoNominativo;
    }

    public TipoRecapitoNominativo getTipoRecapitoNominativo() {
        return tipoRecapitoNominativo;
    }

    public void setTipoRecapitoNominativo(TipoRecapitoNominativo tipoRecapitoNominativo) {
        this.tipoRecapitoNominativo = tipoRecapitoNominativo;
    }

    public int getTokenNominativo() {
        return tokenNominativo;
    }

    public void setTokenNominativo(int tokenNominativo) {
        this.tokenNominativo = tokenNominativo;
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

    @Override
    public String toString() {
        return "RecapitoNominativo{" +
                "tokenRecapitoNominativo=" + tokenRecapitoNominativo +
                ", tipoRecapitoNominativo=" + tipoRecapitoNominativo +
                ", tokenNominativo=" + tokenNominativo +
                ", denPresso='" + denPresso + '\'' +
                ", denNumeroCivico='" + denNumeroCivico + '\'' +
                ", codCap='" + codCap + '\'' +
                ", denLocalita='" + denLocalita + '\'' +
                ", codProvincia='" + codProvincia + '\'' +
                ", codNazione='" + codNazione + '\'' +
                ", denIndirizzo='" + denIndirizzo + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", dataTimestamp=" + dataTimestamp +
                ", denLogin='" + denLogin + '\'' +
                '}';
    }
}
