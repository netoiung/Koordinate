package bean;

import dao.DAOCurso;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Curso;
import model.Docente;

/**
 * CursoBean é a classe responsável pelo CRUD do Cursos.
 *
 * @author Luiz Paulo Franz
 */
@SessionScoped
@ManagedBean(name = "cursoBean")
public class CursoBean {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private Curso curso;
    private List<Curso> cursos;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init">
    /**
     * Método iniciador das variáveis
     *
     */
    @PostConstruct
    public void init() {
        this.curso = new Curso();
        this.cursos = DAOCurso.consultar();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e setters">
    /**
     * Método responsável por buscar uma lista de cursos registrados no banco,
     * atribui-la a cursos e recuperar o valor de cursos
     *
     * @return Uma lista com os cursos registrados no banco
     */
    public List<Curso> getCursos() {
        this.cursos = DAOCurso.consultar();
        return this.cursos;
    }

    /**
     * Método responsável por recuperar o valor do objeto curso
     *
     * @return O curso setado atualmente
     */
    public Curso getCurso() {
        return this.curso;
    }

    /**
     * Método responsável por atualizar o valor do objeto curso
     *
     * @param curso - O novo curso a ser setado
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * consultar é o método responsável pela consulta de um curso.
     *
     * @param reg
     * @return String
     */
    public String consultar(Curso reg) {
        //O Join eh necessario para usar com o LAZY loading
        DAOCurso dao = new DAOCurso();
        this.curso = dao.consultarWithJoin(reg);
        return "/modules/curso/consulta";
    }

    /**
     * Método responsável por persistir um objeto Curso e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {

        if (DAOCurso.salvar(curso)) {
            Docente docente = curso.getDocente();
            docente.setNivel(1);
            Docente.alterar(docente);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Registro salvo com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível salvar, por favor tente novamente.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }

        return "/modules/curso/lista";
    }

    /**
     * Método responsável por persistir um objeto Curso e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String editar() {
        DAOCurso.alterar(curso);
        return "/modules/curso/lista";
    }

    /**
     * excluir é o método usado para excluir um curso.
     *
     * @param reg
     */
    public void excluir(Curso reg) {
        this.curso = reg;
        if (DAOCurso.excluir(curso)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Registro excluído com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível excluir, por favor tente novamente.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        this.listar();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Redirecionamentos de Paginas">
    /**
     * Método responsável por criar um objeto Curso e encaminhar ao seu form.
     *
     * @return String
     */
    public String cadastrar() {
        this.curso = new Curso();
        this.curso.setNumeroDeSemestres(10);
        return "/modules/curso/formCadastrar";
    }

    /**
     * alterar é o método responsável pela alteração de um curso.
     *
     * @param reg
     * @return String
     */
    public String alterar(Curso reg) {
        this.curso = reg;
        return "/modules/curso/formEditar";
    }

    /**
     * Método responsável por listar todos os cursos existentes.
     *
     * @return String
     */
    public String listar() {
        return "/modules/curso/lista";
    }
//</editor-fold>
}
