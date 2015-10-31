/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOCurso;
import dao.DAOOferta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
        
    /**
     * Método responsável por direcionar para a tela de montar ofertas.
     *
     * @return addInstrucoes
     */
    public String montarOferta() {
        this.tabelas = new HashMap();
        //verificamos se há cursos cadastrados.
        if(DAOCurso.consultar().isEmpty()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Impossível montar oferta. Você não tem cursos cadastrados.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            return "/modules/oferta/lista";
        }else if(this.curso == null){
            this.curso = DAOCurso.consultar().get(0);
        }
        //montamos as tabelas de acordo com o semestre par ou impar
        DAOOferta dao = new DAOOferta();
        if(isSemestrePar()){
            tabelas.put("2", dao.getComponentes(this.curso, Short.valueOf("2")));
            tabelas.put("4", dao.getComponentes(this.curso, Short.valueOf("4")));
            tabelas.put("6", dao.getComponentes(this.curso, Short.valueOf("6")));
            tabelas.put("8", dao.getComponentes(this.curso, Short.valueOf("8")));
            tabelas.put("10", dao.getComponentes(this.curso, Short.valueOf("10")));
        } else {
            tabelas.put("1", dao.getComponentes(this.curso, Short.valueOf("1")));
            tabelas.put("3", dao.getComponentes(this.curso, Short.valueOf("3")));
            tabelas.put("5", dao.getComponentes(this.curso, Short.valueOf("5")));
            tabelas.put("7", dao.getComponentes(this.curso, Short.valueOf("7")));
            tabelas.put("9", dao.getComponentes(this.curso, Short.valueOf("9")));
        }
        return "/modules/oferta/montarOferta";
    }
    
    /**
     * Método responsável por identificar se o semestre é par ou não.
     * @return boolean;
     */
    private boolean isSemestrePar(){
        //System.out.println("??????");
        //System.out.println(this.oferta.getPeriodoLetivo());
        //System.out.println(this.oferta.getPeriodoLetivo().charAt(5));
        byte semestre = (byte) this.oferta.getPeriodoLetivo().charAt(5);
        if (semestre % 2 == 0) {
            return true;
        }else{
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
    
    public Map getTabelas(){
        return this.tabelas;
    }
}
