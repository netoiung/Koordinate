package model;
// Generated 27/09/2015 11:19:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ComponenteCurso generated by hbm2java
 */
@Entity
@SequenceGenerator(name = "componentecurso_seq", sequenceName = "componentecurso_seq_no_banco", allocationSize = 1, initialValue = 1)
@Table(name = "componente_curso", schema = "public"
)
public class ComponenteCurso implements java.io.Serializable {

    private int id;
    private ComponenteCurricular componenteCurricular;
    private Curso curso;
    private boolean obrigatoria;
    private short semestre;
    private Set componenteCursoItemOfertas = new HashSet(0);

    public ComponenteCurso() {
    }

    @Id
    @GeneratedValue(generator = "componentecurso_seq")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "componente_curricular_id", nullable = false)
    public ComponenteCurricular getComponenteCurricular() {
        return this.componenteCurricular;
    }

    public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Column(name = "obrigatoria", nullable = false)
    public boolean isObrigatoria() {
        return this.obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    @Column(name = "semestre", nullable = false)
    public short getSemestre() {
        return this.semestre;
    }

    public void setSemestre(short semestre) {
        this.semestre = semestre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "componenteCurso")
    public Set<ComponenteCursoItemOferta> getComponenteCursoItemOfertas() {
        return this.componenteCursoItemOfertas;
    }

    public void setComponenteCursoItemOfertas(Set componentecursoitemofertas) {
        this.componenteCursoItemOfertas = componentecursoitemofertas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.obrigatoria ? 1 : 0);
        hash = 79 * hash + this.semestre;
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
        final ComponenteCurso other = (ComponenteCurso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.obrigatoria != other.obrigatoria) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        return true;
    }
    
    

}