/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanAcesso;

import bean.DocenteBean;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * author Jonas
 */
@ManagedBean(name = "myNavigationHandler")
@ApplicationScoped
public class MyNavigationHandler {

    DocenteBean docenteBean;

    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Usuario">
    public void goToUsuarioMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/usuarioForms/mainUsuario.xhtml?faces-redirect=true");
    }

    public String goToUsuarioForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/usuarioForms/usuarioForm.xhtml?faces-redirect=true");
        return "/private/admin/usuarioForms/usuarioForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Componente Curricular">
    public void goToMainComponente() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/componenteForms/mainComponente.xhtml?faces-redirect=true");
    }

    public String goToComponenteForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/componenteForms/componenteForm.xhtml?faces-redirect=true");
        return "/private/admin/componenteForms/componenteForm.xhtml?faces-redirect=true";
    }

    public String goToConsultaComponenteForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/componenteForms/consultaComponenteForm.xhtml?faces-redirect=true");
        return "/private/admin/componenteForms/consultaComponenteForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Docente">
    public void goToMainDocente() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/docenteForms/mainDocente.xhtml?faces-redirect=true");
    }


    public String goToDocenteForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/docenteForms/docenteForm.xhtml?faces-redirect=true");
        return "/private/admin/docenteForms/docenteForm.xhtml?faces-redirect=true";
    }

    public String goToDocenteFormEditar() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/docenteForms/docenteFormEditar.xhtml?faces-redirect=true");
        return "/private/admin/docenteForms/docenteFormEditar.xhtml?faces-redirect=true";
    }

    public String goToConsultaDocenteForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/docenteForms/consultaDocenteForm.xhtml?faces-redirect=true");
        return "/private/admin/docenteForms/consultaDocenteForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Oferta">
    public void goToMainOferta() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/main.xhtml?faces-redirect=true");
    }

    public String goToOfertaForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/formOferta.xhtml?faces-redirect=true");
        return "/private/coordAcad/formOferta.xhtml?faces-redirect=true";
    }

    public String goToconsultaOfertaForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/consulta.xhtml?faces-redirect=true");
        return "/private/coordAcad/consulta.xhtml?faces-redirect=true";
    }
    
    public String goToInstrucaoForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/addInstrucoes.xhtml?faces-redirect=true");
        return "/private/coordAcad/addInstrucoes.xhtml?faces-redirect=true";
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Curso">
    public void goToMainCurso() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/cursoForms/mainCurso.xhtml?faces-redirect=true");
    }

    public String goToCursoForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/cursoForms/cursoForm.xhtml?faces-redirect=true");
        return "/private/admin/cursoForms/cursoForm.xhtml?faces-redirect=true";
    }

    public String goToconsultaCursoForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/cursoForms/consultaCursoForm.xhtml?faces-redirect=true");
        return "/private/admin/cursoForms/consultaCursoForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Redirect Cadastro Concurso">
    public void goToMainConcurso() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/concursoForms/mainConcurso.xhtml?faces-redirect=true");
    }

    public String goToConcursoForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/concursoForms/concursoForm.xhtml?faces-redirect=true");
        return "/private/admin/concursoForms/concursoForm.xhtml?faces-redirect=true";
    }

    public String goToconsultaConcursoForm() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/admin/concursoForms/consultaConcursoForm.xhtml?faces-redirect=true");
        return "/private/admin/concursoForms/consultaConcursoForm.xhtml?faces-redirect=true";
    }
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Redirect Principal">
    public void goToMainPage() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/main.xhtml?faces-redirect=true");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Redirect Docente">
    public void goToDocenteMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/docente/main.xhtml?faces-redirect=true");
    }

    public String goToDocenteMainPreferencia() {

        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/docente/mainPreferencia.xhtml?faces-redirect=true");
        return "/private/docente/mainPreferencia.xhtml?faces-redirect=true";

    }
    // </editor-fold>

    public void goToMyProfile() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/personalEdit.xhtml?faces-redirect=true");
    }

    public void goToCoordAcadMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/main.xhtml?faces-redirect=true");
    }


    public void goToCoordAcadMainMontarOferta() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordAcad/montarOferta.xhtml?faces-redirect=true");
    }

    public void goToCoordCursoMain() {
        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/coordCurso/main.xhtml?faces-redirect=true");
    }
}
