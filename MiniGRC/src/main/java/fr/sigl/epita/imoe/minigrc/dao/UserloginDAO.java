package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;

import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public interface UserloginDAO {

    void persist(UserloginEntity transientInstance);

    void attachDirty(UserloginEntity instance);

    void attachClean(UserloginEntity instance);

    void delete(UserloginEntity persistentInstance);

    UserloginEntity merge(UserloginEntity detachedInstance);

    UserloginEntity findById(int id);

    List findByExample(UserloginEntity instance);
}
