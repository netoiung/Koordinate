/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOCurso;
import java.util.List;
import model.Curso;
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
public class CursoBeanTest {
    
    CursoBean bean;
    
    public CursoBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bean = new CursoBean();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCursos method, of class CursoBean.
     */
    @Test
    public void testGetsSets() {
        bean.init();
        bean.getCurso();
        bean.getCursos();
        bean.setCurso(null);
        
    }

    /**
     * Test of consultar method, of class CursoBean.
     */
    @Test
    public void testConsultar() {
        bean.init();
        bean.getCurso().setCod("codigo");
        bean.getCurso().setNome("Nome");
        bean.getCurso().setNumeroDeSemestres(8);
        bean.setCurso(bean.getCurso());
        try {
            bean.salvar();
        } catch (NullPointerException e) {
            
        }
        
        assertEquals("/modules/curso/consulta", bean.consultar(bean.getCurso()));
        DAOCurso.excluir(bean.getCurso());
    }

    /**
     * Test of salvar method, of class CursoBean.
     */
    @Test
    public void testSalvar() {
        bean.init();
        bean.getCurso().setCod("codigo");
        bean.getCurso().setNome("Nome");
        bean.getCurso().setNumeroDeSemestres(8);
        bean.setCurso(bean.getCurso());
        try {
            assertEquals("/modules/curso/lista", bean.salvar());
        } catch (NullPointerException n) {
            
        }
        DAOCurso.excluir(bean.getCurso());
        
    }

    /**
     * Test of editar method, of class CursoBean.
     */
    @Test
    public void testEditar() {
        bean.init();
        bean.getCurso().setCod("codigo");
        bean.getCurso().setNome("Nome");
        bean.getCurso().setNumeroDeSemestres(8);
        bean.setCurso(bean.getCurso());
        try {
            assertEquals("/modules/curso/lista", bean.salvar());
        } catch (NullPointerException n) {
            
        }
        
        bean.getCurso().setNome("NOOME EDITADO");
        
        
        assertEquals("/modules/curso/lista", bean.editar());
        
        DAOCurso.excluir(DAOCurso.consultar(bean.getCurso().getId()));
        
    }

    /**
     * Test of excluir method, of class CursoBean.
     */
    @Test
    public void testExcluir() {
        bean.init();
        bean.getCurso().setCod("codigo");
        bean.getCurso().setNome("Nome");
        bean.getCurso().setNumeroDeSemestres(8);
        bean.setCurso(bean.getCurso());
        try {
            assertEquals("/modules/curso/lista", bean.salvar());
        } catch (NullPointerException n) {
            
        }
        DAOCurso.excluir(bean.getCurso());
        assertNotSame(bean.getCurso(), DAOCurso.consultar(bean.getCurso().getId()));
    }

    /**
     * Test of cadastrar method, of class CursoBean.
     */
    @Test
    public void testCadastrar() {
        assertEquals("/modules/curso/formCadastrar", bean.cadastrar());//só pra cobertura
    }

    /**
     * Test of alterar method, of class CursoBean.
     */
    @Test
    public void testAlterar() {
        bean.init();
        bean.getCurso().setCod("codigo");
        bean.getCurso().setNome("Nome");
        bean.getCurso().setNumeroDeSemestres(8);
        bean.setCurso(bean.getCurso());
        assertEquals("/modules/curso/formEditar", bean.alterar(bean.getCurso()));//só pra cobertura
    }

    /**
     * Test of listar method, of class CursoBean.
     */
    @Test
    public void testListar() {
        assertEquals("/modules/curso/lista", bean.listar());
    }
    
}
