
package bean;

import dao.DAOComponenteCurricular;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.ComponenteCurricular;
import model.Docente;

/** Classe responsável por converter um Componente Curricular de um select para um objeto
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Docente.class, value = "componenteCurricularConverter")
public class ComponenteCurricularConverter implements Converter {

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
            DAOComponenteCurricular dao = new DAOComponenteCurricular();
            int id = Integer.parseInt(value);
            ComponenteCurricular componente = dao.consultar(id);
            return componente;
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
        if (value instanceof ComponenteCurricular) {
            ComponenteCurricular c = (ComponenteCurricular) value;
            r = String.valueOf(c.getId());
        } else if(value instanceof String){
            r = (String) value;
        }
        return r;
    }
}
