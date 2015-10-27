package bean;

import dao.DAOConcurso;
import excecoes.IntegridadeReferencialException;
import java.util.List;
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

    //<editor-fold defaultstate="collapsed" desc="variaveis">
    private Concurso concurso;
    private List<Concurso> concursos;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="construtor">
    /**
     * método construtor da classe ConcursoBean.
     */
    public ConcursoBean() {
        this.concurso = new Concurso();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    /**
     * Método responsável por recuperar o valor de concurso
     *
     * @return O objeto concurso setado atualmente
     */
    public Concurso getConcurso() {
        return concurso;
    }

    /**
     * Método responsável por atualizar o valor de concurso
     *
     * @param concurso - Novo valor de concurso
     */
    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    /**
     * Método responsável por recuperar o valor de concursos
     *
     * @return Uma lista dos concursos cadastrados
     */
    public List<Concurso> getConcursos() {
        this.concursos = DAOConcurso.consultar();
        return concursos;
    }

    /**
     * Método responsável por atualizar o valor de concursos
     *
     * @param concursos - Novo lista de concursos
     */
    public void setConcursos(List<Concurso> concursos) {
        this.concursos = concursos;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="direcionamento de paginas">
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
//</editor-fold>

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
