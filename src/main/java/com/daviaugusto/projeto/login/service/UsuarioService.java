package com.daviaugusto.projeto.login.service;

import com.daviaugusto.projeto.login.converter.UsuarioConverter;
import com.daviaugusto.projeto.login.dtos.request.UsuarioRequest;
import com.daviaugusto.projeto.login.dtos.response.UsuarioResponse;
import com.daviaugusto.projeto.login.entities.Usuario;
import com.daviaugusto.projeto.login.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private UsuarioConverter usuarioConverter;


    public UsuarioResponse salvarUsuario(UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioRequest);
        if(verificarEmail(usuario.getEmail())){
            throw new RuntimeException("Já existe um usuário com esse email");
        }
        else{
            usuarioRepository.save(usuario);
            return usuarioConverter.paraUsuarioResponse(usuario);
        }
    }


    public boolean verificarEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }


}
