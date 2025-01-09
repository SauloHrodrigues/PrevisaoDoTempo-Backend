package com.projeto_final.PrevisaoDoTempo.service;

import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoResponseDto;
import java.util.List;

public interface DadoMeteorologicoService {

    public DadoResponseDto cadastrarDado(DadoRequestDto dado);

    public List<DadoResponseDto> listarDados();

    public void deletar(Long id);

    public DadoResponseDto  atualizar(Long id, DadoAtualizarDto dadoAtualizarDto);

}