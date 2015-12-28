// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
import fr.sigl.epita.imoe.minigrc.dao.EvenementDAO;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * DAO for domain model class EvenementEntity.
 * @see .EvenementEntity
 * @author Hibernate Tools
 */
public class EvenementDAOImpl implements EvenementDAO {

	private static final Logger LOGGER = Logger.getLogger(EvenementDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(EvenementEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting EvenementEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			LOGGER.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty EvenementEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean EvenementEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(EvenementEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting EvenementEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public EvenementEntity merge(EvenementEntity detachedInstance) {
		LOGGER.log(Level.INFO, "merging EvenementEntity instance");
		try {
			EvenementEntity result = (EvenementEntity) sessionFactory.getCurrentSession().merge(detachedInstance);
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
			EvenementEntity instance = (EvenementEntity) sessionFactory.getCurrentSession().get("EvenementEntity", id);
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
			List results = sessionFactory.getCurrentSession().createCriteria("EvenementEntity").add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
