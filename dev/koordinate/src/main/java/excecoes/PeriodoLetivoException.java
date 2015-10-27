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
public class PeriodoLetivoException extends Exception{
    
    public PeriodoLetivoException(String mensagem) {        
        super(mensagem);
    }
    
    public PeriodoLetivoException(){
        super("Já existe uma oferta com esse período letivo, por favor, escolha outro período letivo.");
    }
}
