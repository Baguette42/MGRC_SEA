package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.bo.EvenementBO;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
        name = "CreateeventServlet",
        urlPatterns = {"/createevent"}
)
public class CreateeventServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(CreateeventServlet.class.getName());

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
            Cookie clientId = null;
            for (Cookie c : cookies) {
                if (c.getName().equals("user"))
                    token = c;
                if (c.getName().equals("clientId"))
                    clientId = c;
            }

            if (token != null) {
                request.setAttribute("createur", token.getValue());
                request.setAttribute("date", new Date(Calendar.getInstance().getTime().getTime()));
                request.getRequestDispatcher("createEvent_MINIGRC.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
                request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
            }
        } else if (method.equals("POST")) {
            Cookie[] cookies = request.getCookies();
            Cookie clientId = null;
            for (Cookie c : cookies) {
                if (c.getName().equals("clientId"))
                    clientId = c;
            }
            EvenementBO evenementBO = new EvenementBO();
            evenementBO.createEvent(clientId.getValue(),
                    request.getParameter("type"),
                    request.getParameter("createur"),
                    request.getParameter("date"),
                    request.getParameter("description"));

            response.sendRedirect("/client?selectedClientId=" + clientId.getValue());
        }

    }
}
