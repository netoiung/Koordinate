/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import excecoes.ValidacaoException;
import model.ComponenteCurricular;
import validacao.base.CargaHorariaValidator;
import validacao.base.CreditosValidator;
import validacao.base.LinkValidator;
import validacao.base.NomeValidator;

/**
 *
 * @author Luiz
 */
public class ComponenteCurricularValidator {
    
    private ComponenteCurricular componente;

    public ComponenteCurricularValidator(ComponenteCurricular componente) {
        this.componente = componente;
    }

    public ComponenteCurricular getComponente() {
        return componente;
    }

    public void setComponente(ComponenteCurricular componente) {
        this.componente = componente;
    }
    
    /**
     * Valida o nome do componente curricular;
     * Os créditos;
     * O link do lattes;
     * E a carga horária.
     * 
     * @throws ValidacaoException 
     */
    public void validar() throws ValidacaoException{
        NomeValidator nome = new NomeValidator();
        CreditosValidator credito = new CreditosValidator();
        LinkValidator link = new LinkValidator();
        CargaHorariaValidator carga = new CargaHorariaValidator();
        
        nome.validar(this.componente.getNome());
        credito.validar(this.componente.getCreditos());
        link.validar(this.componente.getLink());
        carga.validar(this.componente.getCargahoraria());
    }
    
}
