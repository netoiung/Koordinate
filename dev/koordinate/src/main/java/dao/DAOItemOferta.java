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
import model.ItemOferta;
import model.Oferta;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 * Classe responsável pela persistência dos objetos ItemOferta
 *
 * @author Eduardo Amaral
 */
public class DAOItemOferta {

    /**
     * Método que realiza a persistência de um objeto Oferta
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(ItemOferta c) {
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
     * Método que realiza a persistência de um objeto Oferta
     *
     * @param c - Objeto a ser persistido
     * @return - um boolean indicando se o objeto foi salvo ou não
     */
    public static boolean salvar(ComponenteCursoItemOferta c) {
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
     * Método responsavel por persistir todos os itens de oferta, dada a Oferta
     *  o semestre  e o curso.
     * @param semestre
     * @param c
     * @param o 
     */
    public void salvarTodosPorSemestre(short semestre, Curso c, Oferta o){
        DAOOferta dao = new DAOOferta();
        
        List<ComponenteCurso> componentes = dao.getComponentesNaoOfertados(c, semestre);
        //objetos necessarios
        ItemOferta io;
        ComponenteCursoItemOferta ccio;
        //percorremos e inserimos
        for (ComponenteCurso cc : componentes) {
            io = new ItemOferta();
            io.setOferta(o);

            ccio = new ComponenteCursoItemOferta();
            ccio.setComponenteCurso(cc);
            ccio.setItemOferta(io);
            //salvamos o item oferta e o componente curso item oferta
            DAOItemOferta.salvar(io);
            DAOItemOferta.salvar(ccio);
        }
    }
    
    /**
     * Método responsavel por excluir todos os itens de oferta, dada a Oferta
     *  o semestre  e o curso.
     * @param semestre
     * @param c
     */
    public void excluiTodosPorSemestre(short semestre, Curso c){
        DAOOferta dao = new DAOOferta();
        ItemOferta io;
        List<ComponenteCursoItemOferta> componentes = dao.getComponentesOfertados(c, semestre);
        //percorremos e inserimos
        for (ComponenteCursoItemOferta ccio : componentes) {
            io = ccio.getItemOferta();
            //excluimos o item oferta e o componente curso item oferta
            DAOItemOferta.excluir(ccio);
            DAOItemOferta.excluir(io);
        }
    }

    /**
     * Método que realiza a busca de todos os objetos do tipo Oferta
     *
     * @return - Um ArrayList com todos os Concursos recuperados no banco
     */
    public static ArrayList<ItemOferta> consultar() {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ArrayList<ItemOferta> c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ItemOferta as c");

            c = (ArrayList<ItemOferta>) q.list();

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
    public static ItemOferta consultar(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        ItemOferta c = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM ItemOferta as c where c.id=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                c = (ItemOferta) resultados.get(0);
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
    public static boolean alterar(ItemOferta c) {
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
    public static boolean excluir(ItemOferta d) {
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
    
    public static boolean excluir(ComponenteCursoItemOferta d) {
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
