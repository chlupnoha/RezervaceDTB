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
 * Class with common methods of DAOs
 *
 * @param <T>
 */
public class CommonDAOImpl<T extends DataClass> implements GenericDAOInterface<T> {

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
     * Adds entity to the database. Entity id can be set to specific value, or
     * null to generate new id, generated id is set to the object.
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

            LOG.log(Level.INFO, "Added {0}: (#{1}) {2}", new Object[]{entityName, entity.getId(), entity});

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
            //WE WANT TO PROPAGATER EXCEPTION UPPER, AND MAKE ACTION
            throw e;
        } finally {
            getSession().close();
        }
        return entity;
    }

    /**
     * Retrives entity with specified id.
     *
     * @param id Desired id
     * @return desired entity or null if entity with specified id does not exist
     */
    @Override
    public T getById(Long id) {
        if (id == null) {
            return null;
        }
        try {
            T entity = (T) getSession().get(clazz, id);
            LOG.log(Level.INFO, "Got {0}: (#{1}) {2}", new Object[]{entityName, entity == null ? "" : entity.getId(), entity});
            return entity;
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Retrieves first entity with specified value in specified column.
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
            LOG.log(Level.INFO, "Got first {1} by {0}: (#{2}) {3}", new Object[]{columnName, entityName, entity == null ? "" : entity.getId(), entity});
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return entity;
    }

    /**
     * Retrieves all entities from database.
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
            LOG.log(Level.INFO, "Got all {1} {0}", new Object[]{entityName, entities.size()});
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return (List<T>) (Object) entities;
    }

    /**
     * Updates entity in database.
     *
     * @param entity Entity to update, with id different form null
     * @return entity if entity was successfully updated
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

            LOG.log(Level.INFO, "Updated {0}: (#{1}) {2}", new Object[]{entityName, entity.getId(), entity});
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return entity;
    }

    /**
     * Deletes entity from database.
     *
     * @param id Id of entity to delete, can't be null
     * @return true if entity was successfully deleted
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
            LOG.log(Level.INFO, "Deleted {0}: (#{1}) {2}", new Object[]{entityName, entity.getId(), entity});
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
     * Retrieves all entities with specified value in specified column.
     *
     * @param columnName
     * @param value
     * @return list of entities
     */
    @Override
    public List<T> getAllByColumn(Class<T> clazz, String columnName, String value) {
        Transaction tx = null;
        List entities = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().createQuery(String.format("FROM User WHERE %s = :value", columnName));
            q.setParameter("value", value);
            entities = q.list();
            tx.commit();
            LOG.log(Level.INFO, "Got all {2} {1} by {0}", new Object[]{columnName, entityName, entities.size()});
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.log(Level.SEVERE, null, e);
        }
        return (List<T>) (Object) entities;
    }
}

