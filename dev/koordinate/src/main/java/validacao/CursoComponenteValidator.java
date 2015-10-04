/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import excecoes.ValidacaoException;
import model.CursoComponente;
import validacao.base.SemestreValidator;

/**
 *
 * @author Luiz
 */
public class CursoComponenteValidator {
    
    private CursoComponente cursoComponente;

    public CursoComponenteValidator(CursoComponente cursoComponente) {
        this.cursoComponente = cursoComponente;
    }

    public CursoComponente getCurso() {
        return cursoComponente;
    }

    public void setComponente(CursoComponente cursoComponente) {
        this.cursoComponente = cursoComponente;
    }
    
    /**
     * Valida o semestre do componente do curso
     * @throws ValidacaoException 
     */
    public void validar() throws ValidacaoException{
        SemestreValidator semestre = new SemestreValidator();
        
        semestre.validar(this.cursoComponente.getSemestre());
    }
    
}
