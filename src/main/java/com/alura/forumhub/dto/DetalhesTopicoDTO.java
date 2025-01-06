package com.alura.forumhub.dto;

import com.alura.forumhub.model.Topico;
import java.time.LocalDateTime;

public record DetalhesTopicoDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String nomeAutor,
        String nomeCurso
) {
    public DetalhesTopicoDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().name(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }
}