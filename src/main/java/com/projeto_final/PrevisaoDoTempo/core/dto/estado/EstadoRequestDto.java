package com.projeto_final.PrevisaoDoTempo.core.dto.estado;
import jakarta.validation.constraints.NotBlank;

public record EstadoRequestDto(
        @NotBlank(message = "O campo nome é obrigatório")
        String nome
) {}
