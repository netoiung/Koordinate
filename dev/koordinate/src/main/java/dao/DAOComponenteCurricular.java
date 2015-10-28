
package dao;

import java.util.ArrayList;
import java.util.List;
import model.ComponenteCurricular;
import model.ComponenteCurso;
import model.Concurso;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsável pela Pesistência dos ojetos ComponenteCurricular
 * @author Luiz Paulo Franz
 */
public class DAOComponenteCurricular {

    /**
     * Método que realiza a persistência de um objeto ComponenteCurricular
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(ComponenteCurricular c) {
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
     * Método que realiza a busca de todos os objetos do tipo
     * ComponenteCurricular
     *
     * @return - Um ArrayList com todos os ComponenteCurriculares recuperados no
     * banco
     */
    public static ArrayList<ComponenteCurricular> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<ComponenteCurricular> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ComponenteCurricular as c");

            c = (ArrayList<ComponenteCurricular>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return c;

    }

    /**
     * Método que busca um ComponenteCurricular específico pelo seu id
     *
     * @param id - identificador do concurso
     * @return - O ComponenteCurricular especificado
     */
    public static ComponenteCurricular consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ComponenteCurricular c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ComponenteCurricular as c where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (ComponenteCurricular) resultados.get(0);
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
     * Método responsável por fazer a consulta com os Joins necessários, para 
     * podermos usar o LAZY inicialization.
     * 
     * @param id int
     * @return ComponenteCurricular
     */
    public ComponenteCurricular consultarWithJoin(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ComponenteCurricular c = null;

        try {

            Query q;

            tx = session.beginTransaction();
            //dois left JOINS, um para componente_curso outro para curso
            q = session.createQuery("FROM ComponenteCurricular as c LEFT JOIN fetch c.componenteCursos as componente LEFT JOIN fetch componente.curso where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (ComponenteCurricular) resultados.get(0);
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
    
    /** Método responsável por realizar a consulta de um componente curricular
     *
     * @param c
     * @return
     */
    public ComponenteCurricular consultarWithJoin(ComponenteCurricular c) {
        return this.consultarWithJoin(c.getId());
    }

    /**
     * Método responsável por realizar a alteração de um objeto
     * ComponenteCurricular
     *
     * @param c - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(ComponenteCurricular c) {
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
     * Método responsável por excluir um registro referente a um objeto
     * ComponenteCurricular
     *
     * @param d - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean excluir(ComponenteCurricular d) {
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
     * Método responsável por mostrar a quantidade de registros na tabela de Componente Curricular
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        
        try{
        
        Criteria crit = session.createCriteria(ComponenteCurricular.class);
        crit.setProjection(Projections.rowCount());
        Long l = (Long) crit.list().get(0);
        
        return Integer.valueOf(l.toString());
        
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return 0;
    }
}
