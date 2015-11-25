
package converters;

import dao.DAOConcurso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Concurso;

/** Classe responsável por converter um Concurso de um select para um objeto
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Concurso.class, value = "concursoConverter")
public class ConcursoConverter implements Converter {

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
            Concurso concurso = DAOConcurso.consultar(id);
            return concurso;
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
        if (value instanceof Concurso) {
            Concurso c = (Concurso) value;
            r = String.valueOf(c.getId());
        } else if(value instanceof String){
            r = (String) value;
        }
        return r;
    }
}
