package com.meus_produtos_api.backend.controller;

import com.meus_produtos_api.backend.dto.AccessToken;
import com.meus_produtos_api.backend.dto.Login;
import com.meus_produtos_api.backend.model.Usuarios;
import com.meus_produtos_api.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());

        Authentication authenticate =
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuarios) authenticate.getPrincipal();

        AccessToken accessToken = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(accessToken);

    }

}
