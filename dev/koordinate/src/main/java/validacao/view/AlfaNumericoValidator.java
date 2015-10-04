/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package validacao.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validacao.view.AlfaNumericoValidator")
public class AlfaNumericoValidator implements Validator {

    //Caracteres alfanumericos sem acentos
    private final String nome = ("[a-zA-Z0-9_]*");
    private Pattern pattern;
    private Matcher matcher;

    public AlfaNumericoValidator() {
        pattern = Pattern.compile(nome);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Alpha-numeric validation failed.", "Digite somente letras ou números.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        } else if (value.toString().length() > 150) {
            FacesMessage msg = new FacesMessage("Alpha-numeric validation failed.", "Excedeu o limite máximo de caracteres que é 150.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
