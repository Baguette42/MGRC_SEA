package fr.sigl.epita.imoe.minigrc.bo;

import fr.sigl.epita.imoe.minigrc.beans.UserloginEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.util.List;

/**
 * Created by Chaf on 12/28/2015.
 */
public class UserloginBO {

    public boolean checkLogin(String login, String password) {
        UserloginEntity userlogin = new UserloginEntity();
        userlogin.setUserLogin(login);
        userlogin.setUserPassword(password);
        List userloginList = DAOFactory.getInstance().getUserloginDAO().findByExample(userlogin);

        return !userloginList.isEmpty();
    }

}
