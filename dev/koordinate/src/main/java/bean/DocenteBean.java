package bean;

import dao.DAODocente;
import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Docente;

/**
 * DocenteBean é a classe responsável pelo CRUD do Docentes
 *
 * @author Luiz Paulo Franz
 */
@SessionScoped
@ManagedBean(name = "docenteBean")
public class DocenteBean {

    //<editor-fold defaultstate="collapsed" desc="variaveis">
    private Docente docente;
    private List<Docente> docentes;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="init">
    /**
     * Método inicialisador das variáveis
     *
     */
    @PostConstruct
    public void init() {
        this.docente = new Docente();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    /**
     * Método responsável por recuperar os docentes do banco e seta-los em
     * docentes
     *
     * @return Uma lista com os docentes cadastrados no banco
     */
    public List<Docente> getDocentes() {
        DAODocente dao = new DAODocente();
        this.docentes = DAODocente.consultar();
        contarCreditos();
        return this.docentes;
    }

    /**
     * Método responsável por recuperar o valor da variavel docente
     *
     * @return O docente setado atualmente
     */
    public Docente getDocente() {
        return this.docente;
    }

    /**
     * Método responsável por atualizar o valor da variavel docente com um novo
     * docente
     *
     * @param docente - Novo docente a ser setado
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="direcionamento de páginas">
    /**
     * consultar é o método responsável pela consulta de um docente.
     *
     * @param reg Docente
     * @return String
     */
    public String consultar(Docente reg) {
        this.docente = reg;
        return "/modules/docente/consulta";
    }

    /**
     * alterar é o método responsável pela alteração de um docente.
     *
     * @param reg Docente
     * @return String
     */
    public String alterar(Docente reg) {
        this.docente = reg;
        return "/modules/docente/form";
    }

    /**
     * Método responsável por criar um objeto Docente e encaminhar ao seu form.
     *
     * @return String
     */
    public String cadastrar() {
        this.docente = new Docente();
        return "/modules/docente/form";
    }

    /**
     * Método responsável por listar todos os docentes existentes.
     *
     * @return String
     */
    public String listar() {
        return "/modules/docente/lista";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * Método responsável por persistir um objeto Docente e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        DAODocente dao = new DAODocente();
        if (dao.salvar(docente)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Registro salvo com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível salvar, por favor tente novamente.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        return "/modules/docente/lista";
    }

    /**
     * excluir é o método usado para excluir um Docente do banco.
     *
     * @param reg Docente
     */
    public void excluir(Docente reg) {
        this.docente = reg;
        try {
            if (DAODocente.excluir(this.docente)) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluído com sucesso.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível excluir, por favor tente novamente.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            }
        } catch (IntegridadeReferencialException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        this.listar();
    }
//</editor-fold>
    
    public void contarCreditos(){
        for (Docente docente1 : docentes) {
            int c = DAODocente.getCreditos(docente1);
            docente1.setCreditos(c);
        }
        
    }
}
