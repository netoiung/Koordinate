/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeriodoLetivoValidator implements MyValidator {

    public final String periodoLetivo = "((?:(?:[1]{1}\\\\d{1}\\\\d{1}\\\\d{1})|(?:[2]{1}\\\\d{3})))(?![\\\\d])" + "(\\/)" + "(\\d)";
    private Pattern pattern;
    private Matcher matcher;

    public PeriodoLetivoValidator() {
        pattern = Pattern.compile(periodoLetivo);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            throw new ValidacaoException("Período letivo em formato inválido, por favor siga o modelo: \"2015/1\".");
        }
    }
}
