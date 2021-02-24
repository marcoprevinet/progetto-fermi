package it.previnet.progettofermi.model;

import it.previnet.progettofermi.model.enums.TipoSessoEntity;

import javax.persistence.*;

@Entity
@Table(name = "nominativo")
public class NominativoEntity {

    @Id
    @SequenceGenerator(name = "tokenNominativoGenerator", sequenceName = "nominativo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenNominativoGenerator")
    @Column(name = "token_nominativo", nullable = false)
    private Long token;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 255)
    private String cognome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sesso", nullable = false, length = 255)
    private TipoSessoEntity tipoSesso;

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }

    public TipoSessoEntity getTipoSesso() {
        return tipoSesso;
    }

    public void setTipoSesso(TipoSessoEntity tipoSesso) {
        this.tipoSesso = tipoSesso;
    }


}
