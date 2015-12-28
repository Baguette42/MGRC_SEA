package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;

import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public interface EvenementDAO {

    void persist(EvenementEntity transientInstance);

    void attachDirty(EvenementEntity instance);

    void attachClean(EvenementEntity instance);

    void delete(EvenementEntity persistentInstance);

    EvenementEntity merge(EvenementEntity detachedInstance);

    EvenementEntity findById(int id);

    List findByExample(EvenementEntity instance);
}
