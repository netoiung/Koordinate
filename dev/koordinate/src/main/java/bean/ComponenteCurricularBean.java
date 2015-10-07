package bean;

import dao.DAOComponenteCurricular;
import dao.DAOCurso;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ComponenteCurricular;
import model.ComponenteCurso;

/**
 * ComponenteCurrilarBean é a classe responsável pelo CRUD do Componente
 * Curricular do sistema de gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */
//tem que aprender a lidar com esse scopo
@SessionScoped
@ManagedBean(name = "componenteCurricularBean")
public class ComponenteCurricularBean {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private ComponenteCurricular componente;
    private List<ComponenteCurricular> componentes;
    private ComponenteCurso componenteCurso;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        this.componente = new ComponenteCurricular();
        this.componenteCurso = new ComponenteCurso();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public ComponenteCurricular getComponente() {
        return componente;
    }

    public void setComponente(ComponenteCurricular componente) {
        this.componente = componente;
    }

    public List<ComponenteCurricular> getComponentes() {
        this.componentes = DAOComponenteCurricular.consultar();
        return componentes;
    }

    public ComponenteCurso getComponenteCurso() {
        return componenteCurso;
    }

    public void setComponenteCurso(ComponenteCurso componenteCurso) {
        this.componenteCurso = componenteCurso;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * consultarComponenteCurricular é o método responsável pela consulta de um
     * componente curricular
     *
     * @param reg
     * @return formComponenteCurricular
     */
    public String consultarComponenteCurricular(ComponenteCurricular reg) {
        this.componente = reg;
        return "consultaComponenteCurricular";
    }

    /**
     * excluirComponenteCurricular é o método usado para excluir um componente
     * curricular
     *
     * @param reg
     */
    public void excluirComponenteCurricular(ComponenteCurricular reg) {
        this.componente = reg;
        DAOComponenteCurricular dao = new DAOComponenteCurricular();
        dao.excluir(this.componente);
        this.listaComponentes();
    }

    /**
     * Método responsável por persistir um objeto Curso e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        DAOComponenteCurricular.salvar(componente);
        return "/modules/componenteCurricular/lista";
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Redirecionamento de Paginas">
    /**
     * alterarComponenteCurricular é o método responsável pela alteração de um
     * componente curricular
     *
     * @param reg
     * @return formComponenteCurricular
     */
    public String alterarComponenteCurricular(ComponenteCurricular reg) {
        this.componente = reg;
        return "formComponenteCurricular";
    }

    /**
     * Método responsável por criar um objeto ComponenteCurricular e encaminhar
     * ao seu form.
     *
     * @return formComponenteCurricular
     */
    public String cadastrarComponenteCurricular() {
        this.componente = new ComponenteCurricular();
        return "formComponenteCurricular";
    }

    /**
     * Método responsável por listar todos os componentes curriculares
     * existentes.
     *
     * @return listaComponenteCurricular
     */
    public String listaComponentes() {
        return "/modules/componenteCurricular/lista";
    }
//</editor-fold>

}
