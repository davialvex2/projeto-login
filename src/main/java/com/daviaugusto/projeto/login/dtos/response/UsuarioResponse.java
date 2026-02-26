package com.daviaugusto.projeto.login.dtos.response;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private String nome;
    private LocalDate dataNascimento;
    private String email;


}
