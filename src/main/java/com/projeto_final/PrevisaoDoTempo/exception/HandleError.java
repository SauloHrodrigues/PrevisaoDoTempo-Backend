package com.projeto_final.PrevisaoDoTempo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleError {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleErrorIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ObjetoJaCadastradoExcepition.class)
    public ResponseEntity<String> handleErrorEstadoJaCadastradoExcepition(ObjetoJaCadastradoExcepition mensagem) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem.getMessage());
    }

    @ExceptionHandler(ObjetoNaoEncontradoExcepition.class)
    public ResponseEntity<String> handlerErrorObjetoNaoEncontradoExcepition(ObjetoNaoEncontradoExcepition mensagem) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem.getMessage());
    }

    @ExceptionHandler(ObjetoNaoPodeSerDeletadoException.class)
    public ResponseEntity<String> handlerErrorObjetoNaoPodeSerDeletadoException(ObjetoNaoPodeSerDeletadoException mensagem) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mensagem.getMessage());
    }
}