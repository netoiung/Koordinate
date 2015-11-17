/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ComponenteCurricular;
import model.ComponenteCurso;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.DocenteItemOferta;
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
public class DAOOfertaTest {

    public DAOOfertaTest() {
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
     * Test of salvar method, of class DAOOferta.
     */
    @Test
    public void testSalvar() throws PeriodoLetivoException {
        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2015/01");
        assertTrue(DAOOferta.salvar(oferta));
        DAOOferta.excluir(oferta);
    }

//    /**
//     * Test of getComponentesOfertados method, of class DAOOferta.
//     */
//    @Test
//    public void testGetComponentesOfertados_3args() throws PeriodoLetivoException {
//        
//
//        ComponenteCurricular componente = new ComponenteCurricular();
//        componente.setNome("Algebra");
//        componente.setCargahoraria(60);
//        componente.setCod("codigo");
//        componente.setLink("www.link.com");
//        ComponenteCurricular.salvar(componente);
//        
//        Curso curso = new Curso();
//        curso.setCod("ALES");
//        curso.setNome("Engenharia de Software");
//        curso.setNumeroDeSemestres(8);
//        Curso.salvar(curso);
//        
//        ComponenteCurso compcurso = new ComponenteCurso();
//        compcurso.setComponenteCurricular(componente);
//        compcurso.setCurso(curso);
//        curso.getComponenteCursos().add(compcurso);
//        
//        Oferta oferta = new Oferta();
//        oferta.setInicio(new Date(2015, 05, 20));
//        oferta.setTermino(new Date(2015, 05, 21));
//        oferta.setPeriodoLetivo("2016/01");
//        oferta.setAtivo(true);
//        DAOOferta.salvar(oferta);
// 
//        ComponenteCursoItemOferta componentecursoitemoferta = new ComponenteCursoItemOferta();
//        componentecursoitemoferta.setComponenteCurso(compcurso);
//        
//        ItemOferta itemoferta = new ItemOferta();
//        itemoferta.setOferta(oferta);
//        itemoferta.getComponenteCursoItemOfertas().add(componentecursoitemoferta);
//        componentecursoitemoferta.setItemOferta(itemoferta);
//        
//        
//        assertEquals(componente, DAOOferta.getComponenteCursoItemOferta(curso, oferta).size()-1);
//        ComponenteCurricular.excluir(componente);
//        Curso.excluir(curso);
//        DAOOferta.excluir(oferta);
//    }
//    /**
//     * Test of getComponentesOfertados method, of class DAOOferta.
//     */
//    @Test
//    public void testGetComponentesOfertados_4args() {
//        System.out.println("getComponentesOfertados");
//        Curso curso = null;
//        short semestre = 0;
//        Oferta oferta = null;
//        boolean obrigatoria = false;
//        DAOOferta instance = new DAOOferta();
//        List<ComponenteCursoItemOferta> expResult = null;
//        List<ComponenteCursoItemOferta> result = instance.getComponentesOfertados(curso, semestre, oferta, obrigatoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDocenteItemOfertas method, of class DAOOferta.
//     */
//    @Test
//    public void testGetDocenteItemOfertas() {
//        System.out.println("getDocenteItemOfertas");
//        Curso c = null;
//        Oferta o = null;
//        ArrayList<DocenteItemOferta> expResult = null;
//        ArrayList<DocenteItemOferta> result = DAOOferta.getDocenteItemOfertas(c, o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getComponenteCursoItemOferta method, of class DAOOferta.
//     */
//    @Test
//    public void testGetComponenteCursoItemOferta() {
//        System.out.println("getComponenteCursoItemOferta");
//        Curso c = null;
//        Oferta o = null;
//        ArrayList<ComponenteCursoItemOferta> expResult = null;
//        ArrayList<ComponenteCursoItemOferta> result = DAOOferta.getComponenteCursoItemOferta(c, o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getComponenteCursoItemOfertaSemDocente method, of class
//     * DAOOferta.
//     */
//    @Test
//    public void testGetComponenteCursoItemOfertaSemDocente() {
//        System.out.println("getComponenteCursoItemOfertaSemDocente");
//        Oferta o = null;
//        ArrayList<ComponenteCursoItemOferta> expResult = null;
//        ArrayList<ComponenteCursoItemOferta> result = DAOOferta.getComponenteCursoItemOfertaSemDocente(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getComponentesNaoOfertados method, of class DAOOferta.
//     */
//    @Test
//    public void testGetComponentesNaoOfertados_4args() {
//        System.out.println("getComponentesNaoOfertados");
//        Curso c = null;
//        short semestre = 0;
//        Oferta oferta = null;
//        boolean obrigatoria = false;
//        DAOOferta instance = new DAOOferta();
//        List<ComponenteCurso> expResult = null;
//        List<ComponenteCurso> result = instance.getComponentesNaoOfertados(c, semestre, oferta, obrigatoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getComponentesNaoOfertados method, of class DAOOferta.
//     */
//    @Test
//    public void testGetComponentesNaoOfertados_3args() {
//        System.out.println("getComponentesNaoOfertados");
//        Curso c = null;
//        short semestre = 0;
//        Oferta oferta = null;
//        DAOOferta instance = new DAOOferta();
//        List<ComponenteCurso> expResult = null;
//        List<ComponenteCurso> result = instance.getComponentesNaoOfertados(c, semestre, oferta);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscarComponenteCursoItemOferta method, of class DAOOferta.
//     */
//    @Test
//    public void testBuscarComponenteCursoItemOferta() {
//        System.out.println("buscarComponenteCursoItemOferta");
//        ArrayList<Oferta> expResult = null;
//        ArrayList<Oferta> result = DAOOferta.buscarComponenteCursoItemOferta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

