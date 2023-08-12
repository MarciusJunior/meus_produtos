package com.meus_produtos_api.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.meus_produtos_api.backend.dto.AccessToken;
import com.meus_produtos_api.backend.model.Usuarios;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public AccessToken gerarToken(Usuarios usuario) {

        String token = JWT.create()
                .withIssuer("Produtos")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withClaim("name", usuario.getName())
                .withClaim("email", usuario.getEmail())
                .withExpiresAt(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("paralelepipedo"));

        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(token);
        accessToken.setId(usuario.getId());
        accessToken.setName(usuario.getName());
        accessToken.setEmail(usuario.getEmail());

        return accessToken;

    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("paralelepipedo"))
                .withIssuer("Produtos")
                .build().verify(token).getSubject();

    }
}
