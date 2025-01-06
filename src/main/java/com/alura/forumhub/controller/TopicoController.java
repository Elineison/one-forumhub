package com.alura.forumhub.controller;

import com.alura.forumhub.dto.*;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DetalhesTopicoDTO> criarTopico(
            @RequestBody @Valid CriarTopicoDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        // Obter usuário autenticado
        Usuario usuarioAutenticado = obterUsuarioAutenticado();

        // Passar usuário autenticado para o serviço
        DetalhesTopicoDTO topico = topicoService.criarTopico(dto, usuarioAutenticado);

        URI uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.id())
                .toUri();

        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopicoDTO>> listarTopicos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho
    ) {
        Page<ListagemTopicoDTO> topicos = topicoService.listarTopicos(pagina, tamanho);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> detalharTopico(@PathVariable Long id) {
        DetalhesTopicoDTO topico = topicoService.buscarTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> atualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid AtualizarTopicoDTO dto
    ) {
        // Obter usuário autenticado
        Usuario usuarioAutenticado = obterUsuarioAutenticado();

        DetalhesTopicoDTO topico = topicoService.atualizarTopico(id, dto, usuarioAutenticado);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        // Obter usuário autenticado
        Usuario usuarioAutenticado = obterUsuarioAutenticado();

        topicoService.excluirTopico(id, usuarioAutenticado);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para obter usuário autenticado
    private Usuario obterUsuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Usuario) authentication.getPrincipal();
    }
}