/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOCurso;
import dao.DAOItemOferta;
import dao.DAOOferta;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ComponenteCurso;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.ItemOferta;
import model.Oferta;

/**
 * MontarOfertaBean é a classe responsável por montar a oferta das disciplinas
 * no sistema de gestão de oferta e horário.
 *
 * @author Luiz Paulo Franz
 */
@SessionScoped
@ManagedBean(name = "montarOfertaBean")
public class MontarOfertaBean {

    private ItemOferta itemOferta;
    private Oferta oferta;
    private Curso curso;
    private Map tabelas;
    private ComponenteCurso componenteCurso;

    @PostConstruct
    public void init() {
        componenteCurso = new ComponenteCurso();
    }

    /**
     * Método responsável por direcionar para a tela de montar ofertas.
     *
     * @return addInstrucoes
     */
    public String montarOferta() {
        this.tabelas = new LinkedHashMap();
        //verificamos se há cursos cadastrados.
        if (DAOCurso.consultar().isEmpty()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Impossível montar oferta. Você não tem cursos cadastrados.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            return "/modules/oferta/lista";
        } else if (this.curso == null) {
            this.curso = DAOCurso.consultar().get(0);
        }
        //montamos as tabelas de acordo com o semestre par ou impar
        DAOOferta dao = new DAOOferta();
        if (isSemestrePar()) {
            for (short i = 2; i <= this.curso.getNumeroDeSemestres(); i++) {
                tabelas.put(i, dao.getComponentesOfertados(this.curso, i, oferta));
                i++;
            }
        } else {
            for (short i = 1; i <= this.curso.getNumeroDeSemestres(); i++) {
                tabelas.put(i, dao.getComponentesOfertados(this.curso, i, oferta));
                i++;
            }
        }
        return "/modules/oferta/montarOferta";
    }

    /**
     * Método responsável por retornar apenas os cursos não ofertados.
     *
     * @param semestre
     * @return
     */
    public List<ComponenteCurso> getComponentesBySemestreAndCurso(Short semestre) {
        DAOOferta dao = new DAOOferta();
        return dao.getComponentesNaoOfertados(curso, semestre);
    }

    /**
     * Método responsável por adicionar um componente curricular a uma oferta.
     */
    public void addComponente() {
        this.itemOferta = new ItemOferta();
        this.itemOferta.setOferta(oferta);
        ComponenteCursoItemOferta ccif = new ComponenteCursoItemOferta();
        ccif.setComponenteCurso(componenteCurso);
        ccif.setItemOferta(itemOferta);
        //salvamos o item oferta e o componente curso item oferta
        DAOItemOferta.salvar(this.itemOferta);
        DAOItemOferta.salvar(ccif);
        this.montarOferta();
    }

    /**
     * Método responsável por adicionar todos os componetes de um semestre à
     * Oferta.
     * @param semestre
     */
    public void addComponenteBySemestre(short semestre) {
        DAOItemOferta dao = new DAOItemOferta();
        dao.salvarTodosPorSemestre(semestre, curso, oferta);
        this.montarOferta();
    }
    
    /**
     * Método responsável por adicionar todos os componetes listados à oferta
     * vigente.
     */
    public void addTodosComponentes() {
        DAOItemOferta dao = new DAOItemOferta();
        if (isSemestrePar()) {
            for (short i = 2; i <= this.curso.getNumeroDeSemestres(); i++) {
                dao.salvarTodosPorSemestre(i, curso, oferta);
                i++;
            }
        } else {
            for (short i = 1; i <= this.curso.getNumeroDeSemestres(); i++) {
                dao.salvarTodosPorSemestre(i, curso, oferta);
                i++;
            }
        }
        this.montarOferta();
    }
    
    /**
     * Método responsável por remover todos os componetes dessa oferta.
     */
    public void rmTodosComponentes() {
        DAOItemOferta dao = new DAOItemOferta();
        if (isSemestrePar()) {
            for (short i = 2; i <= this.curso.getNumeroDeSemestres(); i++) {
                dao.excluiTodosPorSemestre(i, curso);
                i++;
            }
        } else {
            for (short i = 1; i <= this.curso.getNumeroDeSemestres(); i++) {
                i++;
            }
        }
        this.montarOferta();
    }

    /**
     * Método responsável por remover um componente de uma oferta.
     *
     * @param ccio
     */
    public void rmComponente(ComponenteCursoItemOferta ccio) {
        //primeiro excluimos esse
        DAOItemOferta.excluir(ccio);
        DAOItemOferta.excluir(ccio.getItemOferta());
        this.montarOferta();
    }

    /**
     * Método responsável por identificar se o semestre é par ou não.
     *
     * @return boolean;
     */
    private boolean isSemestrePar() {
        byte semestre = (byte) this.oferta.getPeriodoLetivo().charAt(5);
        if (semestre % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public ItemOferta getItemOferta() {
        return itemOferta;
    }

    public void setItemOferta(ItemOferta itemOferta) {
        this.itemOferta = itemOferta;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Map getTabelas() {
        return this.tabelas;
    }

    public ComponenteCurso getComponenteCurso() {
        return componenteCurso;
    }

    public void setComponenteCurso(ComponenteCurso componenteCurso) {
        this.componenteCurso = componenteCurso;
    }

}
