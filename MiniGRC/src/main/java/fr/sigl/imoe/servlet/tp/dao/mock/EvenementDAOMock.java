package fr.sigl.imoe.servlet.tp.dao.mock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.sigl.imoe.servlet.tp.bo.Evenement;
import fr.sigl.imoe.servlet.tp.dao.DAOFactory;
import fr.sigl.imoe.servlet.tp.dao.EvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.TypeEvenementDAO;
import fr.sigl.imoe.servlet.tp.dao.exceptions.DAORequestException;

/**
 * Implémentation bouchon du DAO pour les événements.
 *
 * @author Chris
 */
public class EvenementDAOMock implements EvenementDAO {
    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(EvenementDAOMock.class.getName());
    /**
     * Liste des événements sous forme de mock.
     */
    private List<Evenement> evenements = new ArrayList<Evenement>();
    /**
     * Dernier identifiant attribué pour les événements.
     */
    private int maxId = 0;

    /**
     * Constructeur par défaut permettant d'initialiser la
     * liste des événements avec des cas d'exemple.
     */
    public EvenementDAOMock() {
        super();
        TypeEvenementDAO typeDAO = DAOFactory.getInstance().getTypeEvenementDAO();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            // Un premier événement
            Evenement evt = new Evenement();
            evt.setTitre("IMOE - TP1");
            evt.setType(typeDAO.getTypeEvenement("3"));
            evt.setDateDebut(df.parse("05/10/2015 19:00:00"));
            evt.setDateFin(df.parse("05/10/2015 22:00:00"));
            evt.setDescription("TP sur les Servlets et JSP");
            insertEvenement(evt);

            // Secon événement d'exemple
            evt = new Evenement();
            evt.setTitre("Jour férié");
            evt.setType(typeDAO.getTypeEvenement("4"));
            evt.setDateDebut(df.parse("01/11/2015 00:00:00"));
            evt.setDateFin(df.parse("01/11/2015 23:59:59"));
            evt.setDescription("C'est la toussaint !");
            insertEvenement(evt);

            // Troisième événement d'exemple
            evt = new Evenement();
            evt.setTitre("Rendu conception");
            evt.setType(typeDAO.getTypeEvenement("5"));
            evt.setDateDebut(df.parse("31/10/2015 05:42:00"));
            evt.setDateFin(df.parse("31/10/2015 05:42:00"));
            evt.setDescription("Rendu de conception MiniGRC");
            insertEvenement(evt);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Problème lors de l'initialisation du mock pour les événements. Cause : " + e.getMessage(), e);
        }
    }

    /**
     * Retourne la liste des événements existants.
     *
     * @return la liste des événements.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.EvenementDAO#getEvenements()
     */
    @Override
    public List<Evenement> getEvenements() throws DAORequestException {
        return evenements;
    }

    /**
     * Retourne l'événement associé à l'identifiant passé en paramétre.
     *
     * @param  id                           L'identifiant technique de l'événement.
     * @return L'instance de l'événement correspondant à l'identifiant technique.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.EvenementDAO#getEvenement(java.lang.String)
     */
    @Override
    public Evenement getEvenement(String id) throws DAORequestException {
        if (id == null) {
            throw new DAORequestException("L'identifiant est obligatoire pour rechercher l'événement");
        }
        for (Evenement evt : evenements) {
            if (id.equals(evt.getId())) {
                return evt;
            }
        }
        throw new DAORequestException("Aucun événement ne correspondant à l'identifiant <" + id + ">");
    }

    /**
     * Met à jour l'événement.
     *
     * @param  evenement                    Une instance d'événement.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.EvenementDAO#updateEvenement(fr.sigl.imoe.servlet.tp.bo.Evenement)
     */
    @Override
    public void updateEvenement(Evenement evenement) throws DAORequestException {
        if (evenement == null) {
            throw new DAORequestException("Le paramètre événement ne doit pas être null.");
        }
        // Recherche de l'événement correspondant existant dans le mock et mise à jour des attributs.
        Evenement evtExistant = getEvenement(evenement.getId());
        evtExistant.setTitre(evenement.getTitre());
        evtExistant.setType(evenement.getType());
        evtExistant.setDescription(evenement.getDescription());
        evtExistant.setDateDebut(evenement.getDateDebut());
        evtExistant.setDateFin(evenement.getDateFin());
    }

    /**
     * Ajoute un nouvel événement à la base.
     *
     * @param  evenement                    Une instance d'événement.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.EvenementDAO#insertEvenement(fr.sigl.imoe.servlet.tp.bo.Evenement)
     */
    @Override
    public void insertEvenement(Evenement evenement) throws DAORequestException {
        // Assignation d'un nouvel identifiant et insertion dans la liste.
        evenement.setId(Integer.toString(++maxId));
        evenements.add(evenement);
    }

    /**
     * Efface un événement.
     *
     * @param  evenement                    Une instance d'événement.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see fr.sigl.imoe.servlet.tp.dao.EvenementDAO#deleteEvenement(fr.sigl.imoe.servlet.tp.bo.Evenement)
     */
    @Override
    public void deleteEvenement(Evenement evenement) throws DAORequestException {
        if (evenement == null) {
            throw new DAORequestException("Le paramètre événement ne doit pas être null.");
        }
        Evenement evtASupprimer = getEvenement(evenement.getId());
        evenements.remove(evtASupprimer);
    }
}
