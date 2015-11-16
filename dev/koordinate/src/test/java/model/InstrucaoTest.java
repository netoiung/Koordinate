package model;

import excecoes.IntegridadeReferencialException;
import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
public class InstrucaoTest {

    public InstrucaoTest() {
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

//    /**
//     * Test of hashCode method, of class Instrucao.
//     * @throws excecoes.PeriodoLetivoException
//     */
//    @Test
//    public void testHashCode() throws PeriodoLetivoException {
//        Instrucao i = new Instrucao();
//        Oferta o = new Oferta();
//        o.setAtivo(true);
//        o.setPeriodoLetivo("2015/01");
//        o.setInicio(new Date(2015, 5, 10));
//        o.setTermino(new Date(2015, 10, 10));
//        Oferta.salvar(o);
//        i.setDescricao("2015/01");
//        i.setOferta(o);
//        Instrucao.salvar(i);
//        assertEquals(i.hashCode(), Instrucao.consultar(i.getId()).hashCode());
//        Instrucao.excluir(i);
//        Oferta.excluir(o);
////    }
    /**
     * Test of salvar method, of class Instrucao.
     */
    @Test
    public void testSalvar() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2025/01");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("20215/01");
        i.setOferta(o);
        assertTrue(Instrucao.salvar(i));
        Instrucao.excluir(i);
        Oferta.excluir(o);
    }

    /**
     * Test of consultarGeral method, of class Instrucao.
     */
    @Test
    public void testConsultarGeral() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2015/02");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("oferta de 2015/01");
        i.setOferta(o);
        Instrucao.salvar(i);
        assertEquals(i, Instrucao.consultarGeral().get(Instrucao.consultarGeral().size() - 1));
        Instrucao.excluir(i);
        Oferta.excluir(o);
    }

    /**
     * Test of consultarComp method, of class Instrucao.
     *
     * @throws excecoes.PeriodoLetivoException
     */
    @Test
    public void testConsultarComp() throws PeriodoLetivoException {

        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2030/01");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);

        ComponenteCurricular componente = new ComponenteCurricular();
        componente.setNome("Algoritmo");
        componente.setCargahoraria(10);
        componente.setLink("www.g.com");
        componente.setCod("codigo");
        ComponenteCurricular.salvar(componente);

        InstrucaoComponenteCurricular compo = new InstrucaoComponenteCurricular();
        compo.setComponenteCurricular(componente);

        Instrucao i = new Instrucao();
        i.setDescricao("Instrução 2030/01");
        i.setOferta(o);
        i.getInstrucaoComponenteCurriculars().add(compo);
        compo.setInstrucao(i);
        Instrucao.salvar(i);

        assertEquals(componente, Instrucao.consultarComp().get(Instrucao.consultarComp().size() - 1).getComponenteCurricular());

        ComponenteCurricular.excluir(componente);
        Instrucao.excluir(i);
        Oferta.excluir(o);

    }

    /**
     * Trste do método consultadoc
     */
    @Test
    public void testConsultarDoc() throws PeriodoLetivoException, IntegridadeReferencialException {

        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2029/01");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);

        Docente docente = new Docente();
        docente.setNome("Neto");
        docente.setSiape(111);
        docente.setLogin("login");
        docente.setSenha("senha");
        docente.setAreagraduacao("ES");
        docente.setEmailinstitucional("neto@neto.com");
        Docente.salvar(docente);

        InstrucaoDocente doc = new InstrucaoDocente();
        doc.setDocente(docente);

        Instrucao i = new Instrucao();
        i.setDescricao("Instrução 2030/01");
        i.setOferta(o);
        i.getInstrucaoDocentes().add(doc);
        doc.setInstrucao(i);
        Instrucao.salvar(i);

        assertEquals(docente, Instrucao.consultarDoc().get(Instrucao.consultarDoc().size() - 1).getDocente());

        Docente.excluir(docente);
        Instrucao.excluir(i);
        Oferta.excluir(o);

    }

    /**
     * Test of consultar method, of class Instrucao.
     *
     * @throws excecoes.PeriodoLetivoException
     */
    @Test
    public void testConsultar() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2022/02");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("oferta de 2015/01");
        i.setOferta(o);
        Instrucao.salvar(i);
        assertEquals(i, Instrucao.consultar(i.getId()));
        Instrucao.excluir(i);
        Oferta.excluir(o);
    }

    /**
     * Test of alterar method, of class Instrucao.
     *
     * @throws excecoes.PeriodoLetivoException
     */
    @Test
    public void testAlterar() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2017/01");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("oferta de 2015/01");
        i.setOferta(o);
        Instrucao.salvar(i);
        i.setDescricao("Mudou a instrução");
        assertTrue(Instrucao.alterar(i));
        assertEquals("Mudou a instrução", Instrucao.consultar(i.getId()).getDescricao());
        Instrucao.excluir(i);
        Oferta.excluir(o);
    }

    /**
     * Test of excluir method, of class Instrucao.
     *
     * @throws excecoes.PeriodoLetivoException
     */
    @Test
    public void testExcluir() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2020/02");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("2020/02");
        i.setOferta(o);
        Instrucao.salvar(i);
        assertTrue(Instrucao.excluir(i));
        Oferta.excluir(o);
    }

    /**
     * Test of excluirId method, of class Instrucao.
     *
     * @throws excecoes.PeriodoLetivoException
     */
    @Test
    public void testExcluirId() throws PeriodoLetivoException {
        Instrucao i = new Instrucao();
        Oferta o = new Oferta();
        o.setAtivo(true);
        o.setPeriodoLetivo("2019/01");
        o.setInicio(new Date(2015, 5, 10));
        o.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o);
        i.setDescricao("2019/01");
        i.setOferta(o);
        Instrucao.salvar(i);
        assertTrue(Instrucao.excluirId(i.getId()));
        Oferta.excluir(o);

    }
    /**
     * Teste do método count
     */
    @Test
    public void testCount() throws PeriodoLetivoException {
        Instrucao i1 = new Instrucao();
        Oferta o1 = new Oferta();
        o1.setAtivo(true);
        o1.setPeriodoLetivo("2019/01");
        o1.setInicio(new Date(2015, 5, 10));
        o1.setTermino(new Date(2015, 10, 10));
        Oferta.salvar(o1);
        i1.setDescricao("2019/01");
        i1.setOferta(o1);
        Instrucao.salvar(i1);

        assertEquals(1, Instrucao.count());

        Instrucao.excluir(i1);
        Oferta.excluir(o1);

    }

}
