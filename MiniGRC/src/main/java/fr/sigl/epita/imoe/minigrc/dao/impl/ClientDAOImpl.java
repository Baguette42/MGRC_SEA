// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.dao.ClientDAO;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * DAO for domain model class ClientEntity.
 * @see .ClientEntity
 * @author Hibernate Tools
 */
public class ClientDAOImpl extends DAO implements ClientDAO {

	private static final Logger LOGGER = Logger.getLogger(ClientDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

    @Override
	public void persist(ClientEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting Client instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			LOGGER.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

    @Override
	public void attachDirty(ClientEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty Client instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

    @Override
	public void attachClean(ClientEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean Client instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

    @Override
	public void delete(ClientEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting Client instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

    @Override
	public ClientEntity merge(ClientEntity detachedInstance) {
		LOGGER.log(Level.SEVERE, "merging Client instance");
		try {
			ClientEntity result = (ClientEntity) sessionFactory.openSession().merge(detachedInstance);
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

    @Override
	public ClientEntity findById(int id) {
		LOGGER.log(Level.INFO, "getting Client instance with id: " + id);
		try {
			ClientEntity instance = (ClientEntity) sessionFactory.openSession().get(ClientEntity.class, id);
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

    @Override
	public List findByExample(ClientEntity instance) {
		LOGGER.log(Level.INFO, "finding Client instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(ClientEntity.class).add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
