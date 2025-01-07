-- Inserir usuários com senha criptografada
INSERT INTO usuario (nome, email, senha) VALUES
                                             ('João Silva', 'joao@email.com', '$2a$10$GVRc4.307KMzxTXWqEzQ7.LxE1kqyWRRtc5x8Kz1YIqfGNa/sCGAq'),
                                             ('Maria Souza', 'maria@email.com', '$2a$10$GVRc4.307KMzxTXWqEzQ7.LxE1kqyWRRtc5x8Kz1YIqfGNa/sCGAq');

-- Inserir cursos
INSERT INTO curso (nome, categoria) VALUES
                                        ('Spring Boot Avançado', 'Programação'),
                                        ('Java Básico', 'Programação'),
                                        ('Desenvolvimento Web', 'Web');

-- Inserir tópicos de exemplo
INSERT INTO topico (titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES
                                                                                    ('Dúvida sobre Spring Boot', 'Como configurar migrations no Spring Boot?', NOW(), 'ABERTO', 1, 1),
                                                                                    ('Problema com Java', 'Não consigo entender herança em Java', NOW(), 'ABERTO', 2, 2),
                                                                                    ('Desenvolvimento Web', 'Quais são as melhores práticas para front-end?', NOW(), 'RESPONDIDO', 1, 3);