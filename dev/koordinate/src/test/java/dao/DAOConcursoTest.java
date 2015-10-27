
package dao;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import model.Concurso;
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
public class DAOConcursoTest {
    
    public DAOConcursoTest() {
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
     * Test of salvar method, of class DAOConcurso.
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");

        boolean result = DAOConcurso.salvar(c);
        DAOConcurso.excluir(c);
        assertTrue(result);
    }

   

    /**
     * Test of consultar method, of class DAOConcurso.
     */
    @Test
    public void testConsultar_int() {
        System.out.println("consultar");
        int id = 0;
        Concurso expResult = null;
        Concurso result = DAOConcurso.consultar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarWithJoin method, of class DAOConcurso.
     */
    @Test
    public void testConsultarWithJoin_int() {
        System.out.println("consultarWithJoin");
        int id = 0;
        Concurso expResult = null;
        Concurso result = DAOConcurso.consultarWithJoin(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Concurso c = null;
        boolean expResult = false;
        boolean result = DAOConcurso.alterar(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class DAOConcurso.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Concurso d = null;
        boolean expResult = false;
        boolean result = DAOConcurso.excluir(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class DAOConcurso.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        int expResult = 0;
        int result = DAOConcurso.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
