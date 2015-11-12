/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excecoes.PeriodoLetivoException;
import java.util.ArrayList;
import java.util.List;
import model.ComponenteCurso;
import model.ComponenteCursoItemOferta;
import model.Curso;
import model.DocenteItemOferta;
import model.Oferta;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsÃƒÂ¡vel pela persistÃƒÂªncia dos objetos Oferta
 *
 * @author Eduardo Amaral
 */
public class DAOOferta {

    /**
     * MÃƒÂ©todo que realiza a persistÃƒÂªncia de um objeto Oferta
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou nÃƒÂ£o
     * @throws excecoes.PeriodoLetivoException
     */
    public static boolean salvar(Oferta c) throws PeriodoLetivoException {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        DAOOferta dao = new DAOOferta();
        if (!dao.isPeriodoLetivoFree(c.getId(), c.getPeriodoLetivo())) {
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
     * MÃƒÂ©todo que realiza a busca de todos os objetos do tipo Oferta
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
     * MÃƒÂ©todo que busca um concurso especÃƒÂ­fico pelo seu id
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
     * MÃƒÂ©todo que busca um concurso especÃƒÂ­fico pelo seu periodo.
     *
     * @param periodo - periodo letivo
     * @return - O concurso especificado
     */
    public boolean isPeriodoLetivoFree(int id, String periodo) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Oferta as o where o.periodoLetivo=:periodo AND o.id!=:id");

            q.setParameter("periodo", periodo);
            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                return false;
            }

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
     * MÃƒÂ©todo responsÃƒÂ¡vel por realizar a alteraÃƒÂ§ÃƒÂ£o de um objeto Oferta
     *
     * @param c - VariÃƒÂ¡vel que contÃƒÂ©m o objeto modificado
     * @return - Uma variÃƒÂ¡vel boolean indicando se o salvamento foi bem
     * sucedido
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
     * MÃƒÂ©todo responsÃƒÂ¡vel por excluir um registro referente a um objeto Oferta
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
     * MÃƒÂ©todo responsÃƒÂ¡vel por mostrar a quantidade de registros na tabela de
     * Oferta
     *
     * @return - O nÃƒÂºmero de registros na tabela
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

    /**
     * Método responsável por buscar os componenteCurso dado o curso e o
     * semestre.
     *
     * @param c Curso
     * @param semestre byte
     * @return ArrayList
     */
    public ArrayList<ComponenteCursoItemOferta> getComponentesOfertados(Curso c, short semestre, Oferta o) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        ArrayList<ComponenteCursoItemOferta> retorno = null;
        //short sem = Short.

        try {
            Query q;
            tx = session.beginTransaction();
            q = session.createQuery("FROM ComponenteCursoItemOferta AS ccif JOIN FETCH ccif.itemOferta AS io JOIN fetch ccif.componenteCurso AS cc JOIN fetch cc.componenteCurricular WHERE cc.curso=:c AND cc.semestre=:s AND io=:o");
            q.setParameter("c", c);
            q.setParameter("s", semestre);
            q.setParameter("o", o);
            retorno = (ArrayList<ComponenteCursoItemOferta>) q.list();

            return retorno;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return retorno;

        } finally {
            session.close();
        }
    }

    /**
     * MÃƒÂ©todo responsÃƒÂ¡vel por buscar os DocenteItemOferta dado o curso e a
     * oferta.
     *
     * @param c Curso
     * @param o
     * @return ArrayList
     */
    public static ArrayList<DocenteItemOferta> getDocenteItemOfertas(Curso c, Oferta o) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        ArrayList<DocenteItemOferta> retorno = null;
        //short sem = Short.

        try {
            Query q;
            tx = session.beginTransaction();
            q = session.createQuery("FROM DocenteItemOferta AS dio JOIN fetch dio.docente JOIN fetch dio.itemOferta AS io JOIN fetch io.componenteCursoItemOfertas AS ccio JOIN fetch ccio.componenteCurso AS cc JOIN fetch io.oferta WHERE cc.curso=:c AND io.oferta:=o");
            q.setParameter("c", c);
            q.setParameter("o", o);
            retorno = (ArrayList<DocenteItemOferta>) q.list();

            return retorno;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return retorno;

        } finally {
            session.close();
        }
    }
    /**
     * MÃƒÂ©todo responsÃƒÂ¡vel por buscar os componenteCurso dado o curso e o
     * semestre.
     *
     * @param c Curso
     * @param o
     * @return ArrayList
     */
    public static ArrayList<ComponenteCursoItemOferta> getComponenteCursoItemOferta(Curso c, Oferta o) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        ArrayList<ComponenteCursoItemOferta> retorno = null;
        //short sem = Short.

        try {
            Query q;
            tx = session.beginTransaction();
            q = session.createQuery("FROM ComponenteCursoItemOferta AS ccio LEFT JOIN fetch ccio.componenteCurso AS cc LEFT JOIN fetch cc.componenteCurricular LEFT JOIN fetch ccio.itemOferta AS io LEFT JOIN fetch io.oferta AS o LEFT JOIN fetch io.docenteItemOfertas AS dio LEFT JOIN fetch dio.docente  WHERE cc.curso=:c AND io.oferta=:o");
            q.setParameter("c", c);
            q.setParameter("o", o);
            retorno = (ArrayList<ComponenteCursoItemOferta>) q.list();

            return retorno;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return retorno;

        } finally {
            session.close();
        }
    }

    /**
     * MÃƒÂ©todo responsÃƒÂ¡vel por buscar os componenteCurso dado o curso e o
     * semestre.
     *
     * @param c Curso
     * @param semestre byte
     * @return ArrayList
     */
    public ArrayList<ComponenteCurso> getComponentesNaoOfertados(Curso c, short semestre) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        ArrayList<ComponenteCurso> retorno = null;
        //short sem = Short.

        try {
            Query q;
            tx = session.beginTransaction();
            q = session.createQuery("FROM ComponenteCurso AS cc JOIN fetch cc.componenteCurricular LEFT JOIN fetch cc.componenteCursoItemOfertas AS ccio WHERE cc.curso=:c AND cc.semestre=:s AND ccio IS NULL");
            q.setParameter("c", c);
            q.setParameter("s", semestre);
            retorno = (ArrayList<ComponenteCurso>) q.list();

            return retorno;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return retorno;

        } finally {
            session.close();
        }
    }

    /**
     * MÃƒÂ©todo que realiza a busca de todos os objetos do tipo Oferta
     *
     * @return - Um ArrayList com todos os ComponenteCursoItemOferta recuperados no banco
     */
    public static ArrayList<Oferta> buscarComponenteCursoItemOferta() {
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

}
