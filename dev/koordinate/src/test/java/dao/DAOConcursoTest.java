
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
        //fazer//
    }

    
    @Test
    public void testAlterar() {
      //fazer//
    }

    /**
     * Test of excluir method, of class DAOConcurso.
     */
    @Test
    public void testExcluir() throws Exception {
       //fazer//
    }

    
}
