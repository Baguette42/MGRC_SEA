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
 * @author Hibernate Tools
 */
public class EvenementDAOImpl extends DAO implements EvenementDAO {

	/**
	 * Logger JUL.
	 */
	private static final Logger LOGGER = Logger.getLogger(EvenementDAOImpl.class.getName());

	/**
	 * Session Hibernate.
	 */
	private final SessionFactory sessionFactory = getSessionFactory();

	/**
	 * Ajoute un nouvel événement à la base.
	 *
	 * @param  transientInstance           Une instance d'événement.
	 */
    public void persist(EvenementEntity transientInstance) {
		LOGGER.log(Level.INFO, "persisting EvenementEntity instance");
        Transaction transaction = null;
		try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(transientInstance);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

    /**
     * Met à jour l'événement.
     *
     * @param  transientInstance                    Une instance d'événement.
     */
    public void update(EvenementEntity transientInstance) {
		LOGGER.log(Level.INFO, "updating EvenementEntity instance");
        Transaction transaction = null;
		try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(transientInstance);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "update successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "update failed", re);
			throw re;
		}
	}

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance d'événement.
     */
	public void attachDirty(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching dirty EvenementEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(instance);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

    /**
     * Rattache une instance à la session avec un mode de verrouillage défini.
     *
     * @param  instance                    Une instance d'événement.
     */
	public void attachClean(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "attaching clean EvenementEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.lock(instance, LockMode.NONE);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

    /**
     * Supprime un événement.
     *
     * @param  persistentInstance                    Une instance d'événement.
     */
	public void delete(EvenementEntity persistentInstance) {
		LOGGER.log(Level.INFO, "deleting EvenementEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(persistentInstance);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

    /**
     * Fusionne l'état persistent avec l'état détaché d'une instance.
     *
     * @param  detachedInstance                    Une instance d'événement.
     */
	public EvenementEntity merge(EvenementEntity detachedInstance) {
		LOGGER.log(Level.INFO, "merging EvenementEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            EvenementEntity result = (EvenementEntity) session.merge(detachedInstance);
            transaction.commit();
			session.close();
			LOGGER.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

    /**
     * Retourne l'événement associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique de l'événement.
     * @return L'instance de l'événement correspondant à l'identifiant technique.
     */
	public EvenementEntity findById(int id) {
		LOGGER.log(Level.INFO, "getting EvenementEntity instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			EvenementEntity instance = (EvenementEntity) session.get(EvenementEntity.class, id);
			if (instance == null) {
				LOGGER.log(Level.INFO, "get successful, no instance found");
			} else {
				LOGGER.log(Level.INFO, "get successful, instance found");
			}
			session.close();
			return instance;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

    /**
     * Retourne la liste des événements semblables à l'événement passé en paramètre.
     *
     * @param  instance                     L'événement utilisé pour la comparaison.
     * @return L'instance de l'événement semblable à l'événement passé en paramètre.
     */
	public List findByExample(EvenementEntity instance) {
		LOGGER.log(Level.INFO, "finding EvenementEntity instance by example");
		try {
			Session session = sessionFactory.openSession();
			List results = session.createCriteria(EvenementEntity.class).add(Example.create(instance))
					.list();
			LOGGER.log(Level.INFO, "find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
