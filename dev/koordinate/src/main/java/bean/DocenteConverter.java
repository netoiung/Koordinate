/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAODocente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Docente;

/**
 *
 * @author Luiz Paulo Franz
 */
@FacesConverter(forClass = Docente.class, value = "docenteConverter")
public class DocenteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        } else {
            DAODocente dao = new DAODocente();
            int id = Integer.parseInt(value);
            Docente docente = dao.consultar(id);
            System.out.println("AKIIIII");
            System.out.println(docente.getNome());
            return docente;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            //DAODocente dao = new DAODocente();
            //int id = (Integer)value;
            //Docente docente = dao.consultar(id);
            
            //Docente docente = (Docente) value;
            return String.valueOf(value);
        }
    }
}
