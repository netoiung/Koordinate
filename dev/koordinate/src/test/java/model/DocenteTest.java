
package model;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduardo, netoiung
 */
public class DocenteTest {

    /**
     * Teste do método Salvar da classe Docente.
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        System.out.println("Testando método Salvar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso244");
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

        boolean expResult = true;
        boolean result = Docente.salvar(d);
        assertEquals(expResult, result);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método salvar negativo
     */
    @Test
    public void testSalvarNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando método Salvar Negativo");

      

        Docente d = new Docente();
        d.setAreagraduacao("areaGraduação");
        d.setAtuaposgraduacao(true);
        d.setEmailinstitucional("1234@uni");
        d.setLinklattes("lattes");
        d.setLogin("login");
        d.setSenha("pass");
        d.setNome(null);
        d.setSiape(5432);

        boolean expResult = false;//porque nao deve salvar com nome nulo.
        boolean result = Docente.salvar(d);//tento salvar com o nome nulo.
        assertEquals(expResult, result);
    }
    /**
     * Teste do método Consultar da classe Docente.
     */
    @Test
    public void testConsultarTodos() throws IntegridadeReferencialException {
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

        int expResult = Docente.count();
        ArrayList<Docente> result = Docente.consultar();
        assertEquals(expResult, result.size());
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }

    /**
     * Teste do método Consultar da classe Docente.
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

        Docente expResult = d;
        Docente result = Docente.consultar(d.getId());
        assertEquals(expResult, result);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }
    /**
     * Teste do método consultarid negativo
     */
     @Test
    public void testConsultarIdNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando método Consultar Negativo");

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
        //apenas crio o objeto e nao salvo para tentar recuperar um objeto que nao foi salvo.
        Docente expResult = d;
        Docente result = Docente.consultar(d.getId());
        assertNotSame(expResult, result);//não deve ser o mesmo porque nenhum oobjeto foi salvo.
        Concurso.excluir(concurso);
    }
    /**
     * Teste do método Consultar da classe Docente.
     */
    @Test
    public void testConsultarPorNome() throws IntegridadeReferencialException {
        System.out.println("Testando método Consultar");

        Concurso concurso = new Concurso();
        concurso.setArea("Suceeeesso211");
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
        d.setNome("???????");
        d.setSiape(5432);

        Docente.salvar(d);
        Collection<Docente> result = Docente.consultar("Eduardo Amaral999");

        assertNotNull(result);

        Docente.excluir(d);
        Concurso.excluir(concurso);

    }

    /**
     * Teste do método Alterar da classe Docente.
     */
    @Test
    public void testAlterar() throws IntegridadeReferencialException {
        System.out.println("alterar");

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
        d.setNome("Eduardo Amaral999");
        d.setSiape(5432);

        Docente.salvar(d);

        Docente expResult = d;
        Docente result = Docente.consultar(d.getId());
        assertEquals(expResult, result);

        d.setNome("Alterado!!!!");

        boolean test = Docente.alterar(d);
        assertTrue(test);
        Docente.excluir(d);
        Concurso.excluir(concurso);
    }
    /**
     * Teste negativo do método alterar
     */
    @Test
    public void testAlterarNegativo() throws IntegridadeReferencialException {
        System.out.println("Teste negativo do método alterar");

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
        d.setNome("Eduardo Amaral999");
        d.setSiape(5432);

        Docente.salvar(d);

        d.setNome(null);//tento alterar para um valor nulo.

        boolean test = Docente.alterar(d);//tento salvar a alteração.
        assertFalse(test);//Deve ser falso porque nao deve salvar a alteração para um nome nulo.
        Docente.excluir(d);
        //Concurso.excluir(concurso);
    }
    
    /**
     * Test of excluir method, of class Docente.
     */
    @Test
    public void testExcluir() throws IntegridadeReferencialException {
        System.out.println("excluir");
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
        d.setNome("Eduardo Amaral999");
        d.setSiape(5432);

        Docente.salvar(d);

        boolean result = Docente.excluir(d);
        assertTrue(result);
        Concurso.excluir(concurso);
    }

}
