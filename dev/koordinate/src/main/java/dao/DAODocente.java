package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docente;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import excecoes.IntegridadeReferencialException;
import java.util.Set;
import model.Curso;

/**
 * Classe responsável pela persistência dos objetos Docente
 *
 * @author Luiz Paulo Franz
 */
public class DAODocente {

    /**
     *
     * @param siape
     * @return
     */
    public static boolean existe(int siape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que realiza a persistência de um objeto Docente
     *
     * @param d - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(Docente d) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(d);
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
     * Método que realiza a busca de todos os objetos do tipo Docente
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<Docente> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Docente> d = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Docente as d");

            d = (ArrayList<Docente>) q.list();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

        return d;

    }

    /**
     * Método que busca um docente específico pelo seu id
     *
     * @param id - identificador do docente
     * @return - O docetne especificado
     */
    public static Docente consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Docente d = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Docente as d where d.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                d = (Docente) resultados.get(0);
            }

            return d;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return d;

        } finally {
            session.close();
        }
    }

    /**
     * Método utilizado para evitar o Lazy Inicialization Exception.
     *
     * @param id
     * @return Docente
     */
    public static Docente consultarWithJoin(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Docente d = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Docente as d LEFT JOIN fetch d.cursos as c LEFT JOIN fetch d.concurso where d.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                d = (Docente) resultados.get(0);
            }

            return d;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return d;

        } finally {
            session.close();
        }
    }

    /**
     * Método responsável por realizar uma busca por docentes com nome
     * especifico
     *
     * @param nome - Nome a ser buscado
     * @return - Uma variavel boolean indicando se o salvamento foi bem sucedido
     */
    public static ArrayList<Docente> consultar(String nome) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<Docente> d = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Docente as d where d.nome=:nome");

            q.setParameter("nome", nome);

            d = (ArrayList<Docente>) q.list();

            return d;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return d;

        } finally {
            session.close();
        }

    }

    /**
     * Método responsável por realizar a alteração de um objeto Docente
     *
     * @param d - Variável que contém o objeto modificado
     * @return - Uma variável boolean indicando se o salvamento foi bem sucedido
     */
    public static boolean alterar(Docente d) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(d);
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
     * Método responsável por excluir um registro referente a um objeto Docente
     *
     * @param d - O objeto referente ao registro que deve ser excluido do banco
     * @return - Um boolean indicando se o salvamento foi bem sucedido
     * @throws excecoes.IntegridadeReferencialException
     */
    public static boolean excluir(Docente d) throws IntegridadeReferencialException {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        //verificar se o docente eh coordenador de algum curso
        Docente temp = consultarWithJoin(d.getId());
        Set<Curso> cursos;
        cursos = temp.getCursos();
        if (cursos != null) {
            if (!cursos.isEmpty()) {
                throw new IntegridadeReferencialException("Impossível excluir esse docente, ele é coordenador de cursos.");
            }
        }

        cursos = null;
        temp = null;

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
     * Docentes
     *
     * @return - O número de registros na tabela
     */
    public static int count() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Criteria crit = session.createCriteria(Docente.class);
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
