
package dao;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
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
public class DAODocenteTest {
    
    public DAODocenteTest() {
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
     * Test of existe method, of class DAODocente.
     */
    @Test
    public void testExiste() {
      //fazer//
    }

    /**
     * Teste do método salvar
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);

        boolean expResult = true;
        boolean result = DAODocente.salvar(d);
        assertEquals(expResult, result);
        DAODocente.excluir(d);
    }
    /**
     * Teste negativo do método salvar
     */
     @Test
    public void testSalvarNegativo() throws IntegridadeReferencialException {
        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome(null);//setamos o nome como nulo.
        d.setSiape(5432);

        boolean result = DAODocente.salvar(d);//tentamos salvar
        assertFalse(result);//deve ser falso.
        
    }
    
    

    /**
     * Test of consultar method, of class DAODocente.
     */
    @Test
    public void testConsultar_int() {
       //fazer//
    }

   

    /**
     * Test of consultar method, of class DAODocente.
     */
    @Test
    public void testConsultar_String() {
        //fazer//
    }

    /**
     * Test of alterar method, of class DAODocente.
     */
    @Test
    public void testAlterar() throws IntegridadeReferencialException {
        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Eduardo Amaral999");
        d.setSiape(5432);

        Docente.salvar(d);

        Docente expResult = d;
        Docente result = DAODocente.consultar(d.getId());
        assertEquals(expResult, result);

        d.setNome("Alterado!!!!");

        boolean test = DAODocente.alterar(d);
        assertTrue(test);
        DAODocente.excluir(d);
    }
    /**
     * Teste negativo do método alterar
     */
    @Test
    public void testAlterarNegativo() throws IntegridadeReferencialException {
        //REFAZER//
//        Docente d = new Docente();
//        d.setAreagraduacao("areaGraduação");
//        d.setAtuaposgraduacao(true);
//        d.setEmailinstitucional("1234@uni");
//        d.setLinklattes("lattes");
//        d.setLogin("login");
//        d.setSenha("pass");
//        d.setNome("Neto");
//        d.setSiape(5432);
//
//        DAODocente.salvar(d);
//
//        Docente expResult = d;
//        Docente result = DAODocente.consultar(d.getId());
//        assertEquals(expResult, result);
//
//        d.setNome(null);//setamos null no nome.
//
//        boolean test = DAODocente.alterar(d);//tentamos alterar.
//        assertFalse(test);//não deve alterar
//        DAODocente.excluir(d);
    }

    /**
     * Test of excluir method, of class DAODocente.
     */
    @Test
    public void testExcluir() throws Exception {
        
        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Eduardo Amaral999");
        d.setSiape(5432);

        DAODocente.salvar(d);

        boolean result = DAODocente.excluir(d);
        assertTrue(result);
    }

    
}
