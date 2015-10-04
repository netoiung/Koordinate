
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Classe responsável por criar a conexão com o banco de dados.
 * @author Luiz Paulo Franz
 */
public class ConexaoHibernate {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threaLocal = new ThreadLocal<Session>();

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("\n\n\n --------Erro na fábrica de sessões do hibernate-------- \n\n\n");
            e.printStackTrace();
            System.err.println("\n\n\n --------Fim do erro na fábrica de sessões do hibernate-------- \n\n\n");

            throw new ExceptionInInitializerError(e);
        }

    }
    
    public static Session getInstance(){
        Session session = (Session) threaLocal.get();
        session = sessionFactory.openSession();
        threaLocal.set(session);
        return session;
    }

}
