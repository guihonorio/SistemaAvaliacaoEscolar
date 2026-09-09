package service;

import model.Aluno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class SistemaAvaliacaoTest {

    private SistemaAvaliacao sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaAvaliacao();
    }

    @Test
    void sistema_iniciaVazio() {
        assertEquals(0, sistema.quantidadeAlunos());
        assertTrue(sistema.listarAlunos().isEmpty());
    }

    @Test
    void adicionarAluno_incrementaQuantidade() {
        sistema.adicionarAluno(new Aluno("Ana", 8, 9, 90));
        assertEquals(1, sistema.quantidadeAlunos());
    }

    @Test
    void listarAlunos_retornaAlunos() {
        Aluno a = new Aluno("Pedro", 6, 6, 80);
        sistema.adicionarAluno(a);
        assertEquals(1, sistema.listarAlunos().size());
        assertSame(a, sistema.listarAlunos().get(0));
    }

    @Test
    void adicionarAluno_multiplos() {
        sistema.adicionarAluno(new Aluno("A", 1, 1, 1));
        sistema.adicionarAluno(new Aluno("B", 2, 2, 2));
        sistema.adicionarAluno(new Aluno("C", 3, 3, 3));
        assertEquals(3, sistema.quantidadeAlunos());
    }
}