
package converters;

import dao.DAODocente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Docente;

/** Classe responsável por converter um Docente de um select para um objeto
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Docente.class, value = "docenteConverter")
public class DocenteConverter implements Converter {

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
            DAODocente dao = new DAODocente();
            int id = Integer.parseInt(value);
            Docente docente = dao.consultar(id);
            return docente;
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
        if (value instanceof Docente) {
            Docente d = (Docente) value;
            r = String.valueOf(d.getId());
        } else if(value instanceof String){
            r = (String) value;
        }
        return r;
    }
}
