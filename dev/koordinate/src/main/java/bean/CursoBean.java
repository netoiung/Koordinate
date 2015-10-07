package bean;

import dao.DAOCurso;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Curso;

/**
 * CursoBean é a classe responsável pelo CRUD do Cursos.
 *
 * @author Luiz Paulo Franz
 */
@SessionScoped
@ManagedBean(name = "cursoBean")
public class CursoBean {

    private Curso curso;
    private List<Curso> cursos;
    
    @PostConstruct 
    public void init(){ 
        this.curso = new Curso();
    }

    /**
     * consultar é o método responsável pela consulta de um curso.
     *
     * @param reg
     * @return String
     */
    public String consultar(Curso reg) {
        this.curso = reg;
        return "/modules/curso/consulta";
    }

    /**
     * alterar é o método responsável pela alteração de um curso.
     * 
     * @param reg
     * @return String
     */
    public String alterar(Curso reg) {
        this.curso = reg;
        return "/modules/curso/form";
    }

    /**
     * Método responsável por criar um objeto Curso e encaminhar ao seu form.
     *
     * @return String
     */
    public String cadastrar() {
        this.curso = new Curso();
        return "/modules/curso/form";
    }
    
    /**
     * Método responsável por persistir um objeto Curso e encaminhar ao seu form.
     *
     * @return String
     */
    public String salvar(){
        DAOCurso dao = new DAOCurso();
        dao.salvar(curso);
        return "/modules/curso/lista";
    }

    /**
     * excluir é o método usado para excluir um curso.
     *
     * @param reg
     */
    public void excluir(Curso reg) {
        this.curso = reg;
        DAOCurso dao = new DAOCurso();
        dao.excluir(this.curso);
        this.listar();
    }

    /**
     * Método responsável por listar todos os cursos existentes.
     *
     * @return String
     */
    public String listar() {
        return "/modules/curso/lista";
    }
    
    
    public List<Curso> getCursos(){
        DAOCurso dao = new DAOCurso();
        this.cursos = DAOCurso.consultar();
        return this.cursos;
    }
    
    public Curso getCurso(){
        return this.curso;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }

}
