package com.projeto_final.PrevisaoDoTempo.unitarios;

import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoRequestDto;
import com.projeto_final.PrevisaoDoTempo.core.dto.estado.EstadoResponseDto;
import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;
import com.projeto_final.PrevisaoDoTempo.exception.ObjetoJaCadastradoExcepition;
import com.projeto_final.PrevisaoDoTempo.mapper.EstadoMapper;
import com.projeto_final.PrevisaoDoTempo.repositories.EstadoRepository;
import com.projeto_final.PrevisaoDoTempo.service.implementacoes.EstadoServiceImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EstadoTest {

    @InjectMocks
    private EstadoServiceImpl service;

    @Mock
    private EstadoRepository repository;

    @Mock
    private EstadoMapper mapper;


    @Mock
    private EstadoRequestDto estadoRequestDto;

    @Mock
    private EstadoResponseDto responseDto;

    @Mock
    private Estado estado;

    @Captor
    private ArgumentCaptor<Estado> estadoArgumentCaptor;


//    @BeforeEach
//    void setup() {
//        estadoRequestDto = EstadoFixture.estadoDto();
//        responseDto = EstadoFixture.estadoResponseDto();
//        estado = EstadoFixture.estadoEntidade();
//    }

    @Test
    @DisplayName("Deve lançar excessão de estado Já cadastrado")
    void deveLancarExcessaoAoTentarCriarEstadoJaExistente() {

        Estado estadoTeste = new Estado(1L,"Parana",null);
        EstadoRequestDto  requestDto = new EstadoRequestDto("Parana");

        when(repository.findByNome(requestDto.nome())).thenReturn(Optional.of(estadoTeste));

        System.out.println("Estado  = " + estadoTeste.getNome());
        System.out.println("Estado request  = " + requestDto.nome());

        Exception exception = assertThrows(ObjetoJaCadastradoExcepition.class, () ->
            service.criar(requestDto));

        assertEquals("Estado já cadastrado no sistema", exception.getMessage());
        assertThrows(ObjetoJaCadastradoExcepition.class,()-> service.criar(requestDto));

    }

    @Test
    void deveCriarEstadoComSucesso() {

        service.criar(estadoRequestDto);

        then(repository).should().save(estadoArgumentCaptor.capture());
        Estado estadoLocal = estadoArgumentCaptor.getValue();

        assertEquals(estadoLocal.getNome(),estadoRequestDto.nome());
        assertDoesNotThrow(()-> service.criar(estadoRequestDto));
    }

    @Test
    void deveRetornarUmResponseDtoAoCriarUmNovoEstado() {

        Estado estadoTeste = new Estado(1L,"Parana",null);
        EstadoRequestDto  requestDto = new EstadoRequestDto("Parana");
        EstadoResponseDto estadoResponseTesteDto = new EstadoResponseDto(1L,"Parana",null);

        when(repository.findByNome("Parana")).thenReturn(Optional.of(estadoTeste));
//        given(Estado.class.)
        given(mapper.estadoToResponseDto(estadoTeste)).willReturn(estadoResponseTesteDto);




        then(repository).should().save(estadoArgumentCaptor.capture());
        Estado estadoLocal = estadoArgumentCaptor.getValue();
        EstadoResponseDto resp = service.criar(estadoRequestDto);

        assertEquals(estadoLocal.getNome(), resp.nome());
        assertEquals(estadoLocal.getCidades(), resp.cidades());
        assertDoesNotThrow(()-> service.criar(estadoRequestDto));
    }



}