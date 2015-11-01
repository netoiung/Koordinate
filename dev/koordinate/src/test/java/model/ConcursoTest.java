
package model;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduardo, netoiung
 */
public class ConcursoTest {

    /**
     * Teste do método Salvar da classe Concurso
     */
    @Test
    public void testSalvar() throws IntegridadeReferencialException {
        System.out.println("Testanto método Salvar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");

        boolean result = Concurso.salvar(c);
        Concurso.excluir(c);
        assertTrue(result);
    }
    
    /**
     * Teste negativo do método salvar
     */
    @Test
    public void testSalvarNegativo() throws IntegridadeReferencialException {
        System.out.println("Testanto método Salvar Negativo");

        Concurso c = new Concurso();
        c.setArea(null);//setamos o cmapo como nulo.
        c.setEdital("2014/02");
        c.setPrograma("seilá");

        boolean result = Concurso.salvar(c);//não deve salvar.
     //   Concurso.excluir(c);
        assertFalse(result);//deve ser falso.
        assertFalse(c.equals(Concurso.consultar(c.getId())));
    }

    /**
     * Teste do método Consultar da classe Concurso.
     */
    @Test
    public void testConsultarTodos() throws IntegridadeReferencialException {
        System.out.println("Testando método Consultar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        int expResult = Concurso.count();
        ArrayList<Concurso> a = Concurso.consultar();
        int result = a.size();
        Concurso.excluir(c);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método Consultar da classe Concurso
     */
    @Test
    public void testConsultarId() throws IntegridadeReferencialException {
        System.out.println("Testando método ConsultarId");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        Concurso expResult = c;
        Concurso result = Concurso.consultar(c.getId());
        Concurso.excluir(c);
        assertNotSame(expResult, result);
    }

    /**
     * Teste do método Alterar da classe Concurso
     */
    @Test
    public void testAlterar() throws IntegridadeReferencialException {
        System.out.println("Testando o método Alterar");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        Concurso expResult = c;
        Concurso result = Concurso.consultar(c.getId());
        assertEquals(expResult, result);

        c.setEdital("Editado - Sucesso");

        expResult = c;
        result = Concurso.consultar(c.getId());
        assertNotSame(expResult, result);

        boolean test = Concurso.alterar(c);
        Concurso.excluir(c);
        assertTrue(test);
    }
    
    /**
     * Teste do método alterar negativo
     */
     @Test
    public void testAlterarNegativo() throws IntegridadeReferencialException {
        System.out.println("Testando o método Alterar Negativo");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        c.setEdital(null);//setamos nulo no campo.

        boolean test = Concurso.alterar(c);//Alteramos o valor
        Concurso.excluir(c);
        assertFalse(test);//deve ser falso
    }

    /**
     * Teste do método excluir da classe Concurso.
     */
    @Test
    public void testExcluir() throws IntegridadeReferencialException {
        System.out.println("Testando método Excluir");

        Concurso c = new Concurso();
        c.setArea("Processamento Paralelo");
        c.setEdital("2014/02");
        c.setPrograma("seilá");
        Concurso.salvar(c);

        boolean result = Concurso.excluir(c);
        assertTrue(result);
    }
    
    /**
     * Teste do método exluir negativo
//     */
//    @Test
//    public void testExcluirNegativo() throws IntegridadeReferencialException {
//        System.out.println("Testando método Excluir Negativo");
//
//        Concurso c = new Concurso();
////        c.setArea("Processamento Paralelo");
////        c.setEdital("2014/02");
////        c.setPrograma("seilá");
////      //  Concurso.salvar(c);
//
//        boolean result = Concurso.excluir(c);
//        Concurso.excluir(c);
//        assertTrue(result);
//    }

}
