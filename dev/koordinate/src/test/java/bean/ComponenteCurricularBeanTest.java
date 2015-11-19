/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOComponenteCurricular;
import java.util.List;
import model.ComponenteCurricular;
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
public class ComponenteCurricularBeanTest {

    ComponenteCurricularBean bean;
    //  ComponenteCurricular componente;

    public ComponenteCurricularBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        bean = new ComponenteCurricularBean();
//        componente = new ComponenteCurricular();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of consultar method, of class ComponenteCurricularBean.
     */
    @Test
    public void testConsultar() {
        bean.init();
        bean.getComponente().setCod("Cod");
        bean.getComponente().setLink("www.link.com");
        bean.getComponente().setNome("Algebra");
        bean.setComponente(bean.getComponente());

        
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        assertEquals("/modules/componenteCurricular/consulta", bean.consultar(bean.getComponente()));
        DAOComponenteCurricular.excluir(bean.getComponente());
    }
//
//    /**
//     * Test of excluir method, of class ComponenteCurricularBean.
//     */
    @Test
    public void testExcluir() {
        bean.init();
        
        bean.getComponente().setCod("Cod");
        bean.getComponente().setLink("www.link.com");
        bean.getComponente().setNome("Algebra");
        bean.setComponente(bean.getComponente());
        
        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        assertEquals(bean.getComponente(), DAOComponenteCurricular.consultar(bean.getComponente().getId()));
        try {
            bean.excluir(bean.getComponente());
        } catch (NullPointerException n) {
        }

        assertNotSame(bean.getComponente(), DAOComponenteCurricular.consultar(bean.getComponente().getId()));
    }
//
//    /**
//     * Test of salvar method, of class ComponenteCurricularBean.
//     */
    @Test
    public void testSalvar() {
        bean.init();
        
        bean.getComponente().setCod("Cod");
        bean.getComponente().setLink("www.link.com");
        bean.getComponente().setNome("Algebra");
        bean.getComponente().setCreditos(8);
        bean.setComponente(bean.getComponente());

        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        assertEquals(bean.getComponente(), DAOComponenteCurricular.consultar(bean.getComponente().getId()));
        DAOComponenteCurricular.excluir(bean.getComponente());

    }

//    /**
//     * Test of alterar method, of class ComponenteCurricularBean.
//     */
//    @Test
//    public void testAlterar() {
//        ComponenteCurricular componente = new ComponenteCurricular();
//        
//        bean.setComponente(componente);
//        bean.getComponente().setCod("Cod");
//        bean.getComponente().setLink("www.link.com");
//        bean.getComponente().setNome("Algebra");
//        
//        try{
//        bean.salvar();
//        } catch (NullPointerException e) {
//            
//        }
//        
//        assertEquals(componente, DAOComponenteCurricular.consultar(componente.getId()));
//
//                
//        bean.getComponente().setNome("EDITADOOOOOO");
//        bean.getComponente().setCod("CODIGO ATUALIIZADO");
//        bean.getComponente().setLink("WWW.LINKNOVO.COM");
//        
//        bean.alterar(bean.getComponente());
//        
//        assertEquals(componente.getNome(), DAOComponenteCurricular.consultar(componente.getId()).getNome());
//        assertEquals(componente.getCod(), DAOComponenteCurricular.consultar(componente.getId()).getCod());
//        assertEquals(componente.getLink(), DAOComponenteCurricular.consultar(componente.getId()).getLink());
//        
//        DAOComponenteCurricular.excluir(componente);
//    }
//
    /**
     * Test of consultarById method, of class ComponenteCurricularBean.
     */
    @Test
    public void testConsultarById() {
        bean.init();
        bean.getComponente().setCod("Codigo");
        bean.getComponente().setLink("www.link2.com");
        bean.getComponente().setNome("Algoritmos");
        bean.setComponente(bean.getComponente());

        try {
            bean.salvar();
        } catch (NullPointerException e) {

        }

        assertEquals("/modules/componenteCurricular/form", bean.consultarById(bean.getComponente().getId()));
        DAOComponenteCurricular.excluir(bean.getComponente());
    }

//    /**
//     * Test of cadastrar method, of class ComponenteCurricularBean.
//     */
    @Test
    public void testCadastrar() {
        ComponenteCurricular componente = new ComponenteCurricular();

        bean.setComponente(componente);
        bean.getComponente().setCod("Codigo");
        bean.getComponente().setLink("www.link2.com");
        bean.getComponente().setNome("Algoritmos");

        try {
            bean.cadastrar();
        } catch (NullPointerException e) {

        }

        assertEquals("/modules/componenteCurricular/formCadastrar", bean.cadastrar());
        //DAOComponenteCurricular.excluir(componente);
    }

    /**
     * Test of listar method, of class ComponenteCurricularBean.
     */
    @Test
    public void testListar() {

        assertEquals("/modules/componenteCurricular/lista", bean.listar());
    }
}
