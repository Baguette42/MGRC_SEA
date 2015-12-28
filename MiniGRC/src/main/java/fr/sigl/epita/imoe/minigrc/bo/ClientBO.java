package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        DAOFactory.getInstance().getClientDAO().persist(clientEntity);
    }

    public List searchClients(String lastname_searchform, String firstname_searchform) {

        List clientList = new ArrayList<>();

        ClientEntity clientEntity = new ClientEntity();
        if (!Objects.equals(lastname_searchform, ""))
            clientEntity.setClientNom(lastname_searchform);
        if (!Objects.equals(firstname_searchform, ""))
            clientEntity.setClientPrenom(firstname_searchform);
        clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        return clientList;
    }

    public ClientEntity getClient(String selectedClientId) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity = DAOFactory.getInstance().getClientDAO().findById(Integer.parseInt(selectedClientId));

        return clientEntity;
    }
}
