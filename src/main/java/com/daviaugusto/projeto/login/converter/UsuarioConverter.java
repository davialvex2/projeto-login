package com.daviaugusto.projeto.login.converter;


import com.daviaugusto.projeto.login.dtos.request.UsuarioRequest;
import com.daviaugusto.projeto.login.dtos.response.UsuarioResponse;
import com.daviaugusto.projeto.login.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {


  public Usuario paraUsuario(UsuarioRequest usuarioRequest){
      return Usuario.builder()
              .nome(usuarioRequest.getNome())
              .senha(usuarioRequest.getSenha())
              .dataNascimento(usuarioRequest.getDataNascimento())
              .email(usuarioRequest.getEmail())
              .build();
  }

  public UsuarioResponse paraUsuarioResponse(Usuario usuario){
      return UsuarioResponse.builder()
              .email(usuario.getEmail())
              .dataNascimento(usuario.getDataNascimento())
              .nome(usuario.getNome())
              .build();
  }





}
