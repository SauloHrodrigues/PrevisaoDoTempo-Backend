package com.projeto_final.PrevisaoDoTempo.webservice;

import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.dado_meteorologico.DadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.service.DadoMeteorologicoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/dado_meteorologico")
public class DadoMeteorologicoController {

    @Autowired
    DadoMeteorologicoService service;

    @PostMapping()
    public ResponseEntity<DadoResponseDto> registrar(@RequestBody DadoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarDado(requestDto));
    }

    @GetMapping()
    public ResponseEntity<List<DadoResponseDto>> litaDeEstados(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarDados());
    }

    @PutMapping("{id}")
    public ResponseEntity<DadoResponseDto> atualizar(@PathVariable Long id, @RequestBody DadoAtualizarDto dadoAtualizarDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, dadoAtualizarDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}