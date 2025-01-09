package com.projeto_final.PrevisaoDoTempo.core.dto.cidade;

import com.projeto_final.PrevisaoDoTempo.core.entities.DadoMeteorologico;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;

public record CidadeRequestDdo(
        String nome,

        Estado estado,

        DadoMeteorologico dadoMeteorologico
) {
}
