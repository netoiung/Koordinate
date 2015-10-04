/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import excecoes.ValidacaoException;
import model.Curso;
import validacao.base.NomeValidator;

/**
 *
 * @author Luiz
 */
public class CursoValidator {
    
    private Curso curso;

    public CursoValidator(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setComponente(Curso curso) {
        this.curso = curso;
    }
    
    /**
     * Valida o nome do curso.
     * @throws ValidacaoException 
     */
    public void validar() throws ValidacaoException{
        NomeValidator nome = new NomeValidator();
        
        nome.validar(this.curso.getNome());
    }
    
}
