package access;

import model.Usuario;
//import persistence.MyPersistence;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
//import javax.security.auth.Subject;
import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
//import org.primefaces.util.SecurityUtils;

/**
 * @author Giovane
 */
@ManagedBean(name = "loginHandler")
@ApplicationScoped
public class LoginHandler {

    private Usuario usuario;

    public LoginHandler() {
        this.usuario = new Usuario();
//        new MyPersistence().read(Docente.class);
//        new MyPersistence().read(Role.class);
//        new MyPersistence().read(Usuario.class);

//        List<MyInterfaceEntity> users = new MyPersistence().read(Usuario.class);
//        
//        for(MyInterfaceEntity i : users){
//            Usuario u = (Usuario) i;
//            u.setSenha("6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b");
//            new MyPersistence().save(u);
//        }
//        
    }

    public void loginUser() {
        try {
            Subject currentUser = SecurityUtils.getSubject( );
            UsernamePasswordToken token = new UsernamePasswordToken(this.usuario.getEmail(), 
                    new Sha256Hash(this.usuario.getSenha()).toHex());

            currentUser.login(token);
            //there is maybe another option for this
//            this.usuario = (Usuario) new MyPersistence().getByCriteria("email", this.usuario.getEmail(), Usuario.class);
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            session.setAttribute("loggedUser", this.usuario);
            
            /**Alterado pois o projeto atual não usa a classe MyPersistence**/
            this.usuario = usuario.getByCriteria("email", this.usuario.getEmail(), Usuario.class);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("loggedUser", this.usuario);
            
            authorizedUserControl();
        } catch (UnknownAccountException uae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email não encontrado!", ""));

        } catch (IncorrectCredentialsException ice) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incompatíve!", ""));

        } catch (LockedAccountException lae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário bloqueado!", ""));

//        } catch (AuthenticationException aex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", aex.toString()));
//        }

    }

    public void logout(){
        SecurityUtils.getSubject().logout();

        NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/index.xhtml?faces-redirect=true");

    }
        
    public void authorizedUserControl() {

        if (null != SecurityUtils.getSubject().getPrincipal()) {

            NavigationHandler naviHandler = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            naviHandler.handleNavigation(FacesContext.getCurrentInstance(), null, "/private/login.xhtml?faces-redirect=true");

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
