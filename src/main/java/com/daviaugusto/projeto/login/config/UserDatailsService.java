package com.daviaugusto.projeto.login.config;

import com.daviaugusto.projeto.login.entities.Usuario;
import com.daviaugusto.projeto.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDatailsService implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
