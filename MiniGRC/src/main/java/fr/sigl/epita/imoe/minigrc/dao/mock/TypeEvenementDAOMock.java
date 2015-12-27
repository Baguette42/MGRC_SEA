package fr.sigl.epita.imoe.minigrc.dao.mock;

import java.util.ArrayList;
import java.util.List;

import fr.sigl.epita.imoe.minigrc.dao.TypeEvenementDAO;
import fr.sigl.epita.imoe.minigrc.dao.exceptions.DAORequestException;
import fr.sigl.epita.imoe.minigrc.bo.TypeEvenement;

/**
 * Implémentation bouchon du DAO pour les types d'événements.
 *
 * @author Chris
 */
public class TypeEvenementDAOMock implements TypeEvenementDAO {
    /**
     * Liste des types d'événements sous forme de mock.
     */
    private List<TypeEvenement> types = new ArrayList<TypeEvenement>();

    /**
     * Constructeur par défaut permettant d'initialiser la
     * liste des événements avec des cas d'exemple.
     */
    public TypeEvenementDAOMock() {
        super();
        types.add(new TypeEvenement("1", "Rendez-vous"));
        types.add(new TypeEvenement("2", "Anniversaire"));
        types.add(new TypeEvenement("3", "Réunion"));
        types.add(new TypeEvenement("4", "Congés"));
        types.add(new TypeEvenement("5", "Autres"));
        
    }

    /**
     * Retourne la liste des types existants.
     *
     * @return la liste des types.
     * @exception DAORequestException      Exception générique lors de l'accés à la base.
     * @see TypeEvenementDAO#getTypesEvenements()
     */
    @Override
    public List<TypeEvenement> getTypesEvenements() throws DAORequestException {
        return types;
    }

    /**
     * Retourne le type d'événement associée à l'id spécifié en paramétre.
     *
     * @param  id                           L'identifiant technique du type.
     * @return L'instance du type correspondant à l'identifiant technique.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     * @see TypeEvenementDAO#getTypeEvenement(java.lang.String)
     */
    @Override
    public TypeEvenement getTypeEvenement(String id) throws DAORequestException {
        if (id == null) {
            throw new DAORequestException("L'identifiant est obligatoire pour rechercher le type d'événements");
        }
        for (TypeEvenement type : types) {
            if (id.equals(type.getId())) {
                return type;
            }
        }
        throw new DAORequestException("Aucun type d'événement ne correspondant à l'identifiant <" + id + ">");
    }

}
