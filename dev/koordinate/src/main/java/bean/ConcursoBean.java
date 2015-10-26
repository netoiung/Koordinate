package bean;

import dao.DAOConcurso;
import excecoes.IntegridadeReferencialException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Concurso;

/**
 * ConcursoBean é a classe responsável pelo CRUD do concurso do sistema de
 * gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */
//tem que aprender a lidar com esse scopo
@SessionScoped
@ManagedBean(name = "concursoBean")
public class ConcursoBean {

    private Concurso concurso;
    private List<Concurso> concursos;

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public List<Concurso> getConcursos() {
        this.concursos = DAOConcurso.consultar();
        return concursos;
    }

    public void setConcursos(List<Concurso> concursos) {
        this.concursos = concursos;
    }

    /**
     * método construtor da classe ConcursoBean.
     */
    public ConcursoBean() {
        this.concurso = new Concurso();
    }

    /**
     * alterarConcurso é o método responsável pela alteração de um concurso
     *
     * @param reg
     * @return formConcurso
     */
    public String alterar(Concurso reg) {
        this.concurso = reg;
        return "/modules/concurso/form";
    }

    /**
     * Método responsável por criar um objeto Concurso e encaminhar ao seu form.
     *
     * @return formConcurso
     */
    public String cadastrar() {
        this.concurso = new Concurso();
        return "/modules/concurso/form";
    }

    /**
     * Método responsável por listar todos os concursos existentes.
     *
     * @return listaConcurso
     */
    public String listar() {
        return "/modules/concurso/lista";
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * consultar é o método responsável pela consulta de um curso.
     *
     * @param reg
     * @return String
     */
    public String consultar(Concurso reg) {
        this.concurso = DAOConcurso.consultarWithJoin(reg);
        return "/modules/concurso/consulta";
    }

    /**
     * Método responsável por persistir um objeto Concurso e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        if (DAOConcurso.salvar(concurso)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Registro salvo com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível salvar, por favor tente novamente.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        return "/modules/concurso/lista";
    }

    /**
     * excluir é o método usado para excluir um curso.
     *
     * @param reg
     */
    public void excluir(Concurso reg) {
        this.concurso = reg;
        try {
            if (DAOConcurso.excluir(this.concurso)) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Registro excluido com sucesso.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível excluir, por favor tente novamente.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            }
        } catch (IntegridadeReferencialException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        this.listar();
    }
//</editor-fold>

}
