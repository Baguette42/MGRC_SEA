// Generated Dec 27, 2015 9:12:54 PM by Hibernate Tools 3.4.0.CR1
package fr.sigl.epita.imoe.minigrc.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.dao.ClientDAO;
import fr.sigl.epita.imoe.minigrc.dao.DAO;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * DAO for domain model class ClientEntity.
 * @see .ClientEntity
 * @author Hibernate Tools
 */
public class ClientDAOImpl extends DAO implements ClientDAO {

	/**
	 * Logger JUL.
	 */
	private static final Logger LOGGER = Logger.getLogger(ClientDAOImpl.class.getName());

	/**
	 * Session Hibernate.
	 */
	private final SessionFactory sessionFactory = getSessionFactory();

	/**
	 * Ajoute un nouvel client à la base.
	 *
	 * @param  transientInstance           Une instance de client.
	 */
    @Override
	public void persist(ClientEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting Client instance");
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
	 * @param  instance                    Une instance de client.
	 */
    @Override
	public void attachDirty(ClientEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty Client instance");
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
	 * @param  instance                    Une instance de client.
	 */
    @Override
	public void attachClean(ClientEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean Client instance");
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
	 * Supprime un client.
	 *
	 * @param  persistentInstance                    Une instance de client.
	 */
    @Override
	public void delete(ClientEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting Client instance");
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
	 * Met à jour le client.
	 *
	 * @param  persistentInstance                    Une instance de client.
	 */
	public void update(ClientEntity persistentInstance) {
		LOGGER.log(Level.INFO, "updating Client instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(persistentInstance);
            transaction.commit();
			LOGGER.log(Level.INFO, "updating successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "updating failed", re);
			throw re;
		}
	}

	/**
	 * Fusionne l'état persistent avec l'état détaché de une instance.
	 *
	 * @param  detachedInstance                    Une instance de client.
	 */
    @Override
	public ClientEntity merge(ClientEntity detachedInstance) {
		LOGGER.log(Level.SEVERE, "merging Client instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ClientEntity result = (ClientEntity) session.merge(detachedInstance);
            transaction.commit();
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	/**
	 * Retourne le client associé à l'identifiant passé en paramètre.
	 *
	 * @param  id                           L'identifiant technique du client.
	 * @return L'instance du client correspondant à l'identifiant technique.
	 */
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

	/**
	 * Retourne la liste des clients semblables au client passé en paramètre.
	 *
	 * @param  instance                     Le client utilisé pour la comparaison.
	 * @return L'instance du client semblable au client passé en paramètre.
	 */
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
