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
 * @author Hibernate Tools
 */
public class UserloginDAOImpl extends DAO implements UserloginDAO {

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(UserloginDAOImpl.class.getName());

    /**
     * Session Hibernate.
     */
    private final SessionFactory sessionFactory = getSessionFactory();

    /**
     * Ajoute un nouvel utilisateur à la base.
     *
     * @param  transientInstance           Une instance d'utilisateur.
     */
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

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance d'utilisateur.
     */
    public void attachDirty(UserloginEntity instance) {
        LOGGER.log(Level.INFO, "attaching dirty UserloginEntity instance");
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
     * @param  instance                    Une instance d'utilisateur.
     */
    public void attachClean(UserloginEntity instance) {
        LOGGER.log(Level.INFO, "attaching clean UserloginEntity instance");
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
     * Supprime un utilisateur.
     *
     * @param  persistentInstance                    Une instance d'utilisateur.
     */
    public void delete(UserloginEntity persistentInstance) {
        LOGGER.log(Level.INFO, "deleting UserloginEntity instance");
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
     * Fusionne l'état persistent avec l'état détaché d'une instance.
     *
     * @param  detachedInstance                    Une instance d'utilisateur.
     */
    public UserloginEntity merge(UserloginEntity detachedInstance) {
        LOGGER.log(Level.INFO, "merging UserloginEntity instance");
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserloginEntity result = (UserloginEntity) session.merge(detachedInstance);
            transaction.commit();
            LOGGER.log(Level.INFO, "merge successful");
            return result;
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    /**
     * Retourne l'utilisateur associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique de l'utilisateur.
     * @return L'instance de l'utilisateur correspondant à l'identifiant technique.
     */
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

    /**
     * Retourne la liste des utilisateurs semblables à l'utilisateur passé en paramètre.
     *
     * @param  instance                     L'utilisateur utilisé pour la comparaison.
     * @return L'instance de l'utilisateur semblable à l'utilisateur passé en paramètre.
     */
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
