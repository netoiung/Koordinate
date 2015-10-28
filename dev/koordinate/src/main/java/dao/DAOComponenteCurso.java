
package dao;

import java.util.ArrayList;
import java.util.List;
import model.ComponenteCurso;
import model.Curso;
import model.Docente;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsável pela persistência dos objetos Curso
 * @author Luiz Paulo Franz
 */
public class DAOComponenteCurso {
        
    /**
     * Método que realiza a persistência de um objeto Curso
     * 
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(ComponenteCurso c) {
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
     * Método que realiza a busca de todos os objetos do tipo Curso
     *
     * @return - Um ArrayList com todos os Curso recuperados no banco
     */
    public static ArrayList<ComponenteCurso> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<ComponenteCurso> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ComponenteCurso as c");

            c = (ArrayList<ComponenteCurso>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que busca um Curso específico pelo seu id
     *
     * @param id - identificador do Curso
     * @return - O Curso especificado
     */
    public static ComponenteCurso consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ComponenteCurso c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ComponenteCurso as c where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (ComponenteCurso) resultados.get(0);
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
     * Método que busca um Curso específico pelo seu id
     *
     * @param cc
     * @return - O Curso especificado
     */
    public static ComponenteCurso consultar(ComponenteCurso cc) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ComponenteCurso c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ComponenteCurso as c where c.curso=:curso AND c.componenteCurricular=:comp");

            q.setParameter("curso", cc.getCurso());
            q.setParameter("comp", cc.getComponenteCurricular());

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (ComponenteCurso) resultados.get(0);
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
     * Método responsável por realizar a alteração de um objeto Curso
     *
     * @param c - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(ComponenteCurso c) {
        
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
     * Método responsável por excluir um registro referente a um objeto Curso
     *
     * @param d - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean excluir(ComponenteCurso d) {
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
     * Curso
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Criteria crit = session.createCriteria(ComponenteCurso.class);
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
