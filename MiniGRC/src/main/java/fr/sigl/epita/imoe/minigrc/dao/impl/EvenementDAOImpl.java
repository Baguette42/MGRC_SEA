// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import fr.sigl.epita.imoe.minigrc.dao.EvenementDAO;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * DAO for domain model class EvenementEntity.
 * @see .EvenementEntity
 * @author Hibernate Tools
 */
public class EvenementDAOImpl extends DAO implements EvenementDAO {

	private static final Logger LOGGER = Logger.getLogger(EvenementDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

    public void persist(EvenementEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting EvenementEntity instance");
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

	public void attachDirty(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty EvenementEntity instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean EvenementEntity instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(EvenementEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting EvenementEntity instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public EvenementEntity merge(EvenementEntity detachedInstance) {
		LOGGER.log(Level.INFO, "merging EvenementEntity instance");
		try {
			EvenementEntity result = (EvenementEntity) sessionFactory.openSession().merge(detachedInstance);
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public EvenementEntity findById(int id) {
		LOGGER.log(Level.INFO, "getting EvenementEntity instance with id: " + id);
		try {
			EvenementEntity instance = (EvenementEntity) sessionFactory.openSession().get(EvenementEntity.class, id);
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

	public List findByExample(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "finding EvenementEntity instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(EvenementEntity.class).add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
