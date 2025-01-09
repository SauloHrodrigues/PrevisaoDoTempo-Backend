package com.projeto_final.PrevisaoDoTempo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DadosMeteorologicosServiceOldTest {

//    @InjectMocks
//    DadosMeteorologicosServiceOld dadoService;
//    @Mock
//    CidadeRepository cidadeRepository;
//    @Mock
//    DadoMeteorologicoRepository dadoRepository;
//
//
//    @Test
//    @DisplayName("Deve cadastrar dados meteorologicos em determinada cidade com sucesso")
//    void testCadastrarDadoComSucesso() {
//        String cidade = "Campinas";
//        DadoMeteorologicoRequestDto dadoRequest = DadoMeteorologicoFixture.gerarDadoMeteorologicoRequestDto(cidade);
//        Cidade cidadeEntyt = CidadeFixture.gerarCidade(cidade);
//        DadoMeteorologico novoDado = DadoMeteorologicoFixture.gerarDadoMeteorologico(dadoRequest, cidadeEntyt);
//        when(cidadeRepository.findByNome(cidade)).thenReturn(Optional.of(cidadeEntyt));
//        when(dadoRepository.save(any(DadoMeteorologico.class))).thenReturn(novoDado);
//        dadoService.cadastrarDado(dadoRequest);
//
//        verify(cidadeRepository).findByNome(cidade);
//        verify(dadoRepository).save(any(DadoMeteorologico.class));
//    }
//
//
//    @Test
//    @DisplayName("Deve testar lançamendo de excessão quando a cidade não for encontrada")
//    void testCadastrarDadoSemSucesso_CidadeNaoEncontrada() {
//        String cidade = "Campinas";
//        DadoMeteorologicoRequestDto dadoRequest = DadoMeteorologicoFixture.gerarDadoMeteorologicoRequestDto(cidade);
//        when(cidadeRepository.findByNome(cidade)).thenReturn(Optional.empty());
//        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
//            dadoService.cadastrarDado(dadoRequest);
//        });
//        assertEquals("Cidade não encontrada após a verificação de existência.", exception.getMessage());
//        verify(cidadeRepository).findByNome(cidade);
//        verify(dadoRepository, never()).save(any(DadoMeteorologico.class));
//    }
//
//    @Test
//    @DisplayName("Deve deletar dado por id")
//    void deveDeletarDadoPorId() {
//        Long id = 1L;
//        DadoMeteorologico dado = DadoMeteorologicoFixture.gerarDadoMeteorologico();
//        when(dadoRepository.findById(id)).thenReturn(Optional.of(dado));
//        dadoService.deletarDadoPorId(id);
//        verify(dadoRepository).delete(dado);
//    }
//
//    @Test
//    @DisplayName("Deve alterar dados meteorologicos encontrados por id")
//    void deveAlterarDados() {
//        Long id = 1L;
//        DadoMeteorologico dado = DadoMeteorologicoFixture.gerarDadoMeteorologico();
//        DadoMeteorologicoRequestDto alteracoes = DadoMeteorologicoFixture.gerarDadoMeteorologicoRequestDto();
//        alteracoes.setClima(Clima.NUBLADO);
//        alteracoes.setTemperaturaMinima(13);
//        alteracoes.setPrecipitacao(126);
//        when(dadoRepository.findById(id)).thenReturn(Optional.of(dado));
//        dadoService.alterarDado(id,alteracoes);
//        verify(dadoRepository, times(1)).save(dado);
//        assertEquals(alteracoes.getClima(), dado.getClima());
//        assertEquals(alteracoes.getTemperaturaMinima(), dado.getTemperaturaMinima());
//        assertEquals(alteracoes.getPrecipitacao(), dado.getPrecipitacao());
//    }
}