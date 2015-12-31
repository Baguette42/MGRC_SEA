// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import fr.sigl.epita.imoe.minigrc.dao.PanelDAO;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * DAO for domain model class PanelEntity.
 * @see .PanelEntity
 * @author Hibernate Tools
 */
public class PanelDAOImpl extends DAO implements PanelDAO {

	/**
	 * Logger JUL.
	 */
	private static final Logger LOGGER = Logger.getLogger(PanelDAOImpl.class.getName());

	/**
	 * Session Hibernate.
	 */
	private final SessionFactory sessionFactory = getSessionFactory();

	/**
	 * Ajoute un nouvel panel à la base.
	 *
	 * @param  transientInstance           Une instance de panel.
	 */
	public void persist(PanelEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting PanelEntity instance");
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

	/**
	 * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
	 *
	 * @param  instance                    Une instance de panel.
	 */
	public void attachDirty(PanelEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty PanelEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(instance);
            transaction.commit();
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	/**
	 * Rattache une instance à la session avec un mode de verrouillage défini.
	 *
	 * @param  instance                    Une instance de panel.
	 */
	public void attachClean(PanelEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean PanelEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.lock(instance, LockMode.NONE);
            transaction.commit();
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	/**
	 * Supprime un panel.
	 *
	 * @param  persistentInstance                    Une instance de panel.
	 */
	public void delete(PanelEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting PanelEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(persistentInstance);
            transaction.commit();
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	/**
	 * Fusionne l'état persistent avec l'état détaché de une instance.
	 *
	 * @param  detachedInstance                    Une instance de panel.
	 */
	public PanelEntity merge(PanelEntity detachedInstance) {
		LOGGER.log(Level.INFO, "merging PanelEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PanelEntity result = (PanelEntity) session.merge(detachedInstance);
            transaction.commit();
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	/**
	 * Retourne le panel associé à l'identifiant passé en paramètre.
	 *
	 * @param  id                           L'identifiant technique du panel.
	 * @return L'instance du panel correspondant à l'identifiant technique.
	 */
	public PanelEntity findById(int id) {
		LOGGER.log(Level.INFO, "getting PanelEntity instance with id: " + id);
		try {
			PanelEntity instance = (PanelEntity) sessionFactory.openSession().get(PanelEntity.class, id);
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

	/**
	 * Retourne la liste des panels semblables au panel passé en paramètre.
	 *
	 * @param  instance                     Le panel utilisé pour la comparaison.
	 * @return L'instance du panel semblable au panel passé en paramètre.
	 */
	public List findByExample(PanelEntity instance) {
		LOGGER.log(Level.INFO, "finding PanelEntity instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(PanelEntity.class).add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
