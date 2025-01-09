package com.projeto_final.PrevisaoDoTempo.fixture;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;

import java.util.ArrayList;

public class EstadoFixture {

    public static EstadoRequestDto estadoDto(){
        return new EstadoRequestDto(
                "São Paulo"
        );
    }

    public static Estado estadoEntidade(){
        return new Estado(
                1L,
                "Sao Paulo",
                null
        );
    }

    public static EstadoResponseDto estadoResponseDto(){
        return new EstadoResponseDto(
                1L,
                "São Paulo",
                new ArrayList<>()
        );
    }
}