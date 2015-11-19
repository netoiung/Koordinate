/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOOferta;
import java.util.ArrayList;
import java.util.Date;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.DocenteItemOferta;
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
public class OfertaBeanTest {

    OfertaBean bean;

    public OfertaBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        bean = new OfertaBean();
    }

    @After
    public void tearDown() {
    }

    /**
     * Teste de gets e sets
     */
    @Test
    public void tesGetsSets() {

    }

    /**
     * Test of consultar method, of class OfertaBean.
     */
    @Test
    public void testConsultar() {
        bean.init();
        bean.getOferta().setAtivo(true);
        bean.getOferta().setInicio(new Date(2015, 5, 5));
        bean.getOferta().setTermino(new Date(2015, 6, 6));
        bean.getOferta().setPeriodoLetivo("2020/01");
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }
        assertEquals("/modules/oferta/monitorarOferta", bean.consultar(bean.getOferta()));
        DAOOferta.excluir(DAOOferta.consultar(bean.getOferta().getId()));
    }

    /**
     * Test of excluir method, of class OfertaBean.
     */
    @Test
    public void testExcluir() {
        bean.init();
        bean.getOferta().setAtivo(true);
        bean.getOferta().setInicio(new Date(2015, 5, 5));
        bean.getOferta().setTermino(new Date(2015, 6, 6));
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        try {
            bean.excluir(bean.getOferta());
        } catch (NullPointerException n) {

        }
        assertNotSame(bean.getOferta(), DAOOferta.consultar(bean.getOferta().getId()));
    }

    /**
     * Test of salvar method, of class OfertaBean.
     */
    @Test
    public void testSalvar() {
        bean.init();
        bean.getOferta().setAtivo(true);
        bean.getOferta().setInicio(new Date(2015, 5, 5));
        bean.getOferta().setTermino(new Date(2015, 6, 6));
        bean.getOferta().setPeriodoLetivo("2015/01");
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }
        assertEquals(bean.getOferta(), DAOOferta.consultar(bean.getOferta().getId()));

        DAOOferta.excluir(DAOOferta.consultar(bean.getOferta().getId()));
    }

    /**
     * Test of alterar method, of class OfertaBean.
     */
    @Test
    public void testAlterar() {
        bean.init();
        bean.getOferta().setAtivo(true);
        bean.getOferta().setInicio(new Date(2015, 5, 5));
        bean.getOferta().setTermino(new Date(2015, 6, 6));
        assertEquals("/modules/oferta/form", bean.alterar(bean.getOferta()));
    }

    /**
     * Test of cadastrar method, of class OfertaBean.
     */
    @Test
    public void testCadastrar() {
        assertEquals("/modules/oferta/form", bean.cadastrar());
    }

    /**
     * Test of listar method, of class OfertaBean.
     */
    @Test
    public void testListar() {
        assertEquals("/modules/oferta/lista", bean.listar());
    }

    /**
     * Test of addInstrucao method, of class OfertaBean.
     */
    @Test
    public void testAddInstrucao() {
        assertEquals("/modules/oferta/addInstrucoes", bean.addInstrucao());
    }

    /**
     * Test of retornaCreditosDocenteItemOfertas method, of class OfertaBean.
     */
    @Test
    public void testRetornaCreditosDocenteItemOfertas() {

    }

    /**
     * Test of retornaDocenteItemOfertas method, of class OfertaBean.
     */
    @Test
    public void testRetornaDocenteItemOfertas() {

    }

    /**
     * Test of finalizarOferta method, of class OfertaBean.
     */
    @Test
    public void testFinalizarOferta() {
        try {
            assertEquals("index", bean.finalizarOferta());
        } catch (NullPointerException e) {

        }
    }

}
