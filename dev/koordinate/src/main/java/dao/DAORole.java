/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Jonas
 */
public class DAORole {

    /**
     * Método que realiza a persistência de um objeto Role
     *
     * @param r - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(Role r) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(r);
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
     * Método que realiza a busca de todos os objetos do tipo Role
     *
     * @return - Um ArrayList com todos os Roles recuperados no banco
     */
    public static ArrayList<Role> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Role> r = null;

        try {
            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Role as r");

            r = (ArrayList<Role>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
        return r;
    }

    /**
     * Método que busca um role específico pelo seu id
     *
     * @param id - identificador do role
     * @return - O role especificado
     */
    public static Role consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Role r = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Role as r where r.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                r = (Role) resultados.get(0);
            }

            return r;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return r;

        } finally {
            session.close();
        }
    }

    /**
     * Método utilizado para evitar o Lazy Inicialization Exception.
     *
     * @param id
     * @return Role
     */
    public static Role consultarWithJoin(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Role r = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Role as d LEFT JOIN fetch r.cursos as c LEFT JOIN fetch r.role where u.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                r = (Role) resultados.get(0);
            }
            return r;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return r;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar uma busca por roles com nome especifico
     *
     * @param nome - Nome a ser buscado
     * @return - Uma variavel boolean indicando se o salvamento foi bem sucedido
     */
    public static ArrayList<Role> consultar(String nome) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Role> r = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Role as r where r.nome=:nome");

            q.setParameter("nome", nome);

            r = (ArrayList<Role>) q.list();

            return r;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return r;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar a alteração de um objeto Role
     *
     * @param r - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(Role r) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(r);
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
     * Método responsável por excluir um registro referente a um objeto Role
     *
     * @param r - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean excluir(Role r) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(r);
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
     * Roles
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Criteria crit = session.createCriteria(Role.class);
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
