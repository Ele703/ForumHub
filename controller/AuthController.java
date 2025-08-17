package com.forumhub.controller;

import com.forumhub.infra.security.AutenticacaoService;
import com.forumhub.domain.usuario.Usuario;
import com.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final AutenticacaoService autenticacaoService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // criar usuário (para facilitar testes)
    @PostMapping("/usuarios")
    public ResponseEntity<?> criaUsuario(@RequestBody @Valid Usuario usuario) {
        // criptografa senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(Map.of("id", usuario.getId(), "email", usuario.getEmail()));
    }

    // login -> retorna token
    record LoginRequest(String email, String senha) {}

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest dados) {
        var token = autenticacaoService.autenticarRetornaToken(dados.email(), dados.senha());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
