/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ComponenteCurricular;
import model.Docente;
import model.Instrucao;
import model.InstrucaoComponenteCurricular;
import model.InstrucaoDocente;
import model.Oferta;

/**
 * InstrucoesBean Ã© a classe responsÃ¡vel pelas instrucoes das ofertas do
 * sistema de gestÃ£o de oferta e horÃ¡rio.
 *
 * @author Eduardo Amaral
 */
@SessionScoped
@ManagedBean(name = "instrucoesBean")
public class InstrucoesBean {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private Instrucao instrucao;
    private Oferta oferta;
    private String descricaoGeral;
    private String descricaoComponente;
    private String descricaoDocente;
    private ComponenteCurricular componente;
    private Docente docente;
    private List<Instrucao> instrucoes;
    private List<InstrucaoComponenteCurricular> instrucoesComp;
    private List<InstrucaoDocente> instrucoesDoc;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    /**
     * Método responsável por recuperar o valor do atributo oferta
     *
     * @return Oferta setada atualmente
     */
    public Oferta getOferta() {
        return oferta;
    }

    /**
     * Método responsável por atualizar o valor da variável oferta
     *
     * @param oferta - Novo valor de oferta
     */
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    /**
     * Método responsável por recuperar o valor do atributo descricaoGeral
     *
     * @return DescricaoGeral setada atualmente
     */
    public String getDescricaoGeral() {
        return descricaoGeral;
    }

    /**
     * Método responsável por atualizar o valor da variável descricaoGeral
     *
     * @param descricao - Novo valor de descricaoGeral
     */
    public void setDescricaoGeral(String descricao) {
        this.descricaoGeral = descricao;
    }

    /**
     * Método responsável por recuperar o valor do atributo descricaoComponente
     *
     * @return descricaoComponente setada atualmente
     */
    public String getDescricaoComponente() {
        return descricaoComponente;
    }

    /**
     * Método responsável por atualizar o valor da variável descricaoComponente
     *
     * @param descricaoComponente - Novo valor de descricaoComponente
     */
    public void setDescricaoComponente(String descricaoComponente) {
        this.descricaoComponente = descricaoComponente;
    }

    /**
     * Método responsável por recuperar o valor do atributo descricaoDocente
     *
     * @return descricaoDocente setada atualmente
     */
    public String getDescricaoDocente() {
        return descricaoDocente;
    }

    /**
     * Método responsável por atualizar o valor da variável descricaoDocente
     *
     * @param descricaoDocente - Novo valor de descricaoDocente
     */
    public void setDescricaoDocente(String descricaoDocente) {
        this.descricaoDocente = descricaoDocente;
    }

    /**
     * Método responsável por recuperar o valor do atributo componente
     *
     * @return componente setada atualmente
     */
    public ComponenteCurricular getComponente() {
        return componente;
    }

    /**
     * Método responsável por atualizar o valor da variável componente
     *
     * @param componente - Novo valor de componente
     */
    public void setComponente(ComponenteCurricular componente) {
        this.componente = componente;
    }

    /**
     * Método responsável por recuperar o valor do atributo docente
     *
     * @return docente setada atualmente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Método responsável por atualizar o valor da variável docente
     *
     * @param docente - Novo valor de docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Método responsável por recuperar a lista de instruções gerais salvas no
     * banco
     *
     * @return Instruções Gerais
     */
    public List<Instrucao> getInstrucoes() {
        instrucoes = new ArrayList<>();
        List<Instrucao> instrucoesDB = Instrucao.consultarGeral();
        for (Instrucao instrucoesDB1 : instrucoesDB) {
            if (instrucoesDB1.getInstrucaoDocentes().isEmpty() && instrucoesDB1.getInstrucaoComponenteCurriculars().isEmpty()) {
                instrucoes.add(instrucoesDB1);
            }
        }
        return instrucoes;
    }

    /**
     * Método responsável por recuperar a lista de instruções componente
     * curricular salvas no banco
     *
     * @return Instruções componente curricular
     */
    public List<InstrucaoComponenteCurricular> getInstrucoesComp() {
        instrucoesComp = Instrucao.consultarComp();
        return instrucoesComp;
    }

    /**
     * Método responsável por recuperar a lista de instruções docente salvas no
     * banco
     *
     * @return Instruções Docente
     */
    public List<InstrucaoDocente> getInstrucoesDoc() {
        instrucoesDoc = Instrucao.consultarDoc();
        return instrucoesDoc;
    }

    /**
     * Método responsável por recuperar o valor do atributo oferta
     *
     * @return Oferta setada atualmente
     */
    public Instrucao getInstrucao() {
        return instrucao;
    }

    /**
     * Método responsável por atualizar o valor da variável instrucao
     *
     * @param instrucao - Novo valor de instrucao
     */
    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * Método responsável por salvar uma instrução geral
     */
    public void salvarGeral() {
        this.instrucao = new Instrucao();
        this.instrucao.setDescricao(descricaoGeral);
        this.instrucao.setOferta(oferta);
        Instrucao.salvar(instrucao);
        getInstrucoes();
        getInstrucoesComp();
        getInstrucoesDoc();
        limparDescricoes();
        
    }
    
    /**
     * Método responsável por salvar uma instrução ligada a um componente curricular
     */
    public void salvarComp() {
        this.instrucao = new Instrucao();
        this.instrucao.setDescricao(descricaoComponente);
        this.instrucao.setOferta(oferta);
        Instrucao.salvar(instrucao);
        InstrucaoComponenteCurricular inst = new InstrucaoComponenteCurricular();
        inst.setComponenteCurricular(componente);
        inst.setInstrucao(instrucao);
        this.instrucao.getInstrucaoComponenteCurriculars().add(inst);
        Instrucao.salvar(instrucao);
        getInstrucoes();
        getInstrucoesComp();
        getInstrucoesDoc();
        limparDescricoes();
        
    }
    
    /**
     * Método responsável por salvar uma instrução ligada a um docente
     */
    public void salvarDoc() {
        this.instrucao = new Instrucao();
        this.instrucao.setDescricao(descricaoDocente);
        this.instrucao.setOferta(oferta);
        Instrucao.salvar(instrucao);
        InstrucaoDocente inst = new InstrucaoDocente();
        inst.setDocente(docente);
        inst.setInstrucao(instrucao);
        this.instrucao.getInstrucaoDocentes().add(inst);
        Instrucao.alterar(instrucao);
        getInstrucoes();
        getInstrucoesComp();
        getInstrucoesDoc();
        limparDescricoes();
    }
    
    /** Método responsável por excluir uma instrucao
     *
     * @param id - Identificador da instrucao a ser excluida
     */
    public void excluir(int id) {
        Instrucao.excluirId(id);
        getInstrucoes();
        getInstrucoesComp();
        getInstrucoesDoc();
        limparDescricoes();
    }
//</editor-fold>

    /** Limpar os campos de descricao
     *
     */
    public void limparDescricoes() {
        this.descricaoComponente = "";
        this.descricaoDocente = "";
        this.descricaoGeral = "";
    }

}
