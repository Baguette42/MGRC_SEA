package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.dao.mock.EvenementDAOtp1Mock;
import fr.sigl.epita.imoe.minigrc.dao.mock.TypeEvenementDAOtp1Mock;

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
    private EvenementDAOtp1 evenementDAOtp1;
    /**
     * Instance du DAO pour les types d'événements.
     */
    private TypeEvenementDAOtp1 typeEvenementDAOtp1;

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
    public EvenementDAOtp1 getEvenementDAO() {
        if (evenementDAOtp1 == null) {
            evenementDAOtp1 = new EvenementDAOtp1Mock();
        }
        return evenementDAOtp1;
    }

    /**
     * Retourne l'implémentation associée à la factory du TypeEvenementDAO.
     *
     * @return Une instance de TypeEvenementDAO.
     */
    public TypeEvenementDAOtp1 getTypeEvenementDAO() {
        if (typeEvenementDAOtp1 == null) {
            typeEvenementDAOtp1 = new TypeEvenementDAOtp1Mock();
        }
        return typeEvenementDAOtp1;
    }
}
