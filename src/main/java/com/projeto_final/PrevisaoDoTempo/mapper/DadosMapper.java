package com.projeto_final.PrevisaoDoTempo.mapper;

import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoNovoDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.DadoMeteorologico;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DadosMapper {

    DadosMapper INSTANCE = Mappers.getMapper(DadosMapper.class);

    @Mapping(target = "id", ignore = true)
    DadoMeteorologico dtoToDado(DadoNovoDto dadoNovoDto);

    List<DadoResponseDto> listDadosToResponseDto(List<DadoMeteorologico> dados);

    DadoResponseDto dadoToResponseDto(DadoMeteorologico dadoMeteorologico);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "data", ignore = true)
    @Mapping(target = "cidade", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDadoMeteorologico(@MappingTarget DadoMeteorologico dadoMeteorologico, DadoAtualizarDto dadoAtualizarDto);

}