package com.daviaugusto.projeto.login.controller;


import com.daviaugusto.projeto.login.config.JwtUtil;
import com.daviaugusto.projeto.login.dtos.request.LoginRequest;
import com.daviaugusto.projeto.login.dtos.request.UsuarioRequest;
import com.daviaugusto.projeto.login.dtos.response.UsuarioResponse;
import com.daviaugusto.projeto.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuarioResponse = usuarioService.salvarUsuario(usuarioRequest);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
            String token  = "Bearer" + jwtUtil.gerarToken(authentication.getName());
            return ResponseEntity.ok(Map.of("token" , token));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioResponse> buscarUsuarioEmail(@RequestHeader ("Authorization") String token, @PathVariable String email){
        return ResponseEntity.ok(usuarioService.buscarUsuario(email));
    }



}
