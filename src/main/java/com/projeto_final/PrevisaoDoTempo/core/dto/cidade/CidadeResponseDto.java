package com.projeto_final.PrevisaoDoTempo.core.dto.cidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto_final.PrevisaoDoTempo.core.entities.DadoMeteorologico;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;

import java.util.List;

public record CidadeResponseDto(
        Long id,

        String nome,

        @JsonIgnore
        Estado estado,

//        @JsonIgnore
        List<DadoMeteorologico> dadoMeteorologicos
) {
}
