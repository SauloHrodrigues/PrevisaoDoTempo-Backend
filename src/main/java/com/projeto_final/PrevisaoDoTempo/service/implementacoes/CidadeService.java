package com.projeto_final.PrevisaoDoTempo.service.implementacoes;

import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeAtualizadaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeNovaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeRequestDdo;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Cidade;
import com.projeto_final.PrevisaoDoTempo.core.entities.DadoMeteorologico;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoJaCadastradoExcepition;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoNaoEncontradoExcepition;
import com.projeto_final.PrevisaoDoTempo.mapper.CidadeMapper;
import com.projeto_final.PrevisaoDoTempo.repositories.CidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CidadeService implements com.projeto_final.PrevisaoDoTempo.service.CidadeService {

    @Autowired
    private final CidadeRepository repository;

    @Autowired
    private final EstadoService estadoService;

    private final CidadeMapper mapper = CidadeMapper.INSTANCE;

    @Override
    public CidadeResponseDto registrar(CidadeNovaDto requestDdo) {
        Cidade cidade = buscarCidadePorNome(requestDdo.nome());
        Estado estado = estadoService.estadoExiste(requestDdo.estado());

        if (cidade != null) {
            throw new ObjetoJaCadastradoExcepition("Cidade já cadastrada no sistema");
        }

        if (estado == null){
            throw new ObjetoNaoEncontradoExcepition("O estado " + requestDdo.estado() +
                    " não conta cadastrado no sistema.");
        }

        CidadeRequestDdo cidadeRequestDdo = new CidadeRequestDdo(requestDdo.nome(), estado, null);
        Cidade novaCidade = mapper.dtoToCidada(cidadeRequestDdo);
        repository.save(novaCidade);
        return mapper.cidadeToResponseDto(novaCidade);
    }

    @Override
    public List<CidadeResponseDto> buscar() {
        return mapper.cidadeListToResponnseDtoList(repository.findAll());
    }

    @Override
    public CidadeResponseDto buscar(Long id) {
        return mapper.cidadeToResponseDto(buscarCidadePorId(id));
    }

    @Override
    public CidadeResponseDto buscar(String nome) {
        System.out.println("entrou no busca por nome");
        return mapper.cidadeToResponseDto(buscarCidadePorNome(nome));
    }

    @Override
    public CidadeResponseDto alterar(Long id, CidadeAtualizadaDto cidadeAtualizadaDto) {

        Cidade cidade = buscarCidadePorId(id);
        mapper.updateCidadeFromCidadeResponseDto(cidade, cidadeAtualizadaDto);
        repository.save(cidade);

        return mapper.cidadeToResponseDto(cidade);
    }

    @Override
    public CidadeResponseDto alterar(String nome, CidadeAtualizadaDto cidadeAtualizadaDto) {

        Cidade cidade = buscarCidadePorNome(nome);
        mapper.updateCidadeFromCidadeResponseDto(cidade, cidadeAtualizadaDto);
        repository.save(cidade);

        return mapper.cidadeToResponseDto(cidade);
    }

    @Override
    public boolean excluir(Long id) {

        Cidade cidade = buscarCidadePorId(id);
        repository.delete(cidade);
        return true;
    }

    @Override
    public boolean excluir(String nome) {
        Cidade cidade = buscarCidadePorNome(nome);
        repository.delete(cidade);
        return true;
    }

    public Cidade buscarCidadePorId(Long id){

        Optional<Cidade> cidade = repository.findById(id);

        if(cidade.isPresent()){
            return cidade.get();
        }else {
            throw new ObjetoNaoEncontradoExcepition("A cidade de id: " + id +
                    " não consta cadastrada no sistema.");
        }
    }

    public Cidade buscarCidadePorNome(String nome){

        Optional<Cidade> cidade = repository.findByNome(nome);

        if(cidade.isPresent()){
            return cidade.get();
        }else {
            throw new ObjetoNaoEncontradoExcepition("A cidade de nome: " + nome +
                    " não consta cadastrada no sistema.");
        }
    }

    public void adicionarDadoNaCidade(Cidade cidade, DadoMeteorologico dado){
        cidade.getDadosMeteorologicos().add(dado);
        repository.save(cidade);
    }
}