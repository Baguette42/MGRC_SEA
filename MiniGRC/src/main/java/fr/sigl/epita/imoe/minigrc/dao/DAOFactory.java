package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.dao.mock.EvenementDAOMock;
import fr.sigl.epita.imoe.minigrc.dao.mock.TypeEvenementDAOMock;

/**
 * Classe abstraite dont doivent hériter toutes les DAOFactory
 * concrétes.
 *
 * @author Chris
 */
public final class DAOFactory {
    /**
     * Instance unique de DAO à utiliser.
     */
    private static final DAOFactory INSTANCE = new DAOFactory();
    /**
     * Instance du DAO pour les événements.
     */
    private EvenementDAO evenementDAO;
    /**
     * Instance du DAO pour les types d'événements.
     */
    private TypeEvenementDAO typeEvenementDAO;

    /**
     * Constructeur privé pour respecter le principe du singleton.
     * Permet d'initialiser les instances de DAO avec les implémentations
     * MOCK.
     */
    private DAOFactory() {
        super();
    }

    /**
     * Retourne l'instance unique du singleton permettant
     * de produit les instances de DAO.
     *
     * @return Instance du singleton.
     */
    public static DAOFactory getInstance() {
        return INSTANCE;
    }
    
    /**
     * Retourne l'implémentation associée à la factory du EvenementDAO.
     *
     * @return Une instance de EvenementDAO.
     */
    public EvenementDAO getEvenementDAO() {
        if (evenementDAO == null) {
            evenementDAO = new EvenementDAOMock();
        }
        return evenementDAO;
    }

    /**
     * Retourne l'implémentation associée à la factory du TypeEvenementDAO.
     *
     * @return Une instance de TypeEvenementDAO.
     */
    public TypeEvenementDAO getTypeEvenementDAO() {
        if (typeEvenementDAO == null) {
            typeEvenementDAO = new TypeEvenementDAOMock();
        }
        return typeEvenementDAO;
    }
}
