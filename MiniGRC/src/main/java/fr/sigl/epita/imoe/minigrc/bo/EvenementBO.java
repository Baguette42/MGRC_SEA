package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.sql.Date;

/**
 * Created by Chaf on 12/29/2015.
 */
public class EvenementBO {

    public void createEvent(String clientId, String type, String createur, String date, String description) {
        EvenementEntity evenementEntity = new EvenementEntity();
        evenementEntity.setEventClientId(Integer.parseInt(clientId));
        evenementEntity.setEventType(type);
        evenementEntity.setEventDate(Date.valueOf(date));
        evenementEntity.setEventCreateur(createur);
        evenementEntity.setEventLastupdate(Date.valueOf(date));
        evenementEntity.setEventLastupdater(createur);
        evenementEntity.setEventDescription(description);

        DAOFactory.getInstance().getEvenementDAO().persist(evenementEntity);
    }

}
