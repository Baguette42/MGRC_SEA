package fr.sigl.epita.imoe.minigrc.dao;

import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;

import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public interface PanelDAO {

    void persist(PanelEntity transientInstance);

    void attachDirty(PanelEntity instance);

    void attachClean(PanelEntity instance);

    void delete(PanelEntity persistentInstance);

    PanelEntity merge(PanelEntity detachedInstance);

    PanelEntity findById(int id);

    List findByExample(PanelEntity instance);
}
