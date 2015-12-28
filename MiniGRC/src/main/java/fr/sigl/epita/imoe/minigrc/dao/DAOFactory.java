package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.dao.impl.ClientDAOImpl;
import fr.sigl.epita.imoe.minigrc.dao.impl.EvenementDAOImpl;
import fr.sigl.epita.imoe.minigrc.dao.impl.PanelDAOImpl;

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
     * Instance du DAO pour les clients.
     */
    private ClientDAO clientDAO;
    /**
     * Instance du DAO pour les événements.
     */
    private EvenementDAO evenementDAO;
    /**
     * Instance du DAO pour les panels.
     */
    private PanelDAO panelDAO;

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
            evenementDAO = new EvenementDAOImpl();
        }
        return evenementDAO;
    }

    /**
     * Retourne l'implémentation associée à la factory du PanelDAO.
     *
     * @return Une instance de PanelDAO.
     */
    public PanelDAO getPanelDAO() {
        if (panelDAO == null) {
            panelDAO = new PanelDAOImpl();
        }
        return panelDAO;
    }

    /**
     * Retourne l'implémentation associée à la factory du ClientDAO.
     *
     * @return Une instance de ClientDAO.
     */
    public ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
}
