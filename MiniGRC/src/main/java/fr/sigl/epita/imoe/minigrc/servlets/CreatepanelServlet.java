package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.bo.PanelBO;

import java.io.IOException;
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
        name = "CreatepanelServlet",
        urlPatterns = {"/createpanel"}
)
public class CreatepanelServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(CreatepanelServlet.class.getName());

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

        String method = request.getMethod();

        if (method.equals("GET")) {
            Cookie[] cookies = request.getCookies();
            Cookie token = null;
            for (Cookie c : cookies)
                if (c.getName().equals("user"))
                    token = c;

            if (token != null) {
                request.getRequestDispatcher("createPanel_MINIGRC.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
                request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
            }
        } else if (method.equals("POST")) {
            PanelBO panelBO = new PanelBO();
            panelBO.createPanel(request.getParameter("name"),
                    request.getParameter("min_age"),
                    request.getParameter("max_age"),
                    request.getParameter("region"),
                    request.getParameter("type"));

            response.sendRedirect("/panellist");
        }
    }
}
