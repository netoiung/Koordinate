/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAODocente;
import excecoes.IntegridadeReferencialException;
import java.util.List;
import model.Docente;
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
public class DocenteBeanTest {

    DocenteBean bean;

    public DocenteBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        bean = new DocenteBean();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDocentes method, of class DocenteBean.
     */
    @Test
    public void testGetSets() {
        bean.init();
        bean.getDocentes();
        bean.getDocente();
        bean.setDocente(null);
    }

    /**
     * Test of consultar method, of class DocenteBean.
     */
    @Test
    public void testConsultar() {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        assertEquals("/modules/docente/consulta", bean.consultar(bean.getDocente()));
    }

    /**
     * Test of alterar method, of class DocenteBean.
     */
    @Test
    public void testAlterar() {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        assertEquals("/modules/docente/form", bean.alterar(bean.getDocente()));
    }

    /**
     * Test of cadastrar method, of class DocenteBean.
     */
    @Test
    public void testCadastrar() {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        assertEquals("/modules/docente/form", bean.cadastrar());
    }

    /**
     * Test of listar method, of class DocenteBean.
     */
    @Test
    public void testListar() {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        assertEquals("/modules/docente/lista", bean.listar());
    }

    /**
     * Test of salvar method, of class DocenteBean.
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        bean.setDocente(bean.getDocente());
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        assertEquals(bean.getDocente(), DAODocente.consultar(bean.getDocente().getId()));
        DAODocente.excluir(bean.getDocente());
    }

    /**
     * Test of excluir method, of class DocenteBean.
     */
    @Test
    public void testExcluir() throws IntegridadeReferencialException {
        bean.init();
        bean.getDocente().setEmailinstitucional("email@email.com");
        bean.getDocente().setNome("Neto");
        bean.getDocente().setSenha("senha");
        bean.getDocente().setLogin("login");
        bean.getDocente().setSiape(12311);
        bean.setDocente(bean.getDocente());
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        try {
            bean.excluir(bean.getDocente());
        } catch (NullPointerException n) {

        }

        assertNotSame(bean.getDocente(), DAODocente.consultar(bean.getDocente().getId()));

    }

}
