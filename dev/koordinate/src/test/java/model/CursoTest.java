package model;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduardo, netoiung
 */
public class CursoTest {

    /**
     * Teste do método salvar da classe Curso.
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        System.out.println("Testando método Salvar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");
        Concurso.salvar(concurso);

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        Docente.salvar(d);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        boolean result = Curso.salvar(c);
        assertTrue(result);

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste negativo do método salvar
     */
    @Test
    public void testSalvarNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando método Salvar Negativo");

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome(null);

        boolean result = Curso.salvar(c);//nao deve salvar, pois o nome está setado como nulo.
        assertFalse(result);//deve ser falso.

    }

    /**
     * Teste do método Consultar da classe Curso.
     */
    @Test
    public void testConsultarTodos() throws IntegridadeReferencialException {
        System.out.println("Testanto método Consultar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");
        Concurso.salvar(concurso);

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        Docente.salvar(d);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        int expResult = Curso.count();
        ArrayList<Curso> result = Curso.consultar();
        assertEquals(expResult, result.size());

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Consultar da classe Curso.
     */
    @Test
    public void testConsultarId() throws IntegridadeReferencialException {
        System.out.println("Testando método Consultar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");
        Concurso.salvar(concurso);

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        Docente.salvar(d);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        Curso expResult = c;
        Curso result = Curso.consultar(c.getId());
        assertEquals(expResult, result);

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método consultarid negativo
     */
    @Test
    public void testConsultarIdNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando método Consultar Negativo");

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");

       // Curso.salvar(c);//não salvamos nada.
        Curso expResult = c;
        Curso result = Curso.consultar(c.getId());//não deve encontrar o objeto.
        assertNotSame(expResult, result);

    }

    /**
     * Teste do método Alterar da classe Curso.
     */
    @Test
    public void testAlterar() throws IntegridadeReferencialException {
        System.out.println("Testando método Alterar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");
        Concurso.salvar(concurso);

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        Docente.salvar(d);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        Curso expResult = c;
        Curso result = Curso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setNome("Sucesso- Editado");

        expResult = c;
        result = Curso.consultar(c.getId());

        assertNotSame(expResult, result);

        boolean test = Curso.alterar(c);
        assertTrue(test);

        Curso.excluir(c);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método alterar negativo
     */
    @Test
    public void testAlterarNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando método Alterar Negativo");

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");

        Curso.salvar(c);

        c.setNome(null);//setamos o campo nome como nulo.

        boolean test = Curso.alterar(c);
        assertFalse(test);//precisa ser falso, pois não deve alterar um registro com o nome setado em nulo.

        Curso.excluir(c);
    }

    /**
     * Teste do método Excluir da classe Curso.
     */
    @Test
    public void testExcluir() throws IntegridadeReferencialException {
        System.out.println("Testando método Excluir");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso2");
        concurso.setEdital("2105");
        concurso.setPrograma("adas");
        Concurso.salvar(concurso);

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setConcurso(concurso);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome("Nero");
        d.setSiape(5432);
        Docente.salvar(d);

        Curso c = new Curso();
        c.setCod("ALES");
        c.setNome("Engenharia de Software");
        c.setDocente(d);

        Curso.salvar(c);

        boolean result = Curso.excluir(c);
        assertTrue(result);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

}
