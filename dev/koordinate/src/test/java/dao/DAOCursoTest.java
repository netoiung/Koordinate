package dao;

import java.util.ArrayList;
import model.Concurso;
import model.Curso;
import model.Docente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Netoiung
 */
public class DAOCursoTest {

    public DAOCursoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Teste do método salvar
     */
    @Test
    public void testSalvar() {

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");

        boolean result = DAOCurso.salvar(c);
        assertTrue(result);

        DAOCurso.excluir(c);
    }

    /**
     * Teste negativo do método salvar
     */
    @Test
    public void testSalvarNegativo() {
        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome(null);

        boolean result = DAOCurso.salvar(c);//nao deve salvar, pois o nome está setado como nulo.
        assertFalse(result);//deve ser falso.
    }

    /**
     * // * Teste do método consultar //
     */
//    @Test
//    public void testConsultar_int() {
//        System.out.println("consultar");
//        int id = 0;
//        Curso expResult = null;
//        Curso result = DAOCurso.consultar(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of alterar method, of class DAOCurso.
     */
    @Test
    public void testAlterar() {
        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");

        Curso.salvar(c);

        Curso expResult = c;
        Curso result = DAOCurso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setNome("EDITADO");

        expResult = c;
        result = DAOCurso.consultar(c.getId());
        assertNotSame(expResult, result);

        boolean test = DAOCurso.alterar(c);
        assertTrue(test);

        DAOCurso.excluir(c);
    }

    /**
     * Teste negativo do método alterar
     */
//    @Test
//    public void testAlterarNegativo() {
//        Curso c = new Curso();
//        c.setCod("ALEE");
//        c.setNome("Engenharia Elétrica");
//
//        Curso.salvar(c);
//
//        Curso expResult = c;
//        Curso result = DAOCurso.consultar(c.getId());
//        assertEquals(expResult, result);
//
//        c.setNome(null);
//
//        expResult = c;
//        result = DAOCurso.consultar(c.getId());
//        assertNotSame(expResult, result);
//        
//        boolean test = DAOCurso.alterar(c);
//        assertFalse(test);
//        
//        DAOCurso.excluir(c);
//
//    }

    /**
     * Test of excluir method, of class DAOCurso.
     */
    @Test
    public void testExcluir() {
        Curso c = new Curso();
        c.setCod("ALEC");
        c.setNome("Engenharia Civil");

        DAOCurso.salvar(c);

        boolean result = DAOCurso.excluir(c);
        assertTrue(result);
    }

}
