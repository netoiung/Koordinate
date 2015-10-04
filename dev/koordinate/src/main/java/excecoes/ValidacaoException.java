/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 * Essa classe de excecao sera lancada para evitar erros de integridade referencial.
 * @author Luiz Paulo Franz
 */
public class ValidacaoException extends Exception{
    
    public ValidacaoException(String mensagem) {        
        super(mensagem);
    }
    
    public ValidacaoException(){
        super("O campo digitado possui um valor inválido!");
    }
}
