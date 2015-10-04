
package model;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Luiz
 */
public class TestantoHibernate {
    
    public static void main(String[] args) {
        gerarTabelas();        
    }

    private static void gerarTabelas() {

    AnnotationConfiguration cfg = new AnnotationConfiguration();
    cfg.configure("hibernate.cfg.xml");
        SchemaExport sx = new SchemaExport(cfg);
        sx.create(true, true);
    }
}
