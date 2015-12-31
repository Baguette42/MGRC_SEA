package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;

import java.util.List;

/**
 * Interface du DAO pour les événements.
 *
 * @author Chaf
 */
public interface EvenementDAO {

    /**
     * Ajoute un nouvel événement à la base.
     *
     * @param  transientInstance           Une instance d'événement.
     */
    void persist(EvenementEntity transientInstance);

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance d'événement.
     */
    void attachDirty(EvenementEntity instance);

    /**
     * Rattache une instance à la session avec un mode de verrouillage défini.
     *
     * @param  instance                    Une instance d'événement.
     */
    void attachClean(EvenementEntity instance);

    /**
     * Supprime un événement.
     *
     * @param  persistentInstance                    Une instance d'événement.
     */
    void delete(EvenementEntity persistentInstance);

    /**
     * Fusionne l'état persistent avec l'état détaché d'une instance.
     *
     * @param  detachedInstance                    Une instance d'événement.
     */
    EvenementEntity merge(EvenementEntity detachedInstance);

    /**
     * Retourne l'événement associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique de l'événement.
     * @return L'instance de l'événement correspondant à l'identifiant technique.
     */
    EvenementEntity findById(int id);

    /**
     * Retourne la liste des événements semblables à l'événement passé en paramètre.
     *
     * @param  instance                     L'événement utilisé pour la comparaison.
     * @return L'instance de l'événement semblable à l'événement passé en paramètre.
     */
    List findByExample(EvenementEntity instance);

    /**
     * Met à jour l'événement.
     *
     * @param  event                    Une instance d'événement.
     */
	void update(EvenementEntity event);
}
