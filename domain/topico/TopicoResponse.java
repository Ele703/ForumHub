package com.forumhub.domain.topico;

import java.time.LocalDateTime;

public record TopicoResponse(Long id, String titulo, String mensagem, String autor, String curso, LocalDateTime dataCriacao) {}
