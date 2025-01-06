package com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CriarTopicoDTO(
        @NotBlank(message = "Título é obrigatório")
        @Size(min = 5, max = 255, message = "Título deve ter entre 5 e 255 caracteres")
        String titulo,

        @NotBlank(message = "Mensagem é obrigatória")
        @Size(min = 10, message = "Mensagem deve ter no mínimo 10 caracteres")
        String mensagem,

        @NotBlank(message = "Autor é obrigatório")
        String nomeAutor,

        @NotBlank(message = "Curso é obrigatório")
        String nomeCurso
) {}