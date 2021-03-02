package it.previnet.progettofermi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "example")
public class ExampleEntity {

    @Id
    @SequenceGenerator(name = "tokenExampleGenerator", sequenceName = "example_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokenExampleGenerator")
    @Column(name = "token_example", nullable = false)
    private Integer token;

    @Column(name = "stato", nullable = false, length = 255)
    private String stato;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }


}
