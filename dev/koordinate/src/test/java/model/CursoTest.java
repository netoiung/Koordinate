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
public class CursoTest {

    /**
     * Teste do método salvar da classe Curso.
     */
    @Test
    public void testSalvar() {
        System.out.println("Testando método Salvar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        boolean result = Curso.salvar(c);
        assertTrue(result);

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Consultar da classe Curso.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("Testanto método Consultar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        int expResult = Curso.count();
        ArrayList<Curso> result = Curso.consultar();
        assertEquals(expResult, result.size());

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Consultar da classe Curso.
     */
    @Test
    public void testConsultarId() {
        System.out.println("Testando método Consultar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        Curso expResult = c;
        Curso result = Curso.consultar(c.getId());
        assertEquals(expResult, result);

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Alterar da classe Curso.
     */
    @Test
    public void testAlterar() {
        System.out.println("Testando método Alterar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        Curso expResult = c;
        Curso result = Curso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setNome("Sucesso- Editado");

        expResult = c;
        result = Curso.consultar(c.getId());

        assertNotSame(expResult, result);

        boolean test = Curso.alterar(c);
        assertTrue(test);
        
        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Excluir da classe Curso.
     */
    @Test
    public void testExcluir() {
        System.out.println("Testando método Excluir");
        
        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);
        
        boolean result = Curso.excluir(c);
        assertTrue(result);
    }

}