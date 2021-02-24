package it.previnet.progettofermi.model;


import it.previnet.progettofermi.model.enums.TipoDocumentoIdentificazioneEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "documento_identificazione")
public class DocumentoIdentificazioneEntity {

    @Id
    @SequenceGenerator(name = "tokenDocumentoIdentificazioneGenerator", sequenceName = "documento_identificazione_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenDocumentoIdentificazioneGenerator")
    @Column(name = "token_documento_identificazion", nullable = false)
    private int tokenDocumentoIdentificazion;

    @Column(name = "token_nominativo", nullable = false)
    private int tokenNominativo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento_identificazione", length = 2)
    private TipoDocumentoIdentificazioneEntity tipoDocumentoIdentificazione;

    @Column(name = "cod_documento_identificazione", length = 20)
    private String codDocumentoIdentificazione;

    @Column(name = "data_rilascio")
    private LocalDateTime dataRilascio;

    @Column(name = "data_scadenza")
    private LocalDateTime dataScadenza;

    @Column(name = "den_ente_rilascio", length = 80)
    private String denEnteRilascio;

    @Column(name = "den_localita_rilascio", length = 80)
    private String denLocalitaRilascio;

    @Column(name = "cod_sigla_provincia_rilascio", length = 3)
    private String codSiglaProvinciaRilascio;

    @Column(name = "cod_nazione", length = 3)
    private String codNazione;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Column(name = "data_timestamp")
    private LocalDateTime dataTimestamp;

    @Column(name = "den_login", length = 80)
    private String denLogin;

    @Column(name = "content")
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

    public TipoDocumentoIdentificazioneEntity getTipoDocumentoIdentificazione() {
        return tipoDocumentoIdentificazione;
    }

    public void setTipoDocumentoIdentificazione(TipoDocumentoIdentificazioneEntity tipoDocumentoIdentificazione) {
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
}
