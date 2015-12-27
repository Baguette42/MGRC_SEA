package fr.sigl.epita.imoe.minigrc.dao;

import java.util.List;

import fr.sigl.epita.imoe.minigrc.dao.exceptions.DAORequestException;
import fr.sigl.epita.imoe.minigrc.bo.TypeEvenement;

/**
 * Interface du DAO pour les types d'événements.
 *
 * @author Chris
 */
public interface TypeEvenementDAO {
    /**
     * Retourne la liste des types existants.
     *
     * @return la liste des types.
     * @exception DAORequestException      Exception générique lors de l'accés à la base.
     */
    List<TypeEvenement> getTypesEvenements() throws DAORequestException;


    /**
     * Retourne le type d'événement associée à l'id spécifié en paramétre.
     *
     * @param  id                           L'identifiant technique du type.
     * @return L'instance du type correspondant à l'identifiant technique.
     * @exception  DAORequestException      Exception générique lors de l'accés à la base.
     */
    TypeEvenement getTypeEvenement(String id) throws DAORequestException;
}
