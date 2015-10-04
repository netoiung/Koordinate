/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduar
 */
public class ConcursoTest {

    /**
     * Teste do método Salvar da classe Concurso
     */
    @Test
    public void testSalvar() {
        System.out.println("Testanto método Salvar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");

        boolean result = Concurso.salvar(c);
        Concurso.excluir(c);
        assertTrue(result);
    }

    /**
     * Teste do método Consultar da classe Concurso.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("Testando método Consultar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        int expResult = Concurso.count();
        ArrayList<Concurso> a = Concurso.consultar();
        int result = a.size();
        Concurso.excluir(c);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método Consultar da classe Concurso
     */
    @Test
    public void testConsultarId() {
        System.out.println("Testando método ConsultarId");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        Concurso expResult = c;
        Concurso result = Concurso.consultar(c.getId());
        Concurso.excluir(c);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método Alterar da classe Concurso
     */
    @Test
    public void testAlterar() {
        System.out.println("Testando o método Alterar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        Concurso expResult = c;
        Concurso result = Concurso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setEdital("Editado - Sucesso");

        expResult = c;
        result = Concurso.consultar(c.getId());
        assertNotSame(expResult, result);

        boolean test = Concurso.alterar(c);
        Concurso.excluir(c);
        assertTrue(test);
    }

    /**
     * Teste do método excluir da classe Concurso.
     */
    @Test
    public void testExcluir() {
        System.out.println("Testando método Excluir");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        boolean result = Concurso.excluir(c);
        Concurso.excluir(c);
        assertTrue(result);
    }

}
