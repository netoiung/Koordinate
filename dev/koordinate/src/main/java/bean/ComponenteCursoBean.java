package bean;

import dao.DAOComponenteCurso;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.ComponenteCurricular;
import model.ComponenteCurso;
import model.Curso;

/**
 * Essa bean eh uma bean auxiliar da componenteCurricularBean, sendo responsável
 * unicamente por adicionar e remover cursos de uma oferta.
 *
 * ESSA BEAN É DEPENDENTE DA BEAN DE COMPONENTE CURRICULAR!
 *
 * @author Luiz Paulo Franz
 */
@RequestScoped
@ManagedBean(name = "componenteCursoBean")
public class ComponenteCursoBean {

    //<editor-fold defaultstate="collapsed" desc="variaveis">
    private ComponenteCurso componenteCurso;
    private ComponenteCurricular componenteCurricular;
    private Curso curso;
    private boolean obrigatoria;
    private short semestre;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="init">
    /** Método iniciador das variáveis
     *
     */
    @PostConstruct
    public void init() {
        this.componenteCurso = new ComponenteCurso();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    /** Método responsável por recuperar o valor de componenteCurricular
     *
     * @return O componente curricular setado atualmente
     */
    public ComponenteCurricular getComponenteCurricular() {
        return componenteCurricular;
    }
    
    /**
     *
     * @param componenteCurricular
     */
    public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }
    
    /**
     *
     * @param componenteCurricular
     */
    public void setarComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }
    
    /** Método responsável por recuperar o valor de curso
     *
     * @return O curso setado atualmente
     */
    public Curso getCurso() {
        return curso;
    }
    
    /**
     *
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    /** Método responsável por recuperar o valor de obrigatoria
     *
     * @return A obrigatoriedade setada atualmente
     */
    public boolean isObrigatoria() {
        return obrigatoria;
    }
    
    /**
     *
     * @param obrigatoria
     */
    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }
    
    /** Método responsável por recuperar o valor de semestre
     *
     * @return O semestre setado atualmente
     */
    public short getSemestre() {
        return semestre;
    }
    
    /**
     *
     * @param semestre
     */
    public void setSemestre(short semestre) {
        this.semestre = semestre;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="metodos">
    /**
     * Método responsável por adicionar um curso para ofertar esse componente curricular.
     *
     */
    public void addCurso() {
        ComponenteCurricularBean beanComponenteCurricular = (ComponenteCurricularBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("componenteCurricularBean");
        //pegamos o componente curricular setado na outra bean
        componenteCurricular = beanComponenteCurricular.getComponente();
        componenteCurso.setComponenteCurricular(componenteCurricular);
        componenteCurso.setCurso(curso);
        componenteCurso.setSemestre(semestre);
        componenteCurso.setObrigatoria(obrigatoria);
        ComponenteCurso temp = DAOComponenteCurso.consultar(componenteCurso);
        //nao inserimos novamento um mesmo componente curso
        if (temp == null) {
            DAOComponenteCurso.salvar(componenteCurso);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Componente adicionado a oferta do curso com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Esse componente já é ofertado no curso escolhido, por favor, escolha outro curso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        //direcionamos devolta para a outra bean, devolta para a edicao do componente
        beanComponenteCurricular.consultarById(componenteCurricular.getId());
    }
    
    /**
     * Removemos o curso da oferta deste componente curricular.
     *
     * @param reg Curso
     */
    public void removerCurso(ComponenteCurso reg) {
        //excluimos o registro
        componenteCurricular = reg.getComponenteCurricular();
        DAOComponenteCurso.excluir(reg);
        //recuperamos a bean de componente curricular
        ComponenteCurricularBean beanComponenteCurricular = (ComponenteCurricularBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("componenteCurricularBean");
        //direcionamos devolta para a outra bean, devolta para a edicao do componente
        beanComponenteCurricular.consultarById(componenteCurricular.getId());
    }
//</editor-fold>
}
