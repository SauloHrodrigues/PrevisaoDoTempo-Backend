package com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico;

import com.projeto_final.PrevisaoDoTempo.core.entities.Cidade;
import com.projeto_final.PrevisaoDoTempo.core.enuns.Clima;
import com.projeto_final.PrevisaoDoTempo.core.enuns.Turno;

import java.time.LocalDate;

public record DadoNovoDto(

        LocalDate data,

        Integer temperaturaMinima,

        Integer temperaturaMaxima,

        Turno turno,

        Clima clima,

        Integer precipitacao,

        Cidade cidade
) {
}
