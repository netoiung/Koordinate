/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SiapeValidator implements MyValidator {

    private final String numero = "(\\d+)";//qlq digito uma ou mais vezes
    private Pattern pattern;
    private Matcher matcher;

    public SiapeValidator() {
        pattern = Pattern.compile(numero);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            throw new ValidacaoException("O Siape deve conter um inteiro.");
        }else if(value.toString().length() > 10){
            throw new ValidacaoException("O Siape é um inteiro de no máximo 10 digitos.");
        }
    }
}
