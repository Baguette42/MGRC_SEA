// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;
import fr.sigl.epita.imoe.minigrc.dao.PanelDAO;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class PanelEntity.
 * @see .PanelEntity
 * @author Hibernate Tools
 */
public class PanelDAOImpl implements PanelDAO {

	private static final Logger LOGGER = Logger.getLogger(PanelDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PanelEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting PanelEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			LOGGER.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PanelEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty PanelEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(PanelEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean PanelEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(PanelEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting PanelEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public PanelEntity merge(PanelEntity detachedInstance) {
		LOGGER.log(Level.INFO, "merging PanelEntity instance");
		try {
			PanelEntity result = (PanelEntity) sessionFactory.getCurrentSession().merge(detachedInstance);
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public PanelEntity findById(int id) {
		LOGGER.log(Level.INFO, "getting PanelEntity instance with id: " + id);
		try {
			PanelEntity instance = (PanelEntity) sessionFactory.getCurrentSession().get("PanelEntity", id);
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

	public List findByExample(PanelEntity instance) {
		LOGGER.log(Level.INFO, "finding PanelEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("PanelEntity").add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
