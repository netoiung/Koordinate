/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import excecoes.ValidacaoException;
import model.CursoComponente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz
 */
public class CursoComponenteValidatorTest {
    
    private CursoComponente componente;
    private CursoComponenteValidator validator;
    
    @Before
    public void setUp() {
        this.componente = new CursoComponente();
        //Setamos dados aprovados que serao sobrescritos
        this.componente.setId(1);

        this.validator = new CursoComponenteValidator(componente);
    }

    /**
     * Teste de validação de semestre
     */
    @Test(expected = ValidacaoException.class)
    public void testCargaHorariaValidator() throws Exception{
        System.out.println("Teste de validacao de Semestre");
        this.componente.setSemestre(444);
        try {
            this.validator.validar();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            throw e;
        }
    }
    
}
