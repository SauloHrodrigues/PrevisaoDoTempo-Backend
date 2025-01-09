package com.projeto_final.PrevisaoDoTempo.webservice;

import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeAtualizadaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeNovaDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.cidade.CidadeResponseDto;
import com.projeto_final.PrevisaoDoTempo.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    @PostMapping()
    public ResponseEntity<CidadeResponseDto> cadastra(@RequestBody CidadeNovaDto cidadeRequestDdo){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.registrar(cidadeRequestDdo));
    }

    @GetMapping()
    public ResponseEntity<List<CidadeResponseDto>> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscar());
    }

    @GetMapping("/nome")
    @ResponseBody
    public ResponseEntity<CidadeResponseDto> buscar(@RequestParam(required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscar(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponseDto> buscar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeResponseDto> atualizar(@PathVariable Long id, @RequestBody CidadeAtualizadaDto cidadeAtualizadaDto){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.alterar(id, cidadeAtualizadaDto));
    }

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<CidadeResponseDto> atualizar(@RequestParam(required = false) String nome, @RequestBody CidadeAtualizadaDto cidadeAtualizadaDto){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.alterar(nome, cidadeAtualizadaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.excluir(id));
    }

    @DeleteMapping("/")
    @ResponseBody
    public ResponseEntity deletar(@RequestParam(required = false) String nome){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.excluir(nome));
    }
}