// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import fr.sigl.epita.imoe.minigrc.dao.UserloginDAO;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * DAO object for domain model class UserloginEntity.
 * @see .UserloginEntity
 * @author Hibernate Tools
 */
public class UserloginDAOImpl extends DAO implements UserloginDAO {

	private static final Logger log = Logger.getLogger(UserloginDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

		public void persist(UserloginEntity transientInstance) {
		log.log(Level.INFO, "persisting UserloginEntity instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserloginEntity instance) {
		log.log(Level.INFO, "attaching dirty UserloginEntity instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserloginEntity instance) {
		log.log(Level.INFO, "attaching clean UserloginEntity instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(UserloginEntity persistentInstance) {
		log.log(Level.INFO, "deleting UserloginEntity instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public UserloginEntity merge(UserloginEntity detachedInstance) {
		log.log(Level.INFO, "merging UserloginEntity instance");
		try {
			UserloginEntity result = (UserloginEntity) sessionFactory.openSession().merge(detachedInstance);
			log.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public UserloginEntity findById(int id) {
		log.log(Level.INFO, "getting UserloginEntity instance with id: " + id);
		try {
			UserloginEntity instance = (UserloginEntity) sessionFactory.openSession().get(UserloginEntity.class, id);
			if (instance == null) {
				log.log(Level.INFO, "get successful, no instance found");
			} else {
				log.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(UserloginEntity instance) {
		log.log(Level.INFO, "finding UserloginEntity instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(UserloginEntity.class).add(Example.create(instance))
					.list();
			log.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
