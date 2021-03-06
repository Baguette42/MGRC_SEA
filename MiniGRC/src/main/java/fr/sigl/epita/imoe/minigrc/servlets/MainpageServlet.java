package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.bo.ClientBO;
import fr.sigl.epita.imoe.minigrc.bo.EvenementBO;
import fr.sigl.epita.imoe.minigrc.bo.UserloginBO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet permettant de gerer le login
 */
@WebServlet(
        name = "MainpageServlet",
        urlPatterns = {"/mainpage"}
)
public class MainpageServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(MainpageServlet.class.getName());

    /**
     * Surcharge de la méthode service qui effectue les traitements indépendamment du type de requète.
     *
     * @param request               La requète HTTP.
     * @param response              La réponse HTTP.
     * @throws ServletException     Exception générique pour le traitement de la servlet.
     * @throws IOException          Exception générique d'entrée / sortie.
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Cookie token = null;
        Cookie region = null;
        Cookie lastConnexion = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("user"))
                token = c;
            if (c.getName().equals("region"))
                region = c;
            if (c.getName().equals("lastConnexion"))
                lastConnexion = c;
        }

        if (null != token) {
            ClientBO clientBO = new ClientBO();
            List clientList = clientBO.getNewClients(region.getValue(), lastConnexion.getValue());
            request.setAttribute("clientList", clientList);

            EvenementBO evenementBO = new EvenementBO();
            List eventList = evenementBO.getLastTenEvents(token.getValue());
            request.setAttribute("eventList", eventList);

            request.getRequestDispatcher("mainpage_MINIGRC.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
            request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
        }
    }
}
