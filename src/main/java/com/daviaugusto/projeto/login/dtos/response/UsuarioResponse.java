package com.daviaugusto.projeto.login.dtos.response;


import lombok.*;

import java.time.LocalDate;

@Builder
public class UsuarioResponse {

    private String nome;
    private LocalDate dataNascimento;
    private String email;


    public UsuarioResponse() {
    }

    public UsuarioResponse(String nome, LocalDate dataNascimento, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
