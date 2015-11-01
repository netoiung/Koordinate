package model;
// Generated 27/09/2015 11:19:22 by Hibernate Tools 4.3.1

import dao.DAOConcurso;
import dao.DAODocente;
import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Concurso generated by hbm2java
 */
@Entity
@SequenceGenerator(name = "concurso_seq", sequenceName = "concurso_seq_no_banco", allocationSize = 1, initialValue = 1)
@Table(name = "concurso", schema = "public"
)
public class Concurso implements java.io.Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private int id;
    private String edital;
    private String area;
    private String programa;
    private Set docentes = new HashSet(0);
//</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Concurso() {
    }
    


//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters e setters">
    @Id
    @GeneratedValue(generator = "concurso_seq")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "edital", nullable = false, length = 50)
    public String getEdital() {
        return this.edital;
    }
    
    public void setEdital(String edital) {
        this.edital = edital;
    }
    
    @Column(name = "area", nullable = false, length = 50)
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    @Column(name = "programa", nullable = false, length = 50)
    public String getPrograma() {
        return this.programa;
    }
    
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "concurso")
    public Set<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Set docentes) {
        this.docentes = docentes;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos de Equals e HashCode">
    
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 43 * hash + this.id;
//        hash = 43 * hash + Objects.hashCode(this.edital);
//        hash = 43 * hash + Objects.hashCode(this.area);
//        hash = 43 * hash + Objects.hashCode(this.programa);
//        hash = 43 * hash + Objects.hashCode(this.docentes);
//        return hash;
//    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Concurso other = (Concurso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.edital, other.edital)) {
            return false;
        }
        return true;
    }
    
//</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc="Metodos de Persistencia">
    static public boolean salvar(Concurso c) {
        return DAOConcurso.salvar(c);
    }
    
    static public ArrayList<Concurso> consultar() {
        return DAOConcurso.consultar();
    }
    
    static public Concurso consultar(int id) {
        return DAOConcurso.consultar(id);
    }
    
    static public boolean alterar(Concurso d) {
        return DAOConcurso.alterar(d);
    }
    
    static public boolean excluir(Concurso d) throws IntegridadeReferencialException {
        return DAOConcurso.excluir(d);
    }
    
    static public int count() {
        return DAOConcurso.count();
    }
    
    
//</editor-fold>
}
