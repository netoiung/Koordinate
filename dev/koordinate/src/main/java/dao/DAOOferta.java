/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.List;
import model.Oferta;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsável pela persistência dos objetos Oferta
 *
 * @author Eduardo Amaral
 */
public class DAOOferta {

    /**
     * Método que realiza a persistência de um objeto Oferta
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     * @throws excecoes.PeriodoLetivoException
     */
    public static boolean salvar(Oferta c) throws PeriodoLetivoException {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Oferta temp = consultar(c.getPeriodoLetivo());
        if (temp != null) {
            throw new PeriodoLetivoException();
        }

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
     * Método que realiza a busca de todos os objetos do tipo Oferta
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<Oferta> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Oferta> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Oferta as c");

            c = (ArrayList<Oferta>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que busca um concurso específico pelo seu id
     *
     * @param id - identificador do concurso
     * @return - O concurso especificado
     */
    public static Oferta consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Oferta c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Oferta as c where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (Oferta) resultados.get(0);
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
     * Método que busca um concurso específico pelo seu periodo.
     *
     * @param periodo - periodo letivo
     * @return - O concurso especificado
     */
    public static Oferta consultar(String periodo) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Oferta c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Oferta as o where o.periodoLetivo=:periodo");

            q.setParameter("periodo", periodo);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (Oferta) resultados.get(0);
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
     * Método responsável por realizar a alteração de um objeto Oferta
     *
     * @param c - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(Oferta c) {
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
     * Método responsável por excluir um registro referente a um objeto Oferta
     *
     * @param d - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean excluir(Oferta d) {
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

            Criteria crit = session.createCriteria(Oferta.class);
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
