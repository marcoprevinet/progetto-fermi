package it.previnet.progettofermi.bean;

import it.previnet.progettofermi.bean.enums.TipoSesso;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Nominativo {
    private Integer tokenNominativo;
    private String codFiscale;
    private String codPartitaIva;
    private String denCognome;
    private String denNome;
    private String denRagioneSociale;
    private TipoSesso tipoSesso;
    private LocalDate dataNascita;
    private String codProvinciaNascita;
    private String denComuneNascita;
    private String codNazioneCittadinanza;
    private String denEmail;
    private String denTelefono;
	private String denCellulare;
    private LocalDateTime dataTimestamp;
    private String denLogin;
    private RecapitoNominativo recapitoNominativo;
    private DocumentoIdentificazione documentoIdentificazione;

    public Integer getTokenNominativo() {
        return tokenNominativo;
    }

    public void setTokenNominativo(Integer tokenNominativo) {
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

    public TipoSesso getTipoSesso() {
        return tipoSesso;
    }

    public void setTipoSesso(TipoSesso tipoSesso) {
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

    public RecapitoNominativo getRecapitoNominativo() {
        return recapitoNominativo;
    }

    public void setRecapitoNominativo(RecapitoNominativo recapitoNominativo) {
        this.recapitoNominativo = recapitoNominativo;
    }

    public DocumentoIdentificazione getDocumentoIdentificazione() {
        return documentoIdentificazione;
    }

    public void setDocumentoIdentificazione(DocumentoIdentificazione documentoIdentificazione) {
        this.documentoIdentificazione = documentoIdentificazione;
    }

    @Override
    public String toString() {
        return "Nominativo{" +
                "tokenNominativo=" + tokenNominativo +
                ", codFiscale='" + codFiscale + '\'' +
                ", codPartitaIva='" + codPartitaIva + '\'' +
                ", denCognome='" + denCognome + '\'' +
                ", denNome='" + denNome + '\'' +
                ", denRagioneSociale='" + denRagioneSociale + '\'' +
                ", tipoSesso=" + tipoSesso +
                ", dataNascita=" + dataNascita +
                ", codProvinciaNascita='" + codProvinciaNascita + '\'' +
                ", denComuneNascita='" + denComuneNascita + '\'' +
                ", codNazioneCittadinanza='" + codNazioneCittadinanza + '\'' +
                ", denEmail='" + denEmail + '\'' +
                ", denTelefono='" + denTelefono + '\'' +
                ", dataTimestamp=" + dataTimestamp +
                ", denLogin='" + denLogin + '\'' +
                ", recapitoNominativo=" + recapitoNominativo +
                ", documentoIdentificazione=" + documentoIdentificazione +
                '}';
    }
}
