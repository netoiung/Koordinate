/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditosValidator implements MyValidator {

    private final String numero = "[1-8]";
    private Pattern pattern;
    private Matcher matcher;

    public CreditosValidator() {
        pattern = Pattern.compile(numero);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            throw new ValidacaoException("O crédito deve ser um número de 1 a 8.");
        }
    }

}
