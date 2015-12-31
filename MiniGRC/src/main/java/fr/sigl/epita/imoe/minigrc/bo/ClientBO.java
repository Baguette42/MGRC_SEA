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

    /**
     * Crée un nouveau client en fonction des paramètres passés
     *
     * @param client_civilite          Le statut civil du client
     * @param client_date              La date de naissance du client
     * @param client_adresse           L'adresse du client
     * @param client_email             L'adresse email du client
     * @param client_emailing          Le statut d'acceptation des emails du client
     * @param client_facebook          L'url facebook du client
     * @param client_linkedin          L'url linkedIn du client
     * @param client_nom               Le nom du client
     * @param client_prenom            Le prénom du client
     * @param client_region            La région du client
     * @param client_telephone         Le téléphone du client
     * @param client_twitter           L'url twitter du client
     * @param client_type              Le profil du client
     *
     */
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

    /**
     * Met à jour le client sélectionné
     *
     * @param clientEntity        L'instance du client à mettre à jour
     */
    public void updateClient(ClientEntity clientEntity) {
    	

        DAOFactory.getInstance().getClientDAO().update(clientEntity);
    }

    /**
     * Recherche les clients appartenant à une région spécifique en fonction de son prénom
     * ou de son nom
     *
     * @param lastname_searchform         Le prénom du client
     * @param firstname_searchform        Le nom du client
     * @param region                      La région des clients
     * @return La liste des clients répondant aux critères
     */
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

    /**
     * Retourne le client associé à l'identifiant passé en paramètre.
     *
     * @param  selectedClientId                L'identifiant technique du client.
     * @return L'instance du client correspondant à l'identifiant technique.
     */
    public ClientEntity getClient(String selectedClientId) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity = DAOFactory.getInstance().getClientDAO().findById(Integer.parseInt(selectedClientId));

        return clientEntity;
    }

    /**
     * Retourne la liste des événements associés à un client
     *
     * @param clientEntity           Le client auquel les événements sont associés
     * @return La liste des événements associés au client passé en paramètre
     */
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

    /**
     * Retourne la liste des nouveaux clients depuis la dernière connexion de l'utilisateur
     *
     * @param region          La région de l'utilisateur
     * @param lastConnexion   Le date de la dernière connexion de l'utilisateur
     * @return La liste des nouveaux clients depuis la dernière connexion de l'utilisateur passé en paramètre
     */
    public List getNewClients(String region, String lastConnexion) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientRegion(region);
        List clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        Date lastConnexionDate = Date.valueOf(lastConnexion);

        List<ClientEntity> result = new ArrayList<>();
        for (int i = 0; i < clientList.size(); ++i) {
            ClientEntity clientInList = (ClientEntity) clientList.get(i);
            if (clientInList.getClientDatecreation().compareTo(lastConnexionDate) > 0) {
                result.add(clientInList);
            }
        }

        return result;
    }
}
