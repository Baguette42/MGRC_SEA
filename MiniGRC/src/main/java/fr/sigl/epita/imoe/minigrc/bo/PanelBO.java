package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;
import fr.sigl.epita.imoe.minigrc.servlets.utils.MailResult;
import fr.sigl.epita.imoe.minigrc.servlets.utils.MailService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Chaf on 12/29/2015.
 */
public class PanelBO {

    /**
     * Crée un nouveau panel
     *
     * @param name         Le nom du panel
     * @param min_age      L'age minimum des clients dans le panel
     * @param max_age      L'age maximum des clients dans le panel
     * @param region       La region des clients dans le panel
     * @param type         Le profil des clients dans le panel
     */
    public void createPanel(String name, String min_age, String max_age, String region, String type) {
        PanelEntity panelEntity = new PanelEntity();
        panelEntity.setPanelNom(name);
        panelEntity.setPanelAgemini(min_age);
        panelEntity.setPanelAgemaxi(max_age);
        panelEntity.setPanelRegion(region);
        panelEntity.setPanelProfil(type);

        DAOFactory.getInstance().getPanelDAO().persist(panelEntity);
    }

    /**
     * Retourne la liste des panels dans une région spécifique
     *
     * @param region   La région des panels
     * @return La liste des panels dans une région spécifique
     */
    public static List searchPanelsWithRegion(String region) {
        List panelList = new ArrayList<>();
        PanelEntity panelEntity = new PanelEntity();
        panelEntity.setPanelRegion(region);

        panelList = DAOFactory.getInstance().getPanelDAO().findByExample(panelEntity);

        return panelList;
    }

    /**
     * Envoi des emails aux clients dans un panel
     *
     * @param panelId    L'identifiant du panel
     * @param message    Le message à envoyer aux clients
     * @return Un objet MailResult avec les informations sur les envois de mail
     */
    public MailResult sendEmails(String panelId, String message) {
        PanelEntity panelEntity = DAOFactory.getInstance().getPanelDAO().findById(Integer.parseInt(panelId));

        ClientEntity clientEntity = new ClientEntity();
        List clientList = DAOFactory.getInstance().getClientDAO().findByExample(clientEntity);

        List result = new ArrayList<>();
        for (int i = 0; i < clientList.size(); ++i) {
            ClientEntity clientInList = (ClientEntity) clientList.get(i);
            int age = findClientAge(clientInList.getClientNaissance());
            if (clientInList.getClientRegion().equals(panelEntity.getPanelRegion())
                    && (panelEntity.getPanelProfil().equals("both") || clientInList.getClientProfil().equals(panelEntity.getPanelProfil()))
                    && age >= Integer.parseInt(panelEntity.getPanelAgemini())
                    && age <= Integer.parseInt(panelEntity.getPanelAgemaxi())) {
                result.add(clientInList);
            }
        }

        return MailService.sendMessageToClients(message, result);
    }

    /**
     * Retourne l'age d'un client en fonction de sa date de naissance
     *
     * @param naissance  La date de naissance d'un client
     * @return l'age d'un client
     */
    public int findClientAge(Date naissance) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(naissance);
        Calendar today = Calendar.getInstance();
        int clientAge = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < calendar.get(Calendar.MONTH)) {
            clientAge--;
        } else if (today.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH)) {
            clientAge--;
        }

        return clientAge;
    }
}
