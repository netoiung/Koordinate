
package validacao;

import excecoes.ValidacaoException;
import model.ComponenteCurricular;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz
 */
public class ComponenteCurricularValidatorTest {

    private ComponenteCurricular componente;
    private ComponenteCurricularValidator validator;

    @Before
    public void setUp() {
        this.componente = new ComponenteCurricular();
        //Setamos dados aprovados que serao sobrescritos
        this.componente.setId(1);
        this.componente.setCod("1");
        this.componente.setIsativo(true);
        this.componente.setNome("Luiz Paulo Franz");
        this.componente.setCargahoraria(40);
        this.componente.setCreditos(8);
        this.componente.setLink("http://www.linkqualquer.com.br");

        this.validator = new ComponenteCurricularValidator(componente);
    }

    @After
    public void tearDown() {
    }

    /**
     * Teste de validação de carga horaria
     */
    @Test(expected = ValidacaoException.class)
    public void testCargaHorariaValidator() throws Exception{
        System.out.println("Teste de validacao de Carga horária");
        this.componente.setCargahoraria(444);
        try {
            this.validator.validar();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            throw e;
        }
    }

    /**
     * Teste de validação de nome
     */
    @Test(expected = ValidacaoException.class)
    public void testNomeValidator() throws Exception {
        System.out.println("Teste de validacao de nome");
        this.componente.setNome("Teste com 1 número");
        try {
            this.validator.validar();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            throw e;
        }
    }

    /**
     * Teste de validação de link
     */
    @Test(expected = ValidacaoException.class)
    public void testLinkValidator() throws Exception {
        System.out.println("Teste de validacao de links");
        this.componente.setLink("aaaaaaaaaaaaa");
        try {
            this.validator.validar();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            throw e;
        }
    }

    /**
     * Teste de validação de creditos (nao pode ser maior que 8)
     */
    @Test(expected = ValidacaoException.class)
    public void testCreditoValidator() throws Exception {
        System.out.println("Teste de validacao de creditos");
        this.componente.setCreditos(25);
        try {
            this.validator.validar();
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            throw e;
        }
    }

}
