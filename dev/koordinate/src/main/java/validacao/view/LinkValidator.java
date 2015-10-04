package validacao.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validacao.view.LinkValidator")
public class LinkValidator implements Validator {

    private final String link = "^((https?:\\/\\/)?(www\\.)?([a-zA-Z0-9_\\-]+)+\\.([a-zA-Z]{2,4})(?:\\.([a-zA-Z]{2,4}))?\\/?(.*))*$";
    private Pattern pattern;
    private Matcher matcher;

    public LinkValidator() {
        pattern = Pattern.compile(link);
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());

        if (!matcher.matches()) {

            FacesMessage msg
                    = new FacesMessage("Link validation failed.",
                            "Link inválido, por favor siga o padrão: http://exemplodelink.com.br");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        } else if (value.toString().length() > 255) {
            FacesMessage msg
                    = new FacesMessage("Link validation failed.",
                            "Excedeu o limite máximo de caracteres que é 255.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
