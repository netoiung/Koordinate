package converters;

import dao.DAOCurso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Curso;

/**
 * lasse responsável por converter um Curso de um select para um objeto
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Curso.class, value = "cursoConverter")
public class CursoConverter implements Converter {

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
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

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String r = "";
        if (value instanceof Curso) {
            Curso c = (Curso) value;
            r = String.valueOf(c.getId());
        } else if (value instanceof String) {
            r = (String) value;
        }
        return r;
    }
}
