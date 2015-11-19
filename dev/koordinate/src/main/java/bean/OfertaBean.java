/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOOferta;
import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.Docente;
import model.DocenteItemOferta;
import model.Oferta;

/**
 * OfertaBean é a classe responsável pela oferta do sistema de gestão de oferta
 * e horário.
 *
 * @author Eduardo Amaral
 */
@SessionScoped
@ManagedBean(name = "ofertaBean")
public class OfertaBean {

    //<editor-fold defaultstate="collapsed" desc="variaveis">
    private Oferta oferta;
    private ArrayList<Oferta> ofertas;
    private Curso curso;
    private ArrayList<ComponenteCursoItemOferta> ccif;
    private int id;
    private ArrayList<ComponenteCursoItemOferta> ccifsd;

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Oferta getOferta() {
        return oferta;
    }

    /**
     *
     * @param oferta
     */
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    /**
     *
     * @return
     */
    public ArrayList<Oferta> getOfertas() {
        this.ofertas = DAOOferta.consultar();
        return ofertas;
    }

    /**
     *
     * @param ofertas
     */
    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }



    public ArrayList<ComponenteCursoItemOferta> getCcif() {
        this.ccif = DAOOferta.getComponenteCursoItemOferta(curso, oferta);

        for (int i = 0; i < ccif.size(); i++) {
            for (int j = 1; j < ccif.size(); j++) {
                if (i != j && ccif.get(i).getId() == ccif.get(j).getId()) {
                    ccif.remove(ccif.get(j));
                }
            }
        }
        return ccif;
    }

    public void setCcif(ArrayList<ComponenteCursoItemOferta> ccif) {
        this.ccif = ccif;
    }

    public ArrayList<ComponenteCursoItemOferta> getCcifsd() {
        this.ccifsd = DAOOferta.getComponenteCursoItemOfertaSemDocente(oferta);
        return ccifsd;
    }

    public void setCcifsd(ArrayList<ComponenteCursoItemOferta> ccifsd) {
        this.ccifsd = ccifsd;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init">
    /**
     * Método inicializador de variaveis
     *
     */
    @PostConstruct
    public void init() {
        this.oferta = new Oferta();
        getCcifsd();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CRUD">
    /**
     * consultar é o método responsável pela consulta de uma oferta
     *
     * @param reg
     * @return endereco para pagina de consulta
     */
    public String consultar(Oferta reg) {
        this.oferta = DAOOferta.consultar(reg.getId());
        this.curso = new Curso();
        return "/modules/oferta/monitorarOferta";
    }

    /**
     * excluirC é o método usado para excluir uma oferta
     *
     * @param reg
     */
    public void excluir(Oferta reg) {
        this.oferta = reg;
        if (Oferta.excluir(this.oferta)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro excluído com sucesso.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível excluir o registro, por favor tente novamente.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        this.listar();
    }

    /**
     * Método responsável por persistir um objeto Oferta e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        try {
            if (Oferta.salvar(this.oferta)) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registro salvo com sucesso.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Não foi possível salvar, por favor tente novamente.");
                FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            }
        } catch (PeriodoLetivoException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
        }
        return "/modules/oferta/lista";
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Redirecionamento de Paginas">
    /**
     * alterar é o método responsável pela alteração de uma oferta
     *
     * @param reg
     * @return formulario de edição de oferta
     */
    public String alterar(Oferta reg) {
        this.oferta = reg;
        return "/modules/oferta/form";
    }

    /**
     * Método responsável por criar um objeto Oferta e encaminhar ao seu form.
     *
     * @return formOferta
     */
    public String cadastrar() {
        this.oferta = new Oferta();
        return "/modules/oferta/form";
    }

    /**
     * Método responsável por listar todas as ofertas existentes.
     *
     * @return listaComponenteCurricular
     */
    public String listar() {
        return "/modules/oferta/lista";
    }

    /**
     * Método responsável por direcionar para a tela de acrescentar instrucoes
     *
     * @return addInstrucoes
     */
    public String addInstrucao() {
        return "/modules/oferta/addInstrucoes";
    }
//</editor-fold>

    public int retornaCreditosDocenteItemOfertas(int id) {
        int creditos = 0;
        this.id = id;
        for (ComponenteCursoItemOferta dio : ccif) {
            if (dio.getId() == id) {
                Iterator<DocenteItemOferta> iter = dio.getItemOferta().getDocenteItemOfertas().iterator();

                while (iter.hasNext()) {
                    DocenteItemOferta docIt = new DocenteItemOferta();
                    docIt = iter.next();
                    creditos += docIt.getCreditos();
                }

            }
        }
        return creditos;
    }

    public ArrayList<DocenteItemOferta> retornaDocenteItemOfertas(int id) {

        getCcif();
        for (ComponenteCursoItemOferta dio : ccif) {
            if (dio.getId() == id) {
                return new ArrayList<DocenteItemOferta>(dio.getItemOferta().getDocenteItemOfertas());
            }
        }
        return null;
    }

    public String finalizarOferta() {
        this.oferta.setAtivo(false);
        this.salvar();
        return "index";
    }


    
}
