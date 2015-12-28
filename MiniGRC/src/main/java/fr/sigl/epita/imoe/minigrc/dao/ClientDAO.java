package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;

import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public interface ClientDAO {

    void persist(ClientEntity transientInstance);

    void attachDirty(ClientEntity instance);

    void attachClean(ClientEntity instance);

    void delete(ClientEntity persistentInstance);

    ClientEntity merge(ClientEntity detachedInstance);

    ClientEntity findById(int id);

    List findByExample(ClientEntity instance);
}
