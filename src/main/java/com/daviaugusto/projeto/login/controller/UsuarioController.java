package com.daviaugusto.projeto.login.controller;


import com.daviaugusto.projeto.login.dtos.request.UsuarioRequest;
import com.daviaugusto.projeto.login.dtos.response.UsuarioResponse;
import com.daviaugusto.projeto.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping()
    public ResponseEntity<UsuarioResponse> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuarioRequest));
    }



}
