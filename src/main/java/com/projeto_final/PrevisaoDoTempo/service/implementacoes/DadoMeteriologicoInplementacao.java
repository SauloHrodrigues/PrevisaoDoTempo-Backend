package com.projeto_final.PrevisaoDoTempo.service.implementacoes;

import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoNovoDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Cidade;
import com.projeto_final.PrevisaoDoTempo.core.entities.DadoMeteorologico;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoNaoEncontradoExcepition;
import com.projeto_final.PrevisaoDoTempo.mapper.DadosMapper;
import com.projeto_final.PrevisaoDoTempo.repositories.DadoMeteorologicoRepository;
import com.projeto_final.PrevisaoDoTempo.service.DadoMeteorologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadoMeteriologicoInplementacao implements DadoMeteorologicoService {

    @Autowired
    private DadoMeteorologicoRepository repository;

    @Autowired
    private CidadeService cidadeService;

    private final DadosMapper mapper = DadosMapper.INSTANCE;

    public DadoResponseDto cadastrarDado(DadoRequestDto dadoRequestDto) {

        Cidade cidade = cidadeService.buscarCidadePorNome(dadoRequestDto.cidade());

        DadoNovoDto dadoNovoDto = new DadoNovoDto(
                dadoRequestDto.data(),
                dadoRequestDto.temperaturaMinima(),
                dadoRequestDto.temperaturaMaxima(),
                dadoRequestDto.turno(),
                dadoRequestDto.clima(),
                dadoRequestDto.precipitacao(),
                cidade
        );

        DadoMeteorologico dadoSalvo = repository.save(mapper.dtoToDado(dadoNovoDto));
        cidadeService.adicionarDadoNaCidade(cidade,dadoSalvo);


        return null;
    }

    public List<DadoResponseDto> listarDados(){
        return mapper.listDadosToResponseDto(repository.findAll());
    }

    public void deletar(Long id) {
        DadoMeteorologico dado = buscarDado(id);
        repository.delete(dado);
    }

    @Override
    public DadoResponseDto  atualizar(Long id, DadoAtualizarDto dadoAtualizarDto) {
        DadoMeteorologico dadoAAtualizar = buscarDado(id);
        mapper.updateDadoMeteorologico(dadoAAtualizar, dadoAtualizarDto);
        repository.save(dadoAAtualizar);
        return mapper.dadoToResponseDto(dadoAAtualizar);
    }

    public DadoMeteorologico buscarDado(Long id){

        Optional<DadoMeteorologico> dado = repository.findById(id);

        if(dado.isPresent()){
            return dado.get();
        }else {
            throw new ObjetoNaoEncontradoExcepition("O dado meteorologico id " + id +
                    " não consta cadastrada no sistema.");
        }
    }

}