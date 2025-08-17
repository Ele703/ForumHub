package com.forumhub.domain.topico;

import com.forumhub.domain.curso.Curso;
import com.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Usuario autor;

    private LocalDateTime dataCriacao = LocalDateTime.now();
}
