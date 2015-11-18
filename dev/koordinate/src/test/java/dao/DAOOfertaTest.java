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
import javax.swing.JOptionPane;
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

    DAOOferta dao;
    Oferta oferta;

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
        dao = new DAOOferta();
        oferta = new Oferta();
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of salvar method, of class DAOOferta.
//     */
//    @Test
//    public void testSalvar() throws PeriodoLetivoException {
//        oferta.setAtivo(true);
//        oferta.setInicio(new Date(2015, 4, 4));
//        oferta.setTermino(new Date(2016, 5, 5));
//        dao.salvar(oferta);
//        assertEquals(oferta, dao.consultar(oferta.getId()));
//        
//    }
    /**
     * Test of getComponentesOfertados method, of class DAOOferta.
     */
    @Test
    public void testGetComponentesOfertados_3args() throws PeriodoLetivoException {

        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponentesNaoOfertados(curso, (short) 3, oferta);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);

    }

    /**
     * Test of getComponentesOfertados method, of class DAOOferta.
     */
    @Test
    public void testGetComponentesOfertados_4args() throws PeriodoLetivoException {
        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponentesNaoOfertados(curso, (short) 2, oferta, true);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }

    /**
     * Test of getDocenteItemOfertas method, of class DAOOferta.
     */
    @Test
    public void testGetDocenteItemOfertas() throws PeriodoLetivoException {
        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getDocenteItemOfertas(curso, oferta);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }

    /**
     * Test of getComponenteCursoItemOferta method, of class DAOOferta.
     */
    @Test
    public void testGetComponenteCursoItemOferta() throws PeriodoLetivoException {

        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponentesOfertados(curso, oferta, (short) 2);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }

    /**
     * Test of getComponenteCursoItemOfertaSemDocente method, of class
     * DAOOferta.
     */
    @Test
    public void testGetComponenteCursoItemOfertaSemDocente() throws PeriodoLetivoException {
        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponentesOfertados(curso, (short) 6, oferta, true);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }

    /**
     * Test of getComponentesNaoOfertados method, of class DAOOferta.
     */
    @Test
    public void testGetComponentesNaoOfertados_4args() throws PeriodoLetivoException {
        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponenteCursoItemOferta(curso, oferta);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }
//
    /**
     * Test of getComponentesNaoOfertados method, of class DAOOferta.
     */
    @Test
    public void testGetComponentesNaoOfertados_3args() throws PeriodoLetivoException {
        Curso curso = new Curso();
        curso.setCod("ALES");
        curso.setNome("Engenharia de Software");
        curso.setNumeroDeSemestres(8);
        Curso.salvar(curso);

        Oferta oferta = new Oferta();
        oferta.setInicio(new Date(2015, 05, 20));
        oferta.setTermino(new Date(2015, 05, 21));
        oferta.setPeriodoLetivo("2016/01");
        oferta.setAtivo(true);
        DAOOferta.salvar(oferta);

        dao.getComponenteCursoItemOfertaSemDocente(oferta);

        DAOOferta.excluir(oferta);
        Curso.excluir(curso);
    }
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
