/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOCurso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
@ManagedBean(name = "montarOfertaBean")
public class MontarOfertaBean {

    private ItemOferta itemOferta;
    private Oferta oferta;
    private Curso curso;
        
    /**
     * Método responsável por direcionar para a tela de montar ofertas.
     *
     * @return addInstrucoes
     */
    public String montarOferta() {
        //verificamos se há cursos cadastrados.
        if(DAOCurso.consultar().isEmpty()){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Impossível montar oferta. Você não tem cursos cadastrados.");
            FacesContext.getCurrentInstance().addMessage("mensagens", fm);
            return "/modules/oferta/lista";
        }else if(this.curso == null){
            this.curso = DAOCurso.consultar().get(0);
        }
        return "/modules/oferta/montarOferta";
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
}
