package com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico;

import com.projeto_final.PrevisaoDoTempo.core.enuns.Clima;
import com.projeto_final.PrevisaoDoTempo.core.enuns.Turno;

public record DadoAtualizarDto(

        Integer temperaturaMinima,

        Integer temperaturaMaxima,

        Turno turno,

        Clima clima,

        Integer precipitacao
) {
}