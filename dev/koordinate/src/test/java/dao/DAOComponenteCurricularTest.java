
package dao;

import java.util.ArrayList;
import model.ComponenteCurricular;
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
public class DAOComponenteCurricularTest {
    
    public DAOComponenteCurricularTest() {
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
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        Boolean resultado = DAOComponenteCurricular.salvar(c);
        assertTrue(resultado);
        DAOComponenteCurricular.excluir(c);
    }
    /**
     * Teste negativo do método salvar
     */
    @Test
    public void testSalvarNegativo() {
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome(null);//setamos null no nome.
        Boolean resultado = DAOComponenteCurricular.salvar(c);//tento salvar
        assertFalse(resultado);//não deve salvar
        
    }

    /**
     * Test of consultar method, of class DAOComponenteCurricular.
     */
//    @Test
//    public void testConsultar_int() {
//        System.out.println("consultar");
//        int id = 0;
//        ComponenteCurricular expResult = null;
//        ComponenteCurricular result = DAOComponenteCurricular.consultar(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    /**
     * Teste do método alterar
     */
    @Test
    public void testAlterar() {
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        c.setNome("Nome Normal");
        DAOComponenteCurricular.salvar(c);
        
        assertEquals(c, ComponenteCurricular.consultar(c.getId()));
        
        c.setNome("NOVO NOME");
        
        boolean resultado = DAOComponenteCurricular.alterar(c);//salvamos a alteração.
        assertTrue(resultado);
        
        DAOComponenteCurricular.excluir(c);

    }
    
    /**
     * Teste negativo do método alterar
     */
//      @Test
//    public void testAlterarNegativo() {
//        ComponenteCurricular c = new ComponenteCurricular();
//        c.setCargahoraria(100);
//        c.setCod("RPVI");
//        c.setCreditos(4);
//        c.setIsativo(true);
//        c.setLink("www.rpvi.com.br");
//        c.setNome("Resolução de Problemas VI");
//        c.setNome("ERRO");
//        DAOComponenteCurricular.salvar(c);
//        
//        assertEquals(c, ComponenteCurricular.consultar(c.getId()));
//        
//        c.setNome(null);//tentamos alterar para um valor nulo.
//        DAOComponenteCurricular.excluir(c);
//        boolean resultado = DAOComponenteCurricular.alterar(c);//tentamos salvar a alteração.
//        assertFalse(resultado);//não deve salvar.
//        
//    }
    

    /**
     * Teste do método excluir.
     */
    @Test
    public void testExcluir() {
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        c.setNome("Neto");
        DAOComponenteCurricular.salvar(c);
        boolean resultado = DAOComponenteCurricular.excluir(c);
        assertTrue(resultado);
        
    }
    
 
    
}
