package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;

import java.util.List;

/**
 * Interface du DAO pour les clients.
 *
 * @author Chaf
 */
public interface ClientDAO {

    /**
     * Ajoute un nouvel client à la base.
     *
     * @param  transientInstance           Une instance de client.
     */
    void persist(ClientEntity transientInstance);

    /**
     * Rattache une instance transiente ou détachée à la session pour une éventulle sauvegarde ou mise à jour
     *
     * @param  instance                    Une instance de client.
     */
    void attachDirty(ClientEntity instance);

    /**
     * Rattache une instance à la session avec un mode de verrouillage défini.
     *
     * @param  instance                    Une instance de client.
     */
    void attachClean(ClientEntity instance);

    /**
     * Supprime un client.
     *
     * @param  persistentInstance                    Une instance de client.
     */
    void delete(ClientEntity persistentInstance);

    /**
     * Met à jour le client.
     *
     * @param  persistentInstance                    Une instance de client.
     */
    void update(ClientEntity persistentInstance);

    /**
     * Fusionne l'état persistent avec l'état détaché de une instance.
     *
     * @param  detachedInstance                    Une instance de client.
     */
    ClientEntity merge(ClientEntity detachedInstance);

    /**
     * Retourne le client associé à l'identifiant passé en paramètre.
     *
     * @param  id                           L'identifiant technique du client.
     * @return L'instance du client correspondant à l'identifiant technique.
     */
    ClientEntity findById(int id);

    /**
     * Retourne la liste des clients semblables au client passé en paramètre.
     *
     * @param  instance                     Le client utilisé pour la comparaison.
     * @return L'instance du client semblable au client passé en paramètre.
     */
    List findByExample(ClientEntity instance);
}
