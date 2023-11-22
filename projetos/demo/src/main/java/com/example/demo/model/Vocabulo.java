package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name ="vocabulo")
public class Vocabulo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "termo", nullable = false)
    private String termo;

    @Column(name = "significado", nullable = false)
    private String significado;

    @Column(name = "versao", nullable = false)
    private String versao;


    public Vocabulo(Long id, String termo, String significado, String versao) {
        this.id = id;
        this.termo = termo;
        this.significado = significado;
        this.versao = versao;
    }

    public Vocabulo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
