/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DAOComponenteCurricular;
import dao.DAOConcurso;
import dao.DAOCurso;
import dao.DAODocente;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eduardo Amaral
 */
@RequestScoped
@ManagedBean(name = "beanCount")
public class BeanCount {

    private int countComp;
    private int countDoc;
    private int countCur;
    private int countConc;

    public BeanCount() {
    }

    @PostConstruct
    public void init() {
        this.countComp = DAOComponenteCurricular.count();
        this.countDoc = DAODocente.count();
        this.countCur = DAOCurso.count();
        this.countConc = DAOConcurso.count();
    }

    public int getCountCur() {
        return countCur;
    }

    public void setCountCur(int countCur) {
        this.countCur = countCur;
    }

    public int getCountComp() {
        return countComp;
    }

    public void setCountComp(int countComp) {
        this.countComp = countComp;
    }

    public int getCountDoc() {
        return countDoc;
    }

    public void setCountDoc(int countDoc) {
        this.countDoc = countDoc;
    }

    public int getCountConc() {
        return countConc;
    }

    public void setCountConc(int countConc) {
        this.countConc = countConc;
    }
}
