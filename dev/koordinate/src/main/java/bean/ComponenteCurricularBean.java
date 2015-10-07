package bean;

import dao.DAOComponenteCurricular;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.ComponenteCurricular;

/**
 * ComponenteCurrilarBean é a classe responsável pelo CRUD do Componente
 * Curricular do sistema de gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */
//tem que aprender a lidar com esse scopo
@ViewScoped
//@SessionScoped
@ManagedBean(name = "componenteCurricularBean")
public class ComponenteCurricularBean {

    private ComponenteCurricular componente;
    private List<ComponenteCurricular> componentes;

    public ComponenteCurricular getComponente() {
        return componente;
    }

    public void setComponente(ComponenteCurricular componente) {
        this.componente = componente;
    }

    public List<ComponenteCurricular> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<ComponenteCurricular> componentes) {
        this.componentes = componentes;
    }

    /**
     * método construtor da classe ComponenteCurricularBean.
     */
    public ComponenteCurricularBean() {
        this.componente = new ComponenteCurricular();
    }

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
     * Método responsável por listar todos os componentes curriculares
     * existentes.
     *
     * @return listaComponenteCurricular
     */
    public String listaComponentes() {
        return "/modules/componenteCurricular/lista";
    }

}
