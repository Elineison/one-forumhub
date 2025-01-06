package com.alura.forumhub.controller;

import com.alura.forumhub.dto.LoginDTO;
import com.alura.forumhub.dto.TokenRespostaDTO;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenRespostaDTO> login(@RequestBody @Valid LoginDTO dto) {
        // Cria token de autenticação
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        // Autentica
        Authentication authentication = authenticationManager.authenticate(token);

        // Gera token JWT
        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        // Retorna token
        return ResponseEntity.ok(new TokenRespostaDTO(tokenJWT));
    }
}