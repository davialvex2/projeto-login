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

    private final String chaveSecreta = "123456789";


    public String gerarToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +1000 *60*60))
                .signWith(Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
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
