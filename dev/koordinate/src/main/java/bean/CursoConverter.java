
package bean;

import dao.DAOCurso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Curso;

/**
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Curso.class, value = "cursoConverter")
public class CursoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        } else {
            int id = Integer.parseInt(value);
            Curso curso = DAOCurso.consultar(id);
            return curso;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String r = "";
        if (value instanceof Curso) {
            Curso c = (Curso) value;
            r = String.valueOf(c.getId());
        } else if(value instanceof String){
            r = (String) value;
        }
        return r;
    }
}
