package it.previnet.progettofermi.model;

import it.previnet.progettofermi.model.enums.TipoSessoEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "nominativo")
public class NominativoEntity {

    @Id
    @SequenceGenerator(name = "tokenNominativoGenerator", sequenceName = "nominativo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenNominativoGenerator")
    @Column(name = "token_nominativo", nullable = false)
    private Long tokenNominativo;

    @Column(name = "cod_fiscale", length = 16)
    private String codFiscale;

    @Column(name = "cod_partita_iva", nullable = true, length = 11)
    private String codPartitaIva;

    @Column(name = "den_cognome", nullable = true, length = 80)
    private String denCognome;

    @Column(name = "den_nome", length = 80)
    private String denNome;

    @Column(name = "den_ragione_sociale", length = 80)
    private String denRagioneSociale;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sesso", length = 1)
    private TipoSessoEntity tipoSesso;

    @Column(name = "data_nascita")
    private LocalDateTime dataNascita;

    @Column(name = "cod_provincia_nascita", length = 2)
    private String codProvinciaNascita;

    @Column(name = "den_comune_nascita", length = 80)
    private String denComuneNascita;

    @Column(name = "cod_nazione_cittadinanza", length = 3)
    private String codNazioneCittadinanza;

    @Column(name = "den_email", length = 80)
    private String denEmail;

    @Column(name = "den_telefono", length = 80)
    private String denTelefono;

    @Column(name = "data_timestamp")
    private String dataTimestamp;

    @Column(name = "den_login", length = 80)
    private LocalDateTime denLogin;


    public Long getTokenNominativo() {
        return tokenNominativo;
    }

    public void setTokenNominativo(Long tokenNominativo) {
        this.tokenNominativo = tokenNominativo;
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

    public String getDenNome() {
        return denNome;
    }

    public void setDenNome(String denNome) {
        this.denNome = denNome;
    }

    public String getDenCognome() {
        return denCognome;
    }

    public void setDenCognome(String denCognome) {
        this.denCognome = denCognome;
    }

    public String getDenRagioneSociale() {
        return denRagioneSociale;
    }

    public void setDenRagioneSociale(String denRagioneSociale) {
        this.denRagioneSociale = denRagioneSociale;
    }

    public TipoSessoEntity getTipoSesso() {
        return tipoSesso;
    }

    public void setTipoSesso(TipoSessoEntity tipoSesso) {
        this.tipoSesso = tipoSesso;
    }

    public LocalDateTime getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDateTime dataNascita) {
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

    public String getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(String dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    public LocalDateTime getDenLogin() {
        return denLogin;
    }

    public void setDenLogin(LocalDateTime denLogin) {
        this.denLogin = denLogin;
    }
}
