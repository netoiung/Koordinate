package beanAcesso;

import dao.DAODocente;
import dao.DAORole;
import dao.DAOUsuario;
import model.Docente;
import model.Role;
import model.Usuario;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * author Jonas
 */
@ManagedBean(name = "loginHandler")
@ApplicationScoped
public class LoginHandler {

    private Usuario usuario;

    public LoginHandler() {
        this.usuario = new Usuario();
        DAOUsuario.consultar();
        DAODocente.consultar();
        DAORole.consultar();
    }

    public void loginUser() {
        System.out.println("akiiiii");
        try {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(this.usuario.getEmail(), new Sha256Hash(this.usuario.getSenha()).toHex());

            currentUser.login(token);
            //there is maybe another option for this
            this.usuario = (Usuario) DAOUsuario.consultarCriteria("email", this.usuario.getEmail(), Usuario.class);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("loggedUser", this.usuario);
            
            authorizedUserControl();
        } catch (UnknownAccountException uae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email não encontrado!", ""));

        } catch (IncorrectCredentialsException ice) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incompatíve!", ""));

        } catch (LockedAccountException lae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário bloqueado!", ""));

        } catch (AuthenticationException aex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", aex.toString()));
        }

    }

    public void logout() {
        SecurityUtils.getSubject().logout();

        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/index.xhtml?faces-redirect=true");

    }

    public void authorizedUserControl() {

        if (null != SecurityUtils.getSubject().getPrincipal()) {
            

            NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/main.xhtml?faces-redirect=true");

        }
    }
    
    public Usuario getLoggedUser(){
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedUser");
    }

    
    //<editor-fold defaultstate="collapsed" desc="GET SET">
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //</editor-fold>

}
