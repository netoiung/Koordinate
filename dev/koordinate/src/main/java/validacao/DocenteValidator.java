/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import excecoes.ValidacaoException;
import model.Docente;
import validacao.base.EmailValidator;
import validacao.base.LinkValidator;
import validacao.base.NomeValidator;
import validacao.base.SiapeValidator;

/**
 *
 * @author Luiz
 */
public class DocenteValidator {
    
    private Docente docente;

    public DocenteValidator(Docente docente) {
        this.docente = docente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    /**
     * Valida o nome do docente;
     * O Email;
     * 
     * @throws ValidacaoException 
     */
    public void validar() throws ValidacaoException{
        NomeValidator nome = new NomeValidator();
        LinkValidator link = new LinkValidator();
        EmailValidator email = new EmailValidator();
        SiapeValidator siape = new SiapeValidator();
        
        nome.validar(this.docente.getNome());
        link.validar(this.docente.getLinklattes());
        email.validar(this.docente.getEmailinstitucional());
        siape.validar(this.docente.getSiape());
    }
    
}
