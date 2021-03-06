package rezervace;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class HibernateUtil {

    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            LOG.log(Level.INFO, "Initializing hibernate.");
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            LOG.log(Level.SEVERE, "Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        LOG.log(Level.INFO, "Shutting down hibernate.");
        getSessionFactory().close();
    }
}
