package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;

import java.util.List;

/**
 * Interface du DAO pour les utilisateurs.
 *
 * @author Chaf
 */
public interface UserloginDAO {

    /**
     * Ajoute un nouvel utilisateur à la base.
     *
     * @param  transientInstance           Une instance d'utilisateur.
     */
    void persist(UserloginEntity transientInstance);

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance d'utilisateur.
     */
    void attachDirty(UserloginEntity instance);

    /**
     * Rattache une instance à la session avec un mode de verrouillage défini.
     *
     * @param  instance                    Une instance d'utilisateur.
     */
    void attachClean(UserloginEntity instance);

    /**
     * Supprime un utilisateur.
     *
     * @param  persistentInstance                    Une instance d'utilisateur.
     */
    void delete(UserloginEntity persistentInstance);

    /**
     * Fusionne l'état persistent avec l'état détaché d'une instance.
     *
     * @param  detachedInstance                    Une instance d'utilisateur.
     */
    UserloginEntity merge(UserloginEntity detachedInstance);

    /**
     * Retourne l'utilisateur associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique de l'utilisateur.
     * @return L'instance de l'utilisateur correspondant à l'identifiant technique.
     */
    UserloginEntity findById(int id);

    /**
     * Retourne la liste des utilisateurs semblables à l'utilisateur passé en paramètre.
     *
     * @param  instance                     L'utilisateur utilisé pour la comparaison.
     * @return L'instance de l'utilisateur semblable à l'utilisateur passé en paramètre.
     */
    List findByExample(UserloginEntity instance);
}
