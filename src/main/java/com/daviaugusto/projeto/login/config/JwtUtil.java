package com.daviaugusto.projeto.login.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtUtil {

    private final String chaveSecreta = "minha-chave-super-secreta-com-32-bytes!!";


    public String gerarToken(String username){
        return Jwts.builder()
                .setSubject(username) // Define o nome de usuário como o assunto do token
                .setIssuedAt(new Date()) // Define a data e hora de emissão do token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Define a data e hora de expiração (1 hora a partir da emissão)
                .signWith(Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256) // Converte a chave secreta em bytes e assina o token com ela
                .compact();
    }


    public Claims extrairClaims(String token){
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extrairEmailToken(String token){
        return extrairClaims(token).getSubject();
    }

    public boolean expiracaoToken(String token){
        return extrairClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username){
        final String extrairUsername = extrairEmailToken(token);
        return extrairUsername.equals(username) && !expiracaoToken(token);
    }


}
