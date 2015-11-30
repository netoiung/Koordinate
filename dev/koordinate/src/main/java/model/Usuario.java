/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.security.Principal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 *
 * @author Jonas Chagas
 */
@Entity
@Table
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(unique = true)
    @NotNull
    private String email;

    @Column
    @NotNull
    private String senha;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_docente", referencedColumnName = "id")
    private Docente docente;

    @Column
    private boolean b_admin;

    @Column
    private boolean b_coordAcad;

    @Column
    private boolean b_coordCurso;

    @Column
    private boolean b_docente;

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
//    @JoinColumn(name = "id_roleAdmin", referencedColumnName = "id")
//    private Role roleAdmin;
//
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
//    @JoinColumn(name = "id_roleCoordAcad", referencedColumnName = "id")
//    private Role roleCoordAcad;
//
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
//    @JoinColumn(name = "id_roleCoordCurso", referencedColumnName = "id")
//    private Role roleCoordCurso;
//
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
//    @JoinColumn(name = "id_roleDocente", referencedColumnName = "id")
//    private Role roleDocente;

    
    public Usuario() {
        
        this.docente = new Docente();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the docente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param password the password to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the b_admin
     */
    public boolean isB_admin() {
        return b_admin;
    }

    /**
     * @param b_admin the b_admin to set
     */
    public void setB_admin(boolean b_admin) {
        this.b_admin = b_admin;
    }

    /**
     * @return the b_coordAcad
     */
    public boolean isB_coordAcad() {
        return b_coordAcad;
    }

    /**
     * @param b_coordAcad the b_coordAcad to set
     */
    public void setB_coordAcad(boolean b_coordAcad) {
        this.b_coordAcad = b_coordAcad;
    }

    /**
     * @return the b_coordCurso
     */
    public boolean isB_coordCurso() {
        return b_coordCurso;
    }

    /**
     * @param b_coordCurso the b_coordCurso to set
     */
    public void setB_coordCurso(boolean b_coordCurso) {
        this.b_coordCurso = b_coordCurso;
    }

    /**
     * @return the b_docente
     */
    public boolean isB_docente() {
        return b_docente;
    }

    /**
     * @param b_docente the b_docente to set
     */
    public void setB_docente(boolean b_docente) {
        this.b_docente = b_docente;
    }

}
