package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rezervace.HibernateUtil;

import javax.persistence.Entity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Common dao Methods inspiration by Tomas Cerny and Mr. Cemus
 *
 * @param <T>
 */
public class CommonDAOImpl<T extends DataClass> implements GenericDAOI<T> {

    private static final Logger LOG = Logger.getLogger(CommonDAOImpl.class.getName());

    private Session session;
    private Class<T> clazz;
    private String entityName;

    protected CommonDAOImpl(Class<T> clazz) {
        this(clazz, null);
    }

    protected CommonDAOImpl(Class<T> clazz, Session session) {

        this.clazz = clazz;
        this.session = session;

        entityName = clazz.getAnnotation(Entity.class).name();
    }

    protected Session getSession() {
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }


    /**
     * Entity manager add new entity and assign ID
     *
     * @param entity
     * @return enity if entity was successfully added
     */
    @Override
    public T add(T entity) {
        if (entity == null) {
            return null;
        }
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            getSession().save(entity);
            tx.commit();

            LOG.log(Level.INFO, "Added {0}: {1}", new Object[]{entityName, entity});

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
            //WE WANT TO PROPAGATER EXCEPTION UPPER, AND MAKE ACTION
            throw e;
        } finally {
            //CANT BE OPEN MORE THAN 2 SESSION
            getSession().close();
        }
        return entity;
    }

    /**
     * Retrives entity with specified id.
     *
     * @param id Desired id
     * @return desired entity or null 
     */
    @Override
    public T getById(Long id) {
        if (id == null) {
            return null;
        }
        try {
            T entity = (T) getSession().get(clazz, id);
            LOG.log(Level.INFO, "Got {0}: {1}", new Object[]{entityName, entity});
            return entity;
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Just fetch row
     *
     * @param clazz
     * @param columnName
     * @param value
     * @return entity
     */
    @Override
    public T getFirstByColumn(Class<T> clazz, String value, String columnName) {

        Transaction tx = null;
        T entity = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().createQuery("FROM " + entityName + " WHERE " + columnName + " = :value");
            q.setParameter("value", value);
            List list = q.list();
            entity = (T) (list.isEmpty() ? null : list.get(0));
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return entity;
    }

    /**
     * Retrieves all from database.
     *
     * @return list of entities
     */
    @Override
    public List<T> getAll() {
        List entities = null;
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            entities = getSession().createQuery("FROM " + entityName).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return (List<T>) entities;
    }

    /**
     * Updates entity in database.
     *
     * @param entity Entity to updat
     * @return entity or null
     */
    @Override
    public T update(T entity) {
        if (entity == null || entity.getId() == null) {
            return null;
        }
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            getSession().merge(entity);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return entity;
    }

    /**
     * Deletes entity with specific Id
     *
     * @param id Id of entity to delete
     * @return true or false
     */
    @Override
    public boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            T entity = (T) getSession().get(clazz, id);
            getSession().delete(entity);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return false;
    }


    /**
     * Retrieves all
     *
     * @param clazz
     * @param columnName
     * @param value
     * @return list 
     */
    @Override
    public List<T> getAllByColumn(Class<T> clazz, String columnName, String value) {
        Transaction tx = null;
        List entities = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().createQuery(String.format("FROM " + entityName + " WHERE %s = :value", columnName));
            q.setParameter("value", value);
            entities = q.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return (List<T>) entities;
    }

}

