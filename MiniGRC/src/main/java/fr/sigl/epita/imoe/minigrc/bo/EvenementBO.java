package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.sql.Date;
import java.util.*;

/**
 * Created by Chaf on 12/29/2015.
 */
public class EvenementBO {

    /**
     * Crée un nouvel événement
     *
     * @param clientId        L'identifiant du client concerné par l'événement
     * @param type            Le type de l'événement
     * @param createur        Le créateur de l'événement
     * @param date            La date de l'événement
     * @param description     La description de l'événement
     */
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

    /**
     * Met à jour un événement
     *
     * @param event      L'événement à mettre à jour
     */
    public void updateEvent(EvenementEntity event) {

        DAOFactory.getInstance().getEvenementDAO().update(event);
    }

    /**
     * Retourne la liste des événements dans une région spécifique en fonction de leur type
     * ou de leur date
     *
     * @param type_searchform     Le type de l'événement
     * @param date_searchform     La date de l'événement
     * @param region              La région dans laquelle rechercher les événements
     * @return La liste des événements répondant aux critères
     */
    public List searchEventsWithRegion(String type_searchform, String date_searchform, String region) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientRegion(region);
        List clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        List evenementList = new ArrayList<>();

        for (int i = 0; i < clientList.size(); ++i) {
            ClientEntity clientInList = (ClientEntity) clientList.get(i);
            EvenementEntity evenementEntity = new EvenementEntity();
            if (!Objects.equals(type_searchform, ""))
                evenementEntity.setEventType(type_searchform);
            if (null != date_searchform && !Objects.equals(date_searchform, ""))
                evenementEntity.setEventDate(Date.valueOf(date_searchform));
            evenementEntity.setEventClientId(clientInList.getClientId());
            evenementList.addAll(DAOFactory.getInstance().getEvenementDAO().findByExample(evenementEntity));
        }

        Collections.sort(evenementList, new Comparator<EvenementEntity>() {
            @Override
            public int compare(EvenementEntity e1, EvenementEntity e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });

        return evenementList;
    }

    /**
     * Retourne l'événement associé à l'identifiant passé en paramètre.
     *
     * @param  selectedEventId                           L'identifiant technique de l'événement.
     * @return L'instance de l'événement correspondant à l'identifiant technique.
     */
    public EvenementEntity getEvenement(String selectedEventId) {
        EvenementEntity evenementEntity = DAOFactory.getInstance().getEvenementDAO().findById(Integer.parseInt(selectedEventId));

        return evenementEntity;
    }

    /**
     * Retourne la liste des dix derniers événements auquel un utilisateur à accés
     *
     * @param userName   Le nom de l'utilisateur
     * @return La liste des dix derniers événements auquel un utilisateur à accés
     */
    public List getLastTenEvents(String userName) {
        UserloginEntity userloginEntity = new UserloginEntity();
        userloginEntity.setUserLogin(userName);
        List userList = DAOFactory.getInstance().getUserloginDAO().findByExample(userloginEntity);

        userloginEntity = (UserloginEntity) userList.get(0);

        List eventList = searchEventsWithRegion("", "", userloginEntity.getUserRegion());

        Collections.sort(eventList, new Comparator<EvenementEntity>() {
            @Override
            public int compare(EvenementEntity e1, EvenementEntity e2) {
                return e2.getEventLastupdate().compareTo(e1.getEventLastupdate());
            }
        });
        if (eventList.size() > 10)
            return eventList.subList(0, 9);
        else
            return eventList;
    }
}
