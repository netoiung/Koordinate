/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Instrucao;
import model.InstrucaoComponenteCurricular;
import model.InstrucaoDocente;
import model.Oferta;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsável pela persistência dos objetos Instrucao
 * @author Eduardo Amaral
 */
public class DAOInstrucao {

    /**
     * Método que realiza a persistência de um objeto Instrucao
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(Instrucao c) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

    }

    /**
     * Método que realiza a busca de todos os objetos do tipo Instrucao
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<Instrucao> consultarGeral() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Instrucao> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Instrucao as c");

            c = (ArrayList<Instrucao>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que realiza a busca de todos os objetos do tipo InstrucaoComponenteCurricular
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<InstrucaoComponenteCurricular> consultarComp() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<InstrucaoComponenteCurricular> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM InstrucaoComponenteCurricular as c");

            c = (ArrayList<InstrucaoComponenteCurricular>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que realiza a busca de todos os objetos do tipo InstrucaoDocente
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<InstrucaoDocente> consultarDoc() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<InstrucaoDocente> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM InstrucaoDocente as c");

            c = (ArrayList<InstrucaoDocente>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que busca uma instrucao específica pelo seu id
     *
     * @param id - identificador do concurso
     * @return - O concurso especificado
     */
    public static Instrucao consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Instrucao c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Instrucao as c where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (Instrucao) resultados.get(0);
            }

            return c;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return c;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar a alteração de um objeto Instrucao
     *
     * @param c - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(Instrucao c) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por excluir um registro referente a um objeto Instrucao
     *
     * @param d - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean excluir(Instrucao d) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(d);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por mostrar a quantidade de registros na tabela de
     * Oferta
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Criteria crit = session.createCriteria(Instrucao.class);
            crit.setProjection(Projections.rowCount());
            Long l = (Long) crit.list().get(0);

            return Integer.valueOf(l.toString());

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }
}
