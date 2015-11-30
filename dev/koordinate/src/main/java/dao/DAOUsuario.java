/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excecoes.IntegridadeReferencialException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jonas
 */
public class DAOUsuario {

    /**
     * Método que realiza a persistência de um objeto Usuario
     *
     * @param u - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(Usuario u) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(u);
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
     * Método que realiza a busca de todos os objetos do tipo Usuario
     *
     * @return - Um ArrayList com todos os Usuarios recuperados no banco
     */
    public static ArrayList<Usuario> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Usuario> u = null;

        try {
            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Usuario as u");

            u = (ArrayList<Usuario>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
        return u;
    }

    /**
     * Método que busca um usuario específico pelo seu id
     *
     * @param id - identificador do usuario
     * @return - O usuario especificado
     */
    public static Usuario consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Usuario u = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Usuario as u where u.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                u = (Usuario) resultados.get(0);
            }

            return u;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return u;

        } finally {
            session.close();
        }
    }

    /**
     * Método utilizado para evitar o Lazy Inicialization Exception.
     *
     * @param id
     * @return Usuario
     */
    public static Usuario consultarWithJoin(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Usuario u = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Usuario as d LEFT JOIN fetch u.cursos as c LEFT JOIN fetch u.concurso where u.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                u = (Usuario) resultados.get(0);
            }
            return u;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return u;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar uma busca por usuarios com nome
     * especifico
     *
     * @param nome - Nome a ser buscado
     * @return - Uma variavel boolean indicando se o salvamento foi bem sucedido
     */
    public static ArrayList<Usuario> consultar(String nome) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Usuario> u = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Usuario as d where u.nome=:nome");

            q.setParameter("nome", nome);

            u = (ArrayList<Usuario>) q.list();

            return u;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return u;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar a alteração de um objeto Usuario
     *
     * @param u - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(Usuario u) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(u);
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
     * Método responsável por excluir um registro referente a um objeto Usuario
     *
     * @param u - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
    */
    public static boolean excluir(Usuario u){
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        //verificar se o docente eh coordenador de algum curso
        
        try {
            tx = session.beginTransaction();
            session.delete(u);
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
     * Docentes
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Criteria crit = session.createCriteria(Usuario.class);
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
    
    public static Usuario consultarCriteria(String coluna, String valor, Class classe) {
        Session session = ConexaoHibernate.getInstance();
        try {
            if (classe != null) {
                Usuario usuario = (Usuario) session.createCriteria(classe).add(Restrictions.eq(coluna, valor)).uniqueResult();
                if (usuario == null) {
                    return null;
                } else {
                    return usuario;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
