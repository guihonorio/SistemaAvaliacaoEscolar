package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class AlunoTest {

    @Test
    void aluno_armazenaDados() {
        Aluno a = new Aluno("Maria", 8.0, 6.0, 90.0);
        assertEquals("Maria", a.getNome());
        assertEquals(8.0, a.getNota1());
        assertEquals(6.0, a.getNota2());
        assertEquals(90.0, a.getFrequencia());
    }

    @Test
    void aluno_getters() {
        Aluno a = new Aluno("João", 5.5, 7.5, 100.0);
        assertEquals("João", a.getNome());
        assertEquals(5.5, a.getNota1(), 0.0001);
        assertEquals(7.5, a.getNota2(), 0.0001);
        assertEquals(100.0, a.getFrequencia(), 0.0001);
    }
}