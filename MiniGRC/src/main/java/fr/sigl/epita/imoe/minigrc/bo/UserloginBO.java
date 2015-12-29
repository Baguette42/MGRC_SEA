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

    public String[] checkLogin(String login, String password) {
        UserloginEntity userlogin = new UserloginEntity();
        userlogin.setUserLogin(login);
        userlogin.setUserPassword(password);

        String[] regionAndLastConnexion = new String[2];

        if (null == login && null == password)
            return regionAndLastConnexion;

        List userloginList = DAOFactory.getInstance().getUserloginDAO().findByExample(userlogin);

        if (!userloginList.isEmpty()) {
            UserloginEntity userloginEntity = new UserloginEntity();
            userloginEntity = (UserloginEntity) userloginList.get(0);
            regionAndLastConnexion[0] = userloginEntity.getUserRegion();
            regionAndLastConnexion[1] = userloginEntity.getUserLastconnexion().toString();
            userloginEntity.setUserLastconnexion(new Date(Calendar.getInstance().getTime().getTime()));
            DAOFactory.getInstance().getUserloginDAO().merge(userloginEntity);
        }

        return regionAndLastConnexion;
    }

}
