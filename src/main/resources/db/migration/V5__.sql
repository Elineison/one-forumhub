CREATE TABLE curso
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    nome      VARCHAR(255)          NULL,
    categoria VARCHAR(255)          NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE topico
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    titulo       VARCHAR(255)          NULL,
    mensagem     VARCHAR(255)          NULL,
    data_criacao datetime              NULL,
    status       VARCHAR(255)          NULL,
    autor_id     BIGINT                NULL,
    curso_id     BIGINT                NULL,
    CONSTRAINT pk_topico PRIMARY KEY (id)
);

CREATE TABLE usuario
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    nome  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    senha VARCHAR(255)          NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

ALTER TABLE topico
    ADD CONSTRAINT FK_TOPICO_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuario (id);

ALTER TABLE topico
    ADD CONSTRAINT FK_TOPICO_ON_CURSO FOREIGN KEY (curso_id) REFERENCES curso (id);