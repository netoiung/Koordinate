/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Giovane
 */

@ManagedBean(name = "myNavigationHandler")
@ApplicationScoped
public class MyNavigationHandler {

    // <editor-fold defaultstate="collapsed" desc="Redirect Usuario">
    public void goToAdminMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/main.xhtml?faces-redirect=true");
    }

    public String goToUsuarioForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/usuarioForm.xhtml?faces-redirect=true");
        return "/private/admin/usuarioForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>

    public void goToMainPage() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/main.xhtml?faces-redirect=true");
    }

    public void goToMyProfile() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/personalEdit.xhtml?faces-redirect=true");
    }

    public void goToCoordAcadMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/main.xhtml?faces-redirect=true");
    }
    
    public void goToOfertaForm(){
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/ofertaForm.xhtml?faces-redirect=true");
    }

    public void goToCoordCursoMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordCurso/main.xhtml?faces-redirect=true");
    }

    public void goToDocenteMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/docente/main.xhtml?faces-redirect=true");
    }
}