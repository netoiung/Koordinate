package bean;

import dao.DAOComponenteCurricular;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ComponenteCurricular;

/**
 * ComponenteCurrilarBean é a classe responsável pelo CRUD do Componente
 * Curricular do sistema de gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */

@SessionScoped
@ManagedBean(name = "componenteCurricularBean")
public class ComponenteCurricularBean {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private ComponenteCurricular componente;
    private List<ComponenteCurricular> componentes;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        this.componente = new ComponenteCurricular();
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
        DAOComponenteCurricular dao = new DAOComponenteCurricular();
        this.componente = dao.consultarWithJoin(reg);
        return "/modules/componenteCurricular/consulta";
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
        //ajustamos a carga horaria
        componente.setCargahoraria(componente.getCreditos() * 15);
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
     * @return form
     */
    public String alterar(ComponenteCurricular reg) {
        DAOComponenteCurricular dao = new DAOComponenteCurricular();
        this.componente = dao.consultarWithJoin(reg);
        return "/modules/componenteCurricular/form";
    }

    public String alterarById(int id) {
        DAOComponenteCurricular dao = new DAOComponenteCurricular();
        this.componente = dao.consultarWithJoin(id);
        return "/modules/componenteCurricular/form";
    }

    /**
     * Método responsável por criar um objeto ComponenteCurricular e encaminhar
     * ao seu form.
     *
     * @return formComponenteCurricular
     */
    public String cadastrar() {
        this.componente = new ComponenteCurricular();
        return "/modules/componenteCurricular/formCadastrar";
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
