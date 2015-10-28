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
 * InstrucoesBean é a classe responsável pelas instrucoes das ofertas do
 * sistema de gestão de oferta e horário.
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
    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getDescricaoGeral() {
        return descricaoGeral;
    }

    public void setDescricaoGeral(String descricao) {
        this.descricaoGeral = descricao;
    }

    public String getDescricaoComponente() {
        return descricaoComponente;
    }

    public void setDescricaoComponente(String descricaoComponente) {
        this.descricaoComponente = descricaoComponente;
    }

    public String getDescricaoDocente() {
        return descricaoDocente;
    }

    public void setDescricaoDocente(String descricaoDocente) {
        this.descricaoDocente = descricaoDocente;
    }

    public ComponenteCurricular getComponente() {
        return componente;
    }

    public void setComponente(ComponenteCurricular componente) {
        this.componente = componente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

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

    public List<InstrucaoComponenteCurricular> getInstrucoesComp() {
        instrucoesComp = Instrucao.consultarComp();
        return instrucoesComp;
    }

    public List<InstrucaoDocente> getInstrucoesDoc() {
        instrucoesDoc = Instrucao.consultarDoc();
        return instrucoesDoc;
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    //</editor-fold>
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

    public void excluir(int id) {
        Instrucao.excluirId(id);
        getInstrucoes();
        getInstrucoesComp();
        getInstrucoesDoc();
        limparDescricoes();
    }

    public void limparDescricoes() {
        this.descricaoComponente = "";
        this.descricaoDocente = "";
        this.descricaoGeral = "";
    }

}
