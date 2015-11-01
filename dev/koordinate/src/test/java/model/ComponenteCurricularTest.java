package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduardo, netoiung
 */
public class ComponenteCurricularTest {

    /**
     * Teste do método salvar da classe ComponenteCurricular.
     */
    @Test
    public void testSalvarPositivo() {
        System.out.println("Testando método Salvar");
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");

        boolean expResult = true;
        boolean result = ComponenteCurricular.salvar(c);
        ComponenteCurricular.excluir(c);
        assertEquals(expResult, result);
    }

    /**
     * Teste negativo do método Salvar
     */
    @Test
    public void testSalvarNegativo() {
        System.out.println("Testando método Salvar Negativo");
        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome(null);//nome nulo

        boolean expResult = false;//falso porque não deve salvar se o nome estiver nulo.
        boolean result = ComponenteCurricular.salvar(c);
        assertEquals(expResult, result);
        assertFalse(c.equals(ComponenteCurricular.consultar(c.getId())));
    }

    /**
     * Teste do método Consultar da classe Componente Curricular
     */
    @Test
    public void testConsultar() {
        System.out.println("Testando método Consultar");

        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");

        int expResult = ComponenteCurricular.count();

        ArrayList<ComponenteCurricular> r = ComponenteCurricular.consultar();
        int result = r.size();

        ComponenteCurricular.excluir(c);

        assertEquals(expResult, result);
    }

    /**
     * Teste Consultar da classe ComponenteCurricular
     */
    @Test
    public void testConsultar_int() {
        System.out.println("Testando método Consultar");

        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        ComponenteCurricular.salvar(c);

        ComponenteCurricular expResult = c;
        ComponenteCurricular result = ComponenteCurricular.consultar(c.getId());

        ComponenteCurricular.excluir(c);

        assertEquals(expResult, result);
    }

    /**
     * Teste Negativo do método consultar_int
     */
    @Test
    public void testConsultar_intNegativo() {
        System.out.println("Testando método Consultar Negativo");

        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        // ComponenteCurricular.salvar(c);//não salva.

        ComponenteCurricular expResult = c;
        ComponenteCurricular result = ComponenteCurricular.consultar(c.getId());//procura objeto que não salvou

        assertFalse(expResult == result);//compara o objeto criado com o que retorna do BD

    }

    /**
     * Teste Alterar da classe ComponenteCurricular
     */
    @Test
    public void testAlterar() {
        System.out.println("Testando método Alterar");

        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        ComponenteCurricular.salvar(c);

        ComponenteCurricular expResult = c;
        ComponenteCurricular result = ComponenteCurricular.consultar(c.getId());

        assertEquals(expResult, result);

        c.setNome("Modificado-Sucesso");

        expResult = c;
        result = ComponenteCurricular.consultar(c.getId());

        assertNotSame(expResult, result);

        boolean test = ComponenteCurricular.alterar(c);

        ComponenteCurricular.excluir(c);

        assertTrue(test);
    }

    /**
     * Teste do método Excluir da classe ComponenteCurricular
     */
    @Test
    public void testExcluir() {
        System.out.println("Testando método excluir");

        ComponenteCurricular c = new ComponenteCurricular();
        c.setCargahoraria(100);
        c.setCod("RPVI");
        c.setCreditos(4);
        c.setIsativo(true);
        c.setLink("www.rpvi.com.br");
        c.setNome("Resolução de Problemas VI");
        ComponenteCurricular.salvar(c);

        boolean result = ComponenteCurricular.excluir(c);
        assertTrue(result);
    }


}
