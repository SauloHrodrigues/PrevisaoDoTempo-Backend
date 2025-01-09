package com.projeto_final.PrevisaoDoTempo.service.implementacoes;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoJaCadastradoExcepition;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoNaoEncontradoExcepition;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoNaoPodeSerDeletadoException;
import com.projeto_final.PrevisaoDoTempo.mapper.EstadoMapper;
import com.projeto_final.PrevisaoDoTempo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService implements com.projeto_final.PrevisaoDoTempo.service.EstadoService {

    @Autowired
    private EstadoRepository repository;

    private final EstadoMapper mapper = EstadoMapper.INSTANCE;

    @Override
    public EstadoResponseDto registrar(EstadoRequestDto requestDdo) {

        Estado estado = estadoExiste(requestDdo.nome());

        if (estado != null) {
            throw new ObjetoJaCadastradoExcepition("Estado já cadastrado no sistema");
        }

        Estado novoEstado = repository.save(mapper.requestToEstado(requestDdo));

        return mapper.estadoToResponseDto(novoEstado);
    }

    @Override
    public List<EstadoResponseDto> buscar() {
        return mapper.estadoListToResponnseDtoList(repository.findAll());
    }

    @Override
    public EstadoResponseDto buscar(Long id) {

        Estado estado = estadoExiste(id);

        if(estado == null) {
            throw new ObjetoNaoEncontradoExcepition("Estado não cadastrado no sistema");
        }

        return mapper.estadoToResponseDto(estado);
    }

    @Override
    public EstadoResponseDto buscarNome(String nome) {

        Estado estado = estadoExiste(nome);
        if(estado == null){
            throw new ObjetoNaoEncontradoExcepition("Estado não cadastrado.");
        }

        return mapper.estadoToResponseDto(estado);
    }

    @Override
    public EstadoResponseDto alterar(Long id, EstadoAtualizarDto estadoAtualizarDto) {

        Estado estado = estadoExiste(id);

        if(estado == null){
            throw new ObjetoNaoEncontradoExcepition("O estado de Id " + id + " não foi encontrado em nosso banco.");
        }

        mapper.updateEstadoFromEstadoResponseDto(estado, estadoAtualizarDto);
        repository.save(estado);

        return mapper.estadoToResponseDto(estado);
    }

    @Override
    public EstadoResponseDto alterar(String nome, EstadoAtualizarDto estadoAtualizarDto) {
        return null;
    }

    @Override
    public boolean excluir(Long id) {

        Estado estado = estadoExiste(id);

        if(estado == null) {
            throw new ObjetoNaoEncontradoExcepition("O estado de id " + id +
                    " não consta em nosso sistema.");
        }

        if (estado.getCidades().isEmpty()){
            repository.delete(estado);
        } else {
            throw  new ObjetoNaoPodeSerDeletadoException("O estado " + estado.getNome() +
                    " não pode ser excuido, pois há cidades vinculadas ao mesmo.");
        }

        return false;
    }

    @Override
    public boolean excluir(String nome) {
        Estado estado = estadoExiste(nome);
        if(estado != null){
            excluir(estado.getId());
        } else {
            excluir(-1L);
        }
        return false;
    }

    public Estado estadoExiste(String nome) {
        Optional<Estado> estado = repository.findByNome(nome);
        if (estado.isPresent()) {
            return estado.get();
        } else {
            return null;
        }
    }

    public Estado estadoExiste(Long id) {

        Optional<Estado> estado = repository.findById(id);
        if (estado.isPresent()) {
            return estado.get();
        } else {
            return null;
        }
    }
}