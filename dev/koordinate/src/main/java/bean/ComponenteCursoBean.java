package bean;

import dao.DAOComponenteCurso;
import javax.annotation.PostConstruct;
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

    private ComponenteCurso componenteCurso;
    private ComponenteCurricular componenteCurricular;
    private Curso curso;
    private boolean obrigatoria;
    private short semestre;
    
    
    @PostConstruct
    public void init() {
        this.componenteCurso = new ComponenteCurso();
    }
    
    /**
     * Adicionamos um curso para ofertar esse componente curricular.
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
        }
        //direcionamos devolta para a outra bean, devolta para a edicao do componente
        beanComponenteCurricular.alterarById(componenteCurricular.getId());
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
        beanComponenteCurricular.alterarById(componenteCurricular.getId());
    }

    public ComponenteCurricular getComponenteCurricular() {
        return componenteCurricular;
    }

    public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }
    
    public void setarComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    public short getSemestre() {
        return semestre;
    }

    public void setSemestre(short semestre) {
        this.semestre = semestre;
    }
}
