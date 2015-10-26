/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOOferta;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ComponenteCurricular;
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public ArrayList<Oferta> getOfertas() {
        this.ofertas = DAOOferta.consultar();
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        this.oferta = new Oferta();
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
        return "/modules/oferta/consulta";
    }

    /**
     * excluirC é o método usado para excluir uma oferta
     *
     * @param reg
     */
    public void excluir(Oferta reg) {
        this.oferta = reg;
        Oferta.excluir(this.oferta);
        this.listar();
    }

    /**
     * Método responsável por persistir um objeto Oferta e encaminhar ao seu
     * form.
     *
     * @return String
     */
    public String salvar() {
        System.out.println("aaaa"+oferta.getInicio());
        Oferta.salvar(this.oferta);
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
    public String alterar(ComponenteCurricular reg) {
        this.oferta = Oferta.consultar(reg.getId());
        return "/modules/oferta/form";
    }


    /**
     * Método responsável por criar um objeto Oferta e encaminhar
     * ao seu form.
     *
     * @return formOferta
     */
    public String cadastrar() {
        this.oferta = new Oferta();
        return "/modules/oferta/formCadastrar";
    }

    /**
     * Método responsável por listar todas as ofertas
     * existentes.
     *
     * @return listaComponenteCurricular
     */
    public String listar() {
        return "/modules/oferta/lista";
    }
//</editor-fold>

}
