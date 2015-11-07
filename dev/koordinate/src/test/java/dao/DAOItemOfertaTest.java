package dao;

import excecoes.IntegridadeReferencialException;
import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import model.ComponenteCurricular;
import model.ComponenteCurso;
import model.ComponenteCursoItemOferta;
import model.Concurso;
import model.Curso;
import model.Docente;
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
 * @author Netoiung
 */
public class DAOItemOfertaTest {

    public DAOItemOfertaTest() {
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
    public void testSalvar() throws PeriodoLetivoException{
        //Oferta
        Oferta oferta = new Oferta();
        oferta.setAtivo(true);
        oferta.setInicio(new Date());
        oferta.setTermino(new Date());
        oferta.setPeriodoLetivo("1234/5");
        //Curso
        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        DAOCurso.salvar(c);
        //Componente Curricular
        ComponenteCurricular componente = new ComponenteCurricular();
        componente.setCargahoraria(100);
        componente.setCod("RPVI");
        componente.setCreditos(4);
        componente.setIsativo(true);
        componente.setLink("www.rpvi.com.br");
        componente.setNome("Resolução de Problemas VI");
        DAOComponenteCurricular.salvar(componente);
        //Componente Curso
        ComponenteCurso componenteCurso = new ComponenteCurso();
        componenteCurso.setComponenteCurricular(componente);
        componenteCurso.setCurso(c);
        componenteCurso.setSemestre(Short.parseShort("1"));
        componenteCurso.setObrigatoria(true);
        DAOComponenteCurso.salvar(componenteCurso);
        //Item Oferta
        ItemOferta itemOferta = new ItemOferta();
        itemOferta.setOferta(oferta);
        //ComponenteCurso Item Oferta
        ComponenteCursoItemOferta ccif = new ComponenteCursoItemOferta();
        ccif.setComponenteCurso(componenteCurso);
        ccif.setItemOferta(itemOferta);
        DAOOferta.salvar(oferta);
        //deve inserir os dois registros
        boolean test = DAOItemOferta.salvar(itemOferta);
        test = test && DAOItemOferta.salvar(ccif);
        assertTrue(test);
        //excluimos os registros do banco
        DAOItemOferta.excluir(ccif);
        DAOItemOferta.excluir(itemOferta);
        DAOOferta.excluir(oferta);
        DAOComponenteCurso.excluir(componenteCurso);
        DAOComponenteCurricular.excluir(componente);
        DAOCurso.excluir(c);
    }

}
