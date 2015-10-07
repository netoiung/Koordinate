package bean;

import dao.DAOConcurso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Concurso;

/**
 * ConcursoBean é a classe responsável pelo CRUD do concurso do sistema de gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */
//tem que aprender a lidar com esse scopo
@ViewScoped
//@SessionScoped
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
     * consultarConcurso é o método responsável pela consulta de um
     * concurso
     *
     * @param reg
     * @return formConcurso
     */
    public String consultarConcurso(Concurso reg) {
        this.concurso = reg;
        return "consultaConcurso";
    }

    /**
     * alterarConcurso é o método responsável pela alteração de um
     * concurso
     *
     * @param reg
     * @return formConcurso
     */
    public String alterarConcurso(Concurso reg) {
        this.concurso = reg;
        return "formConcurso";
    }

    /**
     * Método responsável por criar um objeto Concurso e encaminhar
     * ao seu form.
     *
     * @return formConcurso
     */
    public String cadastrarConcurso() {
        this.concurso = new Concurso();
        return "formConcurso";
    }

    /**
     * excluirConcurso é o método usado para excluir um concurso
     * 
     *
     * @param reg
     */
    public void excluirConcurso(Concurso reg) {
        this.concurso = reg;
        DAOConcurso.excluir(this.concurso);
        this.listaConcursos();
    }

    /**
     * Método responsável por listar todos os concursos 
     * existentes.
     *
     * @return listaConcurso
     */
    public String listaConcursos() {
        return "/modules/concurso/lista";
    }


}
