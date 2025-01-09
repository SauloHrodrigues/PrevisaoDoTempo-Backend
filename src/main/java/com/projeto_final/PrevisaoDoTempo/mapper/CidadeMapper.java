package com.projeto_final.PrevisaoDoTempo.mapper;

import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeAtualizadaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeRequestDdo;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Cidade;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);

    @Mapping(target = "id", ignore = true)
    Cidade dtoToCidada(CidadeRequestDdo cidadeRequestDdo);

    CidadeResponseDto cidadeToResponseDto(Cidade cidade);

    List<CidadeResponseDto> cidadeListToResponnseDtoList(List<Cidade> cidade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "dadosMeteorologicos", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCidadeFromCidadeResponseDto(@MappingTarget Cidade cidade, CidadeAtualizadaDto cidadeAtualizadaDto);


}