package com.projeto_final.PrevisaoDoTempo.service;

import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeAtualizadaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeNovaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeResponseDto;

import java.util.List;

public interface CidadeService {

    CidadeResponseDto registrar(CidadeNovaDto cidadeNovaDto);

    List<CidadeResponseDto> buscar();

    CidadeResponseDto buscar(Long id);

    CidadeResponseDto buscar(String nome);

    CidadeResponseDto alterar(Long id, CidadeAtualizadaDto cidadeAtualizadaDto);

    CidadeResponseDto alterar(String nome, CidadeAtualizadaDto cidadeAtualizadaDto);

    boolean excluir(Long id);

    boolean excluir(String nome);
}