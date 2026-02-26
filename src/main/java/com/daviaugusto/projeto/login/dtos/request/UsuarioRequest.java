package com.daviaugusto.projeto.login.dtos.request;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {


    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;

}
