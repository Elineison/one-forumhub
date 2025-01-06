package com.alura.forumhub.dto;

import com.alura.forumhub.model.Topico;
import java.time.LocalDateTime;

public record ListagemTopicoDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String nomeAutor,
        String nomeCurso
) {
    public ListagemTopicoDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().toString(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }
}