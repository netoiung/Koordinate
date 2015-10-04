/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeValidator implements MyValidator {

    private final String nome = ("^[a-zA-Z ]+$");
    private Pattern pattern;
    private Matcher matcher;

    public NomeValidator() {
        pattern = Pattern.compile(nome);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            throw new ValidacaoException("O nome deve conter apenas letras e espaços.");
        }
    }

}
