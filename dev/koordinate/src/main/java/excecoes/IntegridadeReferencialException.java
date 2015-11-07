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
public class IntegridadeReferencialException extends Exception{
    
    /**
     * 
     * @param mensagem
     */
    public IntegridadeReferencialException(String mensagem) {        
        super(mensagem);
    }
    
    /**
     *
     */
    public IntegridadeReferencialException(){
        super("Esse registro está associado a outros registros, por favor verifique se não há registros filhos deste!");
    }
}
