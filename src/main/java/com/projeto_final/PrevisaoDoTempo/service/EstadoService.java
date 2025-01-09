package com.projeto_final.PrevisaoDoTempo.service;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;

import java.util.List;

public interface EstadoService {

    EstadoResponseDto registrar(EstadoRequestDto requestDdo);

    List<EstadoResponseDto> buscar();

    EstadoResponseDto buscar(Long id);

    EstadoResponseDto buscarNome(String nome);

    EstadoResponseDto alterar(Long id, EstadoAtualizarDto estadoAtualizarDto);

    EstadoResponseDto alterar(String nome, EstadoAtualizarDto estadoAtualizarDto);

    boolean excluir(Long id);

    boolean excluir(String nome);
}