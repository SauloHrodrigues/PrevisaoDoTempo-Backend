package com.projeto_final.PrevisaoDoTempo.mapper;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoMapper {

    EstadoMapper INSTANCE = Mappers.getMapper(EstadoMapper.class);

    @Mapping(target = "id", ignore = true)
    Estado requestToEstado(EstadoRequestDto requestDto);

    EstadoResponseDto estadoToResponseDto(Estado estado);

    List<EstadoResponseDto> estadoListToResponnseDtoList(List<Estado> estados);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cidades", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEstadoFromEstadoResponseDto(@MappingTarget Estado estado, EstadoAtualizarDto estadoAtualizarDto);


}