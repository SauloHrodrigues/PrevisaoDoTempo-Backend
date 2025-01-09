package com.projeto_final.PrevisaoDoTempo.webservice;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoAtualizarDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @PostMapping()
    public ResponseEntity<EstadoResponseDto> registrar(@RequestBody EstadoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(requestDto));
    }

    @GetMapping()
    public ResponseEntity<List<EstadoResponseDto>> litaDeEstados(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar());
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<EstadoResponseDto> buscarEstadosPorNome(@RequestParam(required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> buscarEstadosId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EstadoResponseDto> atualizar(@PathVariable Long id, @RequestBody EstadoAtualizarDto estadoAtualizarDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, estadoAtualizarDto ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
    }

    @DeleteMapping()
    @ResponseBody
    public ResponseEntity deletar(@RequestParam(required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.excluir(nome));
    }
}