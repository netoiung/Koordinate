package bean;

import dao.DAOComponenteCurricular;
import dao.DAOComponenteCurso;
import dao.DAOCurso;
import java.util.List;
import java.util.Set;
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

    public Set getComponenteCursos() {
        return componente.getComponenteCursos();
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
    public String consultar(ComponenteCurricular reg) {
        this.componente = reg;
        return "consultaComponenteCurricular";
    }

    /**
     * excluirComponenteCurricular é o método usado para excluir um componente
     * curricular
     *
     * @param reg
     */
    public void excluir(ComponenteCurricular reg) {
        this.componente = reg;
        DAOComponenteCurricular dao = new DAOComponenteCurricular();
        dao.excluir(this.componente);
        this.listar();
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

    /**
     * Adicionamos um curso para ofertar esse componente curricular.
     *
     */
    public void addCurso() {
        componenteCurso.setComponenteCurricular(componente);
        ComponenteCurso temp = DAOComponenteCurso.consultar(componenteCurso);
        if (temp == null) {
            DAOComponenteCurso.alterar(componenteCurso);
        }
        this.alterar(componente.getId());
    }

    /**
     * Removemos o curso da oferta deste componente curricular.
     *
     * @param reg Curso
     */
    public String removerCurso(ComponenteCurso reg) {
        //excluimos o registro
        DAOComponenteCurso.excluir(reg);
        //recarregamos o objeto componente para sincronizar os relacionamentos
        componente = DAOComponenteCurricular.consultar(componente.getId());
        return "/modules/componenteCurricular/form";
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Redirecionamento de Paginas">
    /**
     * alterarComponenteCurricular é o método responsável pela alteração de um
     * componente curricular
     *
     * @param reg
     * @return form
     */
    public String alterar(ComponenteCurricular reg) {
        this.componente = reg;
        return "form";
    }

    public String alterar(int id) {
        this.componente = DAOComponenteCurricular.consultar(id);
        return "form";
    }

    /**
     * Método responsável por criar um objeto ComponenteCurricular e encaminhar
     * ao seu form.
     *
     * @return formComponenteCurricular
     */
    public String cadastrar() {
        this.componente = new ComponenteCurricular();
        return "form";
    }

    /**
     * Método responsável por listar todos os componentes curriculares
     * existentes.
     *
     * @return listaComponenteCurricular
     */
    public String listar() {
        return "/modules/componenteCurricular/lista";
    }
//</editor-fold>

}
