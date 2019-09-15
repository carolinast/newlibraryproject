package pl.sda.configuration;

/*import hibernate.model.Admin;
import hibernate.model.State;*/

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateJavaConfig {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Session session;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true");
                settings.put(Environment.USER, "ulib");
                settings.put(Environment.PASS, "ulib");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                // Tworzy nową tabelę z każdym wywołaniem programu.
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop"); // drop tabel
                settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
/*                configuration.addAnnotatedClass(Admin.class);
                configuration.addAnnotatedClass(State.class);*/
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Borrow.class);
                configuration.addAnnotatedClass(Borrower.class);
                configuration.addAnnotatedClass(BorrowerDetails.class);

                serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        getSessionFactory();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
