// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import fr.sigl.epita.imoe.minigrc.dao.UserloginDAO;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * DAO object for domain model class UserloginEntity.
 * @see .UserloginEntity
 * @author Hibernate Tools
 */
public class UserloginDAOImpl extends DAO implements UserloginDAO {

    private static final Logger LOGGER = Logger.getLogger(UserloginDAOImpl.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    public void persist(UserloginEntity transientInstance) {
        LOGGER.log(Level.INFO, "persisting UserloginEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(transientInstance);
            transaction.commit();
            LOGGER.log(Level.INFO, "persist successful");
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }

    public void attachDirty(UserloginEntity instance) {
        LOGGER.log(Level.INFO, "attaching dirty UserloginEntity instance");
        try {
            sessionFactory.openSession().saveOrUpdate(instance);
            LOGGER.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(UserloginEntity instance) {
        LOGGER.log(Level.INFO, "attaching clean UserloginEntity instance");
        try {
            sessionFactory.openSession().lock(instance, LockMode.NONE);
            LOGGER.log(Level.INFO, "attach successful");
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void delete(UserloginEntity persistentInstance) {
        LOGGER.log(Level.INFO, "deleting UserloginEntity instance");
        try {
            sessionFactory.openSession().delete(persistentInstance);
            LOGGER.log(Level.INFO, "delete successful");
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public UserloginEntity merge(UserloginEntity detachedInstance) {
        LOGGER.log(Level.INFO, "merging UserloginEntity instance");
        try {
            UserloginEntity result = (UserloginEntity) sessionFactory.openSession().merge(detachedInstance);
            LOGGER.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    public UserloginEntity findById(int id) {
        LOGGER.log(Level.INFO, "getting UserloginEntity instance with id: " + id);
        try {
            UserloginEntity instance = (UserloginEntity) sessionFactory.openSession().get(UserloginEntity.class, id);
            if (instance == null) {
                LOGGER.log(Level.INFO, "get successful, no instance found");
            } else {
                LOGGER.log(Level.INFO, "get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }

    public List findByExample(UserloginEntity instance) {
        LOGGER.log(Level.INFO, "finding UserloginEntity instance by example");
        try {
            List results = sessionFactory.openSession().createCriteria(UserloginEntity.class).add(Example.create(instance))
                    .list();
            LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }
}
