/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import java.util.Map;
import model.ComponenteCurso;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.ItemOferta;
import model.Oferta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neto
 */
public class MontarOfertaBeanTest {
    
    MontarOfertaBean bean;
    
    public MontarOfertaBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bean = new MontarOfertaBean();
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of montarOferta method, of class MontarOfertaBean.
     */
    @Test
    public void testMontarOferta() {
        
       
    }

//    /**
//     * Test of getComponentesBySemestreAndCurso method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetComponentesBySemestreAndCurso() {
//        System.out.println("getComponentesBySemestreAndCurso");
//        Short semestre = null;
//        boolean obrigatorio = false;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        List<ComponenteCurso> expResult = null;
//        List<ComponenteCurso> result = instance.getComponentesBySemestreAndCurso(semestre, obrigatorio);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addComponente method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testAddComponente() {
//        System.out.println("addComponente");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.addComponente();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addComponenteBySemestre method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testAddComponenteBySemestre() {
//        System.out.println("addComponenteBySemestre");
//        short semestre = 0;
//        boolean obrigatorio = false;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.addComponenteBySemestre(semestre, obrigatorio);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addTodosComponentes method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testAddTodosComponentes() {
//        System.out.println("addTodosComponentes");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.addTodosComponentes();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rmTodosComponentes method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testRmTodosComponentes() {
//        System.out.println("rmTodosComponentes");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.rmTodosComponentes();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rmComponente method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testRmComponente() {
//        System.out.println("rmComponente");
//        ComponenteCursoItemOferta ccio = null;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.rmComponente(ccio);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rmComponenteBySemestre method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testRmComponenteBySemestre() {
//        System.out.println("rmComponenteBySemestre");
//        short semestre = 0;
//        boolean obrigatoria = false;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.rmComponenteBySemestre(semestre, obrigatoria);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItemOferta method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetItemOferta() {
//        System.out.println("getItemOferta");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        ItemOferta expResult = null;
//        ItemOferta result = instance.getItemOferta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setItemOferta method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testSetItemOferta() {
//        System.out.println("setItemOferta");
//        ItemOferta itemOferta = null;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.setItemOferta(itemOferta);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOferta method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetOferta() {
//        System.out.println("getOferta");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        Oferta expResult = null;
//        Oferta result = instance.getOferta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setOferta method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testSetOferta() {
//        System.out.println("setOferta");
//        Oferta oferta = null;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.setOferta(oferta);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCurso method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetCurso() {
//        System.out.println("getCurso");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        Curso expResult = null;
//        Curso result = instance.getCurso();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCurso method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testSetCurso() {
//        System.out.println("setCurso");
//        Curso curso = null;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.setCurso(curso);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTabelasObrigatorias method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetTabelasObrigatorias() {
//        System.out.println("getTabelasObrigatorias");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        Map expResult = null;
//        Map result = instance.getTabelasObrigatorias();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTabelasComplementares method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetTabelasComplementares() {
//        System.out.println("getTabelasComplementares");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        Map expResult = null;
//        Map result = instance.getTabelasComplementares();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getComponenteCurso method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testGetComponenteCurso() {
//        System.out.println("getComponenteCurso");
//        MontarOfertaBean instance = new MontarOfertaBean();
//        ComponenteCurso expResult = null;
//        ComponenteCurso result = instance.getComponenteCurso();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setComponenteCurso method, of class MontarOfertaBean.
//     */
//    @Test
//    public void testSetComponenteCurso() {
//        System.out.println("setComponenteCurso");
//        ComponenteCurso componenteCurso = null;
//        MontarOfertaBean instance = new MontarOfertaBean();
//        instance.setComponenteCurso(componenteCurso);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
