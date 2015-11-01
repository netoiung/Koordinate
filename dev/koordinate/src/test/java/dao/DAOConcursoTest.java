
package dao;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import java.util.Set;
import model.Concurso;
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
     * Teste negativo do método salvar
     */
     @Test
    public void testSalvarNegativo() throws IntegridadeReferencialException {
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma(null);//setamos o nome como nulo.

        boolean result = DAOConcurso.salvar(c);
        assertFalse(result);
    }

   

    /**
     * Test of consultar method, of class DAOConcurso.
     */
    @Test
    public void testConsultar_int() throws IntegridadeReferencialException {
        
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        DAOConcurso.salvar(c);

        Concurso expResult = c;
        Concurso result = DAOConcurso.consultar(c.getId());
        DAOConcurso.excluir(c);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método alterar
     */
    @Test
    public void testAlterar() throws IntegridadeReferencialException {
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        DAOConcurso.salvar(c);

        Concurso expResult = c;
        Concurso result = DAOConcurso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setEdital("EDITADOOO");

        expResult = c;
        result = DAOConcurso.consultar(c.getId());
        assertNotSame(expResult, result);

        boolean test = DAOConcurso.alterar(c);
        DAOConcurso.excluir(c);
        assertTrue(test);
    }

    /**
     * Test of excluir method, of class DAOConcurso.
     */
    @Test
    public void testExcluir() throws Exception {
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        DAOConcurso.salvar(c);

        boolean result = DAOConcurso.excluir(c);
        assertTrue(result);
    }
    
     /**
     * Test of excluir method, of class DAOConcurso.
     */
    @Test(expected = Exception.class)
    public void testExcluir2() throws Exception {
        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        
        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        c.setDocentes((Set) d);
        DAOConcurso.salvar(c);

        DAOConcurso.excluir(c);
        
    }
    
}
