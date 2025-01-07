package com.alura.forumhub.model;

public enum StatusTopico {
    ABERTO("Aberto"),
    FECHADO("Fechado"),
    RESPONDIDO("Respondido");

    private final String descricao;

    StatusTopico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}