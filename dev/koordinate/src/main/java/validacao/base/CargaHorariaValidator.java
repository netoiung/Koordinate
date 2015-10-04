/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CargaHorariaValidator implements MyValidator {

    private final String numero = "(\\d+)"; //qlq digito uma ou mais vezes
    private Pattern pattern;
    private Matcher matcher;

    public CargaHorariaValidator() {
        pattern = Pattern.compile(numero);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if(matcher.matches()){
            int i = (Integer) value;
            //carga horaria maxima eh 120 horas
            if(i>120){
                throw new ValidacaoException("Carga horária máxima permitida é de 120 horas");
            }
        }else{
            throw new ValidacaoException("Carga horária deve ser um inteiro.");
        }
    }

}
