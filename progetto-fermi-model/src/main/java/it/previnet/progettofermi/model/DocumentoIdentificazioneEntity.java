package it.previnet.progettofermi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "documento_identificazione")
public class DocumentoIdentificazioneEntity {

    @Id
    @SequenceGenerator(name = "tokenDocumentoIdentificazioneGenerator", sequenceName = "documento_identificazione_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenDocumentoIdentificazioneGenerator")
    @Column(name = "token_documento_identificazion", nullable = false)
    private Integer tokenDocumentoIdentificazion;

    @Column(name = "tipo_documento_identificazione", length = 2)
    private String tipoDocumentoIdentificazione;

    @Column(name = "cod_documento_identificazione", length = 20)
    private String codDocumentoIdentificazione;

    @Column(name = "data_rilascio")
    private LocalDate dataRilascio;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @Column(name = "den_ente_rilascio", length = 80)
    private String denEnteRilascio;

    @Column(name = "den_localita_rilascio", length = 80)
    private String denLocalitaRilascio;

    @Column(name = "cod_sigla_provincia_rilascio", length = 3)
    private String codSiglaProvinciaRilascio;

    @Column(name = "cod_nazione", length = 3)
    private String codNazione;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @Column(name = "data_timestamp")
    private LocalDateTime dataTimestamp;

    @Column(name = "den_login", length = 80)
    private String denLogin;

    @Column(name = "content")
    private byte[] content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token_nominativo")
    private NominativoEntity nominativo;

    public Integer getTokenDocumentoIdentificazion() {
        return tokenDocumentoIdentificazion;
    }

    public void setTokenDocumentoIdentificazion(Integer tokenDocumentoIdentificazion) {
        this.tokenDocumentoIdentificazion = tokenDocumentoIdentificazion;
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

    public NominativoEntity getNominativo() {
        return nominativo;
    }

    public void setNominativo(NominativoEntity nominativo) {
        this.nominativo = nominativo;
    }
}
