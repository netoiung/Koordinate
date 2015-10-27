package validacao.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validacao.view.PeriodoLetivoValidator")
public class PeriodoLetivoValidator implements Validator {

    public final String periodoLetivo = "[1-9]" + "[0-9]" + "[0-9]" + "[0-9]" + "/" + "[1-9]";
    private Pattern pattern;
    private Matcher matcher;

    public PeriodoLetivoValidator() {
        pattern = Pattern.compile(periodoLetivo);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Periodo letivo validation failed.", "Período letivo em formato inválido, por favor siga o modelo: \"2015/1\".");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
