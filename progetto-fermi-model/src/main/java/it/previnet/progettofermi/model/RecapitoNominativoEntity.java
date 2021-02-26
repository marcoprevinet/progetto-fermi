package it.previnet.progettofermi.model;

import it.previnet.progettofermi.model.enums.TipoRecapitoNominativoEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "recapito_nominativo")
public class RecapitoNominativoEntity {

    @Id
    @SequenceGenerator(name = "tokenRecapitoNominativoGenerator", sequenceName = "recapito_nominativo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenRecapitoNominativoGenerator")
    @Column(name = "token_recapito_nominativo", nullable = false)
    private Integer tokenRecapitoNominativo;

    @Convert(converter = TipoRecapitoNominativoEnumConverter.class)
    @Column(name = "tipo_recapito_nominativo", length = 3)
    private TipoRecapitoNominativoEntity tipoRecapitoNominativo;

    @Column(name = "den_presso", length = 80)
    private String denPresso;

    @Column(name = "den_numero_civico", length = 10)
    private String denNumeroCivico;

    @Column(name = "cod_cap", length = 5)
    private String codCap;

    @Column(name = "den_localita", length = 80)
    private String denLocalita;

    @Column(name = "cod_provincia", length = 3)
    private String codProvincia;

    @Column(name = "cod_nazione", length = 3)
    private String codNazione;

    @Column(name = "den_indirizzo", length = 80)
    private String denIndirizzo;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @Column(name = "data_timestamp")
    private LocalDateTime dataTimestamp;

    @Column(name = "den_login", length = 80)
    private String denLogin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="token_nominativo")
    private NominativoEntity nominativo;

    public Integer getTokenRecapitoNominativo() {
        return tokenRecapitoNominativo;
    }

    public void setTokenRecapitoNominativo(Integer tokenRecapitoNominativo) {
        this.tokenRecapitoNominativo = tokenRecapitoNominativo;
    }

    public TipoRecapitoNominativoEntity getTipoRecapitoNominativo() {
        return tipoRecapitoNominativo;
    }

    public void setTipoRecapitoNominativo(TipoRecapitoNominativoEntity tipoRecapitoNominativo) {
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

    public NominativoEntity getNominativo() {
        return nominativo;
    }

    public void setNominativo(NominativoEntity nominativo) {
        this.nominativo = nominativo;
    }
}
