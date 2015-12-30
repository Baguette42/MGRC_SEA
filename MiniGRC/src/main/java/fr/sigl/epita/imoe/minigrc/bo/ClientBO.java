package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.sql.Date;
import java.util.*;

/**
 * Created by Chaf on 12/29/2015.
 */
public class ClientBO {

    public void createClient(String client_civilite, String client_nom, String client_prenom, String client_date, String client_adresse, String client_telephone, String client_email, String client_facebook, String client_twitter, String client_linkedin, String client_type, String client_region, String client_emailing) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientCivilite(client_civilite);
        clientEntity.setClientNom(client_nom);
        clientEntity.setClientPrenom(client_prenom);
        clientEntity.setClientNaissance(Date.valueOf(client_date));
        clientEntity.setClientAdresse(client_adresse);
        clientEntity.setClientTelephone(client_telephone);
        clientEntity.setClientEmail(client_email);
        clientEntity.setClientFacebook(client_facebook);
        clientEntity.setClientTwitter(client_twitter);
        clientEntity.setClientLinkedin(client_linkedin);
        clientEntity.setClientProfil(client_type);
        clientEntity.setClientRegion(client_region);
        clientEntity.setClientEmailrefus(Boolean.valueOf(client_emailing));
        clientEntity.setClientDatecreation(new Date(Calendar.getInstance().getTime().getTime()));

        DAOFactory.getInstance().getClientDAO().persist(clientEntity);
    }
    
    public void updateClient(ClientEntity clientEntity) {
    	

        DAOFactory.getInstance().getClientDAO().update(clientEntity);
    }

    public List searchClientsWithRegion(String lastname_searchform, String firstname_searchform, String region) {

        List clientList = new ArrayList<>();

        ClientEntity clientEntity = new ClientEntity();
        if (!Objects.equals(lastname_searchform, ""))
            clientEntity.setClientNom(lastname_searchform);
        if (!Objects.equals(firstname_searchform, ""))
            clientEntity.setClientPrenom(firstname_searchform);
        clientEntity.setClientRegion(region);
        clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        return clientList;
    }

    public ClientEntity getClient(String selectedClientId) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity = DAOFactory.getInstance().getClientDAO().findById(Integer.parseInt(selectedClientId));

        return clientEntity;
    }

    public List getClientEvenements(ClientEntity clientEntity) {
        List eventList = new ArrayList<>();
        EvenementEntity evenementEntity = new EvenementEntity();
        evenementEntity.setEventClientId(clientEntity.getClientId());
        eventList = DAOFactory.getInstance().getEvenementDAO().findByExample(evenementEntity);
        Collections.sort(eventList, new Comparator<EvenementEntity>() {
            @Override
            public int compare(EvenementEntity e1, EvenementEntity e2) {
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });

        return eventList;

    }

    public List getNewClients(String userName) {
        UserloginEntity userloginEntity = new UserloginEntity();
        userloginEntity.setUserLogin(userName);
        List userList = DAOFactory.getInstance().getUserloginDAO().findByExample(userloginEntity);

        userloginEntity = (UserloginEntity) userList.get(0);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientRegion(userloginEntity.getUserRegion());
        List clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        List result = new ArrayList<>();
        for (int i = 0; i < clientList.size(); ++i) {
            ClientEntity clientInList = (ClientEntity) clientList.get(i);
            if (clientInList.getClientDatecreation().compareTo(userloginEntity.getUserLastconnexion()) > 0) {
                result.add(clientInList);
            }
        }

        return result;
    }
}
