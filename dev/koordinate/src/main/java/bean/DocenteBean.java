package bean;

import dao.DAODocente;
import java.util.List;
import javax.annotation.PostConstruct;
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

    private Docente docente;
    private List<Docente> docentes;

    @PostConstruct
    public void init() {
        this.docente = new Docente();
    }

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
     * Método responsável por persistir um objeto Docente e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        DAODocente dao = new DAODocente();
        dao.salvar(docente);
        return "/modules/docente/lista";
    }

    /**
     * excluir é o método usado para excluir um Docente do banco.
     *
     * @param reg Docente
     */
    public void excluir(Docente reg) {
        this.docente = reg;
        DAODocente dao = new DAODocente();
        dao.excluir(this.docente);
        this.listar();
    }

    /**
     * Método responsável por listar todos os docentes existentes.
     *
     * @return String
     */
    public String listar() {
        return "/modules/docente/lista";
    }

    public List<Docente> getDocentes() {
        DAODocente dao = new DAODocente();
        this.docentes = DAODocente.consultar();
        return this.docentes;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
