package com.pedrooomv.crud_usuarios.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtSecurity {

    private final String secretPassword = "pxdrinDaDuvs12345678910111213141";

    private final long EXPIRATION = 1000 * 60 * 60;

    private Key gerarTokenDeLogin(){
        return Keys.hmacShaKeyFor(secretPassword.getBytes());
    }

    public String gerarToken(String username){
        return Jwts.builder()
                .setSubject(username).setIssuedAt(new Date()).setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION)).signWith(
                                gerarTokenDeLogin(), SignatureAlgorithm.HS256).compact();
    }

    public String extrairToken(String token){
        return Jwts.parserBuilder().setSigningKey(gerarTokenDeLogin()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(gerarTokenDeLogin()).build().parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }
}
