/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOCurso;
import dao.DAOItemOferta;
import dao.DAOOferta;
import java.util.ArrayList;
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
    private Map tabelasObrigatorias; //tabelas de disciplinas obrigatorias
    private Map tabelasComplementares; //tabelas de disciplinas complementares
    private ComponenteCurso componenteCurso;
    private boolean exibe;
    private ArrayList<Curso> cursos;

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    @PostConstruct
    public void init() {
        componenteCurso = new ComponenteCurso();
    }

    /**
     * Método responsável por direcionar para a tela de montar ofertas.
     *
     * @return String
     */
    public String montarOferta() {
        this.tabelasObrigatorias = new LinkedHashMap();
        this.tabelasComplementares = new LinkedHashMap();
        //verificamos se há cursos cadastrados.
        if (DAOCurso.consultar().isEmpty()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Impossível montar oferta. Você não tem cursos cadastrados.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            return "/modules/oferta/lista";
        } else if (this.curso == null) {
            this.curso = DAOCurso.consultar().get(0);
        }
        //montamos as tabelas de acordo com o semestre par ou impar
        //listamos apenas os componentes que já estão na oferta
        DAOOferta dao = new DAOOferta();
        if (isSemestrePar()) {
            for (short i = 2; i <= this.curso.getNumeroDeSemestres(); i++) {
                //o true indica retorna apenas as diciplinas obrigatorias
                tabelasObrigatorias.put(i, dao.getComponentesOfertados(curso, i, oferta, true));
                tabelasComplementares.put(i, dao.getComponentesOfertados(curso, i, oferta, false));
                i++;
            }
        } else {
            for (short i = 1; i <= this.curso.getNumeroDeSemestres(); i++) {
                tabelasObrigatorias.put(i, dao.getComponentesOfertados(this.curso, i, oferta, true));
                tabelasComplementares.put(i, dao.getComponentesOfertados(curso, i, oferta, false));
                i++;
            }
        }
        exibe = false;
        return "/modules/oferta/montarOferta";
    }

    /**
     * Método responsável por retornar apenas os cursos não ofertados.
     *
     * @param semestre
     * @param obrigatorio
     * @return
     */
    public List<ComponenteCurso> getComponentesBySemestreAndCurso(Short semestre, boolean obrigatorio) {
        DAOOferta dao = new DAOOferta();
        return dao.getComponentesNaoOfertados(curso, semestre, oferta, obrigatorio);
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
        DAOItemOferta.salvar(this.itemOferta);

        for (Curso curso1 : cursos) {
            ComponenteCurso compCurso = new ComponenteCurso();
            compCurso = DAOOferta.getComponenteCursos(componenteCurso.getComponenteCurricular(), curso1).get(0);
            ComponenteCursoItemOferta ccif2 = new ComponenteCursoItemOferta();
            ccif2.setComponenteCurso(compCurso);
            ccif2.setItemOferta(itemOferta);
            DAOItemOferta.salvar(ccif2);
        }
        //salvamos o item oferta e o componente curso item oferta
        DAOItemOferta.salvar(this.itemOferta);
        DAOItemOferta.salvar(ccif);
        this.montarOferta();
    }

    /**
     * Método responsável por adicionar todos os componetes (obrigatorios ou
     * não) de um semestre à Oferta.
     *
     * @param semestre
     * @param obrigatorio
     */
    public void addComponenteBySemestre(short semestre, boolean obrigatorio) {
        DAOItemOferta dao = new DAOItemOferta();
        dao.salvarTodosPorSemestre(semestre, curso, oferta, obrigatorio);
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
                //esse metodo ignora a obrigatoriedade, removo todos
                dao.excluiTodosPorSemestre(i, curso, oferta);
                i++;
            }
        } else {
            for (short i = 1; i <= this.curso.getNumeroDeSemestres(); i++) {
                dao.excluiTodosPorSemestre(i, curso, oferta);
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
        DAOItemOferta.excluir(ccio.getItemOferta());
        this.montarOferta();
    }

    public List<Curso> buscarCursos() {
        return DAOOferta.getCursos(componenteCurso);
    }

    /**
     * Método responsável por remover todos os componetes de um semestre.
     *
     * @param semestre
     * @param obrigatoria
     */
    public void rmComponenteBySemestre(short semestre, boolean obrigatoria) {
        DAOItemOferta dao = new DAOItemOferta();
        dao.excluiTodosPorSemestre(semestre, curso, oferta, obrigatoria);
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

    public Map getTabelasObrigatorias() {
        return this.tabelasObrigatorias;
    }

    public Map getTabelasComplementares() {
        return this.tabelasComplementares;
    }

    public ComponenteCurso getComponenteCurso() {
        return componenteCurso;
    }

    public void setComponenteCurso(ComponenteCurso componenteCurso) {
        this.componenteCurso = componenteCurso;
    }

    public boolean isExibe() {
        return exibe;
    }

    public void setExibe(boolean exibe) {
        this.exibe = exibe;
    }

    public void exibe() {
        exibe = !exibe;
    }

    public void test() {
        this.cursos.hashCode();
    }

}
