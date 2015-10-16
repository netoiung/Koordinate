/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduar
 */
public class OfertaTest {

    /**
     * Test of salvar method, of class Oferta.
     */
    @Test
    public void testSalvar() {
        System.out.println("Testanto método Salvar");

        //<editor-fold defaultstate="collapsed" desc="criar obj oferta">
        Oferta oferta = new Oferta();
        oferta.setInicio(new java.sql.Date(2015, 10, 17));
        oferta.setTermino(new java.sql.Date(2016, 4, 17));
        oferta.setAtivo(false);
//</editor-fold>

        boolean expResult = true;
        boolean result = Oferta.salvar(oferta);
        assertEquals(expResult, result);

        //<editor-fold defaultstate="collapsed" desc="excluir oferta">
        Oferta.excluir(oferta);
//</editor-fold>
    }

    /**
     * Test of consultar method, of class Oferta.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("Testando método Consultar que retorna todos os registros");

        //<editor-fold defaultstate="collapsed" desc="criar obj oferta">
        Oferta oferta = new Oferta();
        oferta.setInicio(new java.sql.Date(2015, 10, 17));
        oferta.setTermino(new java.sql.Date(2016, 4, 17));
        oferta.setAtivo(false);
        Oferta.salvar(oferta);
        //</editor-fold>

        int expResult = Oferta.count();
        int result = Oferta.consultar().size();
        assertEquals(expResult, result);

        //<editor-fold defaultstate="collapsed" desc="excluir oferta">
        Oferta.excluir(oferta);
//</editor-fold>
    }

    /**
     * Test of consultar method, of class Oferta.
     */
    @Test
    public void testConsultar() {
        System.out.println("Testando método Consultar que retorna um registro");

        //<editor-fold defaultstate="collapsed" desc="criar obj oferta">
        Oferta oferta = new Oferta();
        oferta.setInicio(new java.sql.Date(2015, 10, 17));
        oferta.setTermino(new java.sql.Date(2016, 4, 17));
        oferta.setAtivo(false);
        Oferta.salvar(oferta);
        //</editor-fold>

        Oferta expResult = oferta;
        Oferta result = Oferta.consultar(oferta.getId());
        assertEquals(expResult, result);

        //<editor-fold defaultstate="collapsed" desc="excluir oferta">
        Oferta.excluir(oferta);
//</editor-fold>
    }

    /**
     * Test of alterar method, of class Oferta.
     */
    @Test
    public void testAlterar() {
        System.out.println("Testando o método Alterar");

        //<editor-fold defaultstate="collapsed" desc="criar obj oferta">
        Oferta oferta = new Oferta();
        oferta.setInicio(new java.sql.Date(2015, 10, 17));
        oferta.setTermino(new java.sql.Date(2016, 4, 17));
        oferta.setAtivo(false);
        Oferta.salvar(oferta);
        //</editor-fold>

        Oferta expResult = oferta;
        Oferta result = Oferta.consultar(oferta.getId());
        assertEquals(expResult, result);

        oferta.setAtivo(true);

        boolean test = Oferta.alterar(oferta);
        assertTrue(test);

        //<editor-fold defaultstate="collapsed" desc="excluir oferta">
        Oferta.excluir(oferta);
//</editor-fold>
    }

    /**
     * Test of excluir method, of class Oferta.
     */
    @Test
    public void testExcluir() {
        System.out.println("Testando método Excluir");

        //<editor-fold defaultstate="collapsed" desc="criar obj oferta">
        Oferta oferta = new Oferta();
        oferta.setInicio(new java.sql.Date(2015, 10, 17));
        oferta.setTermino(new java.sql.Date(2016, 4, 17));
        oferta.setAtivo(false);
        Oferta.salvar(oferta);
        //</editor-fold>
        
        boolean expResult = true;
        boolean result = Oferta.excluir(oferta);
        assertEquals(expResult, result);
    }


}
