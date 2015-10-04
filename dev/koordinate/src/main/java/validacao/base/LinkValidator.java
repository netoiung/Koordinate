package validacao.base;

import excecoes.ValidacaoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkValidator implements MyValidator {

    //private final String link = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private final String link2 = "^(https?:\\/\\/)?(www\\.)?([a-zA-Z0-9_\\-]+)+\\.([a-zA-Z]{2,4})(?:\\.([a-zA-Z]{2,4}))?\\/?(.*)$";
    private Pattern pattern;
    private Matcher matcher;

    public LinkValidator() {
        pattern = Pattern.compile(link2);
    }

    @Override
    public void validar(Object value) throws ValidacaoException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){
            throw new ValidacaoException("Link inválido.");
        }
    }

}
