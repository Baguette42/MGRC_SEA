package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;

import java.util.List;

/**
 * Interface du DAO pour les panels.
 *
 * @author Chaf
 */
public interface PanelDAO {

    /**
     * Ajoute un nouvel panel à la base.
     *
     * @param  transientInstance           Une instance de panel.
     */
    void persist(PanelEntity transientInstance);

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance de panel.
     */
    void attachDirty(PanelEntity instance);

    /**
     * Rattache une instance à la session avec un mode de verrouillage défini.
     *
     * @param  instance                    Une instance de panel.
     */
    void attachClean(PanelEntity instance);

    /**
     * Supprime un panel.
     *
     * @param  persistentInstance                    Une instance de panel.
     */
    void delete(PanelEntity persistentInstance);

    /**
     * Fusionne l'état persistent avec l'état détaché de une instance.
     *
     * @param  detachedInstance                    Une instance de panel.
     */
    PanelEntity merge(PanelEntity detachedInstance);

    /**
     * Retourne le panel associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique du panel.
     * @return L'instance du panel correspondant à l'identifiant technique.
     */
    PanelEntity findById(int id);

    /**
     * Retourne la liste des panels semblables au panel passé en paramètre.
     *
     * @param  instance                     Le panel utilisé pour la comparaison.
     * @return L'instance du panel semblable au panel passé en paramètre.
     */
    List findByExample(PanelEntity instance);
}
