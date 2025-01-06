package com.alura.forumhub.service;

import com.alura.forumhub.dto.*;
import com.alura.forumhub.model.Curso;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.repository.CursoRepository;
import com.alura.forumhub.repository.TopicoRepository;
import com.alura.forumhub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public DetalhesTopicoDTO criarTopico(CriarTopicoDTO dto, Usuario autor) {
        Curso curso = cursoRepository.findByNome(dto.nomeCurso())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setAutor(autor);
        topico.setCurso(curso);

        return new DetalhesTopicoDTO(topicoRepository.save(topico));
    }

    public Page<ListagemTopicoDTO> listarTopicos(int pagina, int tamanho) {
        Pageable paginacao = PageRequest.of(pagina, tamanho, Sort.by("dataCriacao").ascending());
        return topicoRepository.findAll(paginacao).map(ListagemTopicoDTO::new);
    }

    public DetalhesTopicoDTO buscarTopicoPorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));
        return new DetalhesTopicoDTO(topico);
    }

    @Transactional
    public DetalhesTopicoDTO atualizarTopico(Long id, AtualizarTopicoDTO dto, Usuario usuarioAutenticado) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        // Verificar se o usuário é o autor do tópico
        if (!topico.getAutor().getId().equals(usuarioAutenticado.getId())) {
            throw new AccessDeniedException("Usuário não tem permissão para atualizar este tópico");
        }

        Curso curso = cursoRepository.findByNome(dto.nomeCurso())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setCurso(curso);

        return new DetalhesTopicoDTO(topicoRepository.save(topico));
    }

    @Transactional
    public void excluirTopico(Long id, Usuario usuarioAutenticado) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        // Verificar se o usuário é o autor do tópico
        if (!topico.getAutor().getId().equals(usuarioAutenticado.getId())) {
            throw new AccessDeniedException("Usuário não tem permissão para excluir este tópico");
        }

        topicoRepository.deleteById(id);
    }
}