import Entity.Corso;
import Entity.Esame;
import Entity.Studente;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String JDBC_URL = "jdbc:h2:file:./database/universita";
    //private static final String HOST = "localhost";
    //private static final int Port = 8081;
    private static final String USER = "sa";
    private static final String PASS = "";

    public static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
            cfg.setProperty("hibernate.connection.url", JDBC_URL);
            cfg.setProperty("hibernate.connection.username", USER);
            cfg.setProperty("hibernate.connection.password", PASS);
            cfg.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // specifica se creare db allo start della app return cfg.buildSessionFactory();
            //aggiunge classi al contensto di persistenza
            cfg.addAnnotatedClasses(Studente.class);
            cfg.addAnnotatedClasses(Corso.class);
            cfg.addAnnotatedClasses(Esame.class);
            return cfg.buildSessionFactory();
        } catch (Throwable t) {
            System.err.println(t.getMessage());
            return null;
        }
    }
}
