package model;
// Generated 27/09/2015 11:19:22 by Hibernate Tools 4.3.1

import dao.DAOComponenteCurricular;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * ComponenteCurricular generated by hbm2java
 */
@Entity
@SequenceGenerator(name = "componentecurricular_seq", sequenceName = "comp_seq_no_banco", allocationSize = 1, initialValue = 1)
@Table(name = "componente_curricular", schema = "public"
)
public class ComponenteCurricular implements java.io.Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private int id;
    private String cod;
    private int cargahoraria;
    private String nome;
    private String link;
    private boolean isativo;
    private int creditos;
    private Set preferencias = new HashSet(0);
    private Set instrucaoComponenteCurriculars = new HashSet(0);
    private Set componenteCursos = new HashSet(0);
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ComponenteCurricular() {
    }
    
    public ComponenteCurricular(int id, int cargahoraria, String nome, String link, boolean isativo, int creditos) {
        this.id = id;
        this.cargahoraria = cargahoraria;
        this.nome = nome;
        this.link = link;
        this.isativo = isativo;
        this.creditos = creditos;
    }
    
    public ComponenteCurricular(int id, String cod, int cargahoraria, String nome, String link, boolean isativo, int creditos, Set preferencias, Set instrucaoComponenteCurriculars, Set componenteCursos) {
        this.id = id;
        this.cod = cod;
        this.cargahoraria = cargahoraria;
        this.nome = nome;
        this.link = link;
        this.isativo = isativo;
        this.creditos = creditos;
        this.preferencias = preferencias;
        this.instrucaoComponenteCurriculars = instrucaoComponenteCurriculars;
        this.componenteCursos = componenteCursos;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    @Id
    @GeneratedValue(generator = "componentecurricular_seq")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "cod", length = 50, nullable = false)
    public String getCod() {
        return this.cod;
    }
    
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    @Column(name = "cargahoraria", nullable = false)
    public int getCargahoraria() {
        return this.cargahoraria;
    }
    
    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    
    @Column(name = "nome", nullable = false, length = 80)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "link", nullable = true, length = 100)
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    @Column(name = "isativo", nullable = false)
    public boolean isIsativo() {
        return this.isativo;
    }
    
    public void setIsativo(boolean isativo) {
        this.isativo = isativo;
    }
    
    @Column(name = "creditos", nullable = false)
    public int getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componenteCurricular")
    public Set<Preferencia> getPreferencias() {
        return this.preferencias;
    }
    
    public void setPreferencias(Set preferencias) {
        this.preferencias = preferencias;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componenteCurricular")
    public Set<InstrucaoComponenteCurricular> getInstrucaoComponenteCurriculars() {
        return this.instrucaoComponenteCurriculars;
    }
    
    public void setInstrucaoComponenteCurriculars(Set instrucaoComponenteCurriculars) {
        this.instrucaoComponenteCurriculars = instrucaoComponenteCurriculars;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componenteCurricular", cascade=CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Set<ComponenteCurso> getComponenteCursos() {
        return this.componenteCursos;
    }
    
    public void setComponenteCursos(Set componenteCursos) {
        this.componenteCursos = componenteCursos;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos Equals e HashCode">
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.cod);
        hash = 29 * hash + this.cargahoraria;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.link);
        hash = 29 * hash + (this.isativo ? 1 : 0);
        hash = 29 * hash + this.creditos;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComponenteCurricular other = (ComponenteCurricular) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Persistencia">
    static public boolean salvar(ComponenteCurricular c) {
        return DAOComponenteCurricular.salvar(c);
    }
    
    static public ArrayList<ComponenteCurricular> consultar() {
        return DAOComponenteCurricular.consultar();
    }
    
    static public ComponenteCurricular consultar(int id) {
        return DAOComponenteCurricular.consultar(id);
    }
    
    static public boolean alterar(ComponenteCurricular d) {
        return DAOComponenteCurricular.alterar(d);
    }
    
    static public boolean excluir(ComponenteCurricular d) {
        return DAOComponenteCurricular.excluir(d);
    }
    
    static public int count() {
        return DAOComponenteCurricular.count();
    }
//</editor-fold>

}
