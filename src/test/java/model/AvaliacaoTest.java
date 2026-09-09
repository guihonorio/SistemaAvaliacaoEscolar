package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class AvaliacaoTest {

    private final Avaliacao avaliacao = new Avaliacao();

    // Nota
    @Test
    void validarNota_aceitaZero() {
        assertTrue(avaliacao.validarNota(0));
    }

    @Test
    void validarNota_aceitaDez() {
        assertTrue(avaliacao.validarNota(10));
    }

    @Test
    void validarNota_rejeitaNegativa() {
        assertFalse(avaliacao.validarNota(-0.01));
    }

    @Test
    void validarNota_rejeitaAcimaDeDez() {
        assertFalse(avaliacao.validarNota(10.01));
    }

    // Frequencia
    @Test
    void validarFrequencia_aceitaZero() {
        assertTrue(avaliacao.validarFrequencia(0));
    }

    @Test
    @DisplayName("Frequência 100 é válida")
    void validarFrequencia_aceitaCem() {
        assertTrue(avaliacao.validarFrequencia(100));
    }

    @Test
    void validarFrequencia_rejeitaNegativa() {
        assertFalse(avaliacao.validarFrequencia(-1));
    }

    @Test
    void validarFrequencia_rejeitaAcimaDeCem() {
        assertFalse(avaliacao.validarFrequencia(101));
    }

    // Calcular Media
    @Test
    void calcularMedia_mediaSimples() {
        assertEquals(7.0, avaliacao.calcularMedia(8, 6), 0.0001);
    }

    @Test
    void calcularMedia_doisExtremos() {
        assertEquals(5.0, avaliacao.calcularMedia(10, 0), 0.0001);
    }

    // Se tem frequencia minima 
    @Test
    void possuiFrequenciaMinima_limiteExato() {
        assertTrue(avaliacao.possuiFrequenciaMinima(75));
    }

    @Test
    void possuiFrequenciaMinima_abaixoDoLimite() {
        assertFalse(avaliacao.possuiFrequenciaMinima(74.9));
    }

    // Verificar situacao
    @Test
    void verificarSituacao_reprovadoPorFrequencia() {
        assertEquals("REPROVADO POR FREQUÊNCIA",
                avaliacao.verificarSituacao(10, 74.9));
    }

    @Test
    void verificarSituacao_aprovado() {
        assertEquals("APROVADO",
                avaliacao.verificarSituacao(7, 75));
    }

    @Test
    void verificarSituacao_recuperacao() {
        assertEquals("RECUPERAÇÃO",
                avaliacao.verificarSituacao(6.9, 80));
    }

    @Test
    void verificarSituacao_reprovado() {
        assertEquals("REPROVADO",
                avaliacao.verificarSituacao(4.9, 80));
    }

    @Test
    void verificarSituacao_recuperacaoLimite() {
        assertEquals("RECUPERAÇÃO",
                avaliacao.verificarSituacao(5, 75));
    }
}