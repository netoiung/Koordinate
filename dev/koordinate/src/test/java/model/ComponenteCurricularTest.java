/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduar
 */
public class ComponenteCurricularTest {

    /**
     * Teste do método salvar da classe ComponenteCurricular.
     */
    @Test
    public void testSalvar() {
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
