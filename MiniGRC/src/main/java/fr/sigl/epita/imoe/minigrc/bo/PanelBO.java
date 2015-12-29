package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.beans.PanelEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;
import fr.sigl.epita.imoe.minigrc.servlets.utils.MailService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Chaf on 12/29/2015.
 */
public class PanelBO {

    public void createPanel(String name, String min_age, String max_age, String region, String type) {
        PanelEntity panelEntity = new PanelEntity();
        panelEntity.setPanelNom(name);
        panelEntity.setPanelAgemini(min_age);
        panelEntity.setPanelAgemaxi(max_age);
        panelEntity.setPanelRegion(region);
        panelEntity.setPanelProfil(type);

        DAOFactory.getInstance().getPanelDAO().persist(panelEntity);
    }

    public static List searchPanelsWithRegion(String region) {
        List panelList = new ArrayList<>();
        PanelEntity panelEntity = new PanelEntity();
        panelEntity.setPanelRegion(region);

        panelList = DAOFactory.getInstance().getPanelDAO().findByExample(panelEntity);

        return panelList;
    }

    public void sendEmails(String panelId, String message) {
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

        MailService.sendMessageToClients(message, result);
    }
    
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
