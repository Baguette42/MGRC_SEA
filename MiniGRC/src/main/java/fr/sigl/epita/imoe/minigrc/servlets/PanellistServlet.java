package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.bo.PanelBO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
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
        name = "PanellistServlet",
        urlPatterns = {"/panellist"}
)
public class PanellistServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(PanellistServlet.class.getName());

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
        for (Cookie c : cookies) {
            if (c.getName().equals("user"))
                token = c;
            if (c.getName().equals("region"))
                region = c;
        }

        if (token != null) {
            PanelBO panelBO = new PanelBO();
            List clientList = PanelBO.searchPanelsWithRegion(region.getValue());
            request.setAttribute("panelList", clientList);
            request.getRequestDispatcher("panellist_MINIGRC.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
            request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
        }
    }
}
