
package dao_impl;

import rezervace.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Class with common methods of DAOs
 *
 * @param <T>
 */
public class CommonDAOImpl<T extends DataClass> {

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
     * Retrives entity with specified id.
     *
     * @param id Desired id
     * @return desired entity or null if entity with specified id does not exist
     */
    protected T getEntityById(Integer id) {
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
     * Adds entity to the database. Entity id can be set to specific value, or
     * null to generate new id, generated id is set to the object.
     *
     * @param entity
     * @return enity if entity was successfully added
     */
    protected T addEntity(T entity) {
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
        } finally {
            getSession().close();
        }
        return entity;
    }

    /**
     * Retrieves all entities from database.
     *
     * @return list of entities
     */
    protected List<T> getAllEntities() {
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
    protected T updateEntity(T entity) {
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
    protected boolean deleteEntity(Integer id) {
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
     * Retrieves first entity with specified value in specified column.
     *
     * @param columnName
     * @param value
     * @return entity
     */
    protected T getFirstEntityByColumn(String columnName, Object value) {
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
     * Retrieves all entities with specified value in specified column.
     *
     * @param columnName
     * @param value
     * @return list of entities
     */
    protected List<T> getAllEntityByColumn(String columnName, Object value) {
        Transaction tx = null;
        List entities = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().createQuery("FROM User WHERE " + columnName + " = :value");
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
