package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public class UserloginBO {

    public String checkLogin(String login, String password) {
        UserloginEntity userlogin = new UserloginEntity();
        userlogin.setUserLogin(login);
        userlogin.setUserPassword(password);
        List userloginList = DAOFactory.getInstance().getUserloginDAO().findByExample(userlogin);

        String region = null;

        if (!userloginList.isEmpty()) {
            UserloginEntity userloginEntity = new UserloginEntity();
            userloginEntity = (UserloginEntity) userloginList.get(0);
            region = userloginEntity.getUserRegion();
            userloginEntity.setUserLastconnexion(new Date(Calendar.getInstance().getTime().getTime()));
            DAOFactory.getInstance().getUserloginDAO().merge(userloginEntity);
        }

        return region;
    }

}
