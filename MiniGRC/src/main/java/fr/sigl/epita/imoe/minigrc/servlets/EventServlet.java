package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.beans.EvenementEntity;
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
        name = "EventServlet",
        urlPatterns = {"/event"}
)
public class EventServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(EventServlet.class.getName());

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
        String username = ""; 
        for (Cookie c : cookies)
            if (c.getName().equals("user")) {
            	username = c.getValue();
                token = c;
            }

        if (token != null) {

        	String method = request.getMethod();

        	if (method.equals("GET")) {
        		EvenementBO evenementBO = new EvenementBO();
        		EvenementEntity evenementEntity = evenementBO.getEvenement(request.getParameter("selectedEventId"));
        		request.setAttribute("event", evenementEntity);

        		request.getRequestDispatcher("event_MINIGRC.jsp").forward(request, response);
        	} else if (method.equals("POST")) {
        		EvenementBO evenementBO = new EvenementBO();
        		EvenementEntity evenementEntity = evenementBO.getEvenement(request.getParameter("selectedEventId"));
        		//request.setAttribute("event", evenementEntity);

                evenementEntity.setEventType(request.getParameter("event_type"));
                evenementEntity.setEventDate(Date.valueOf(request.getParameter("event_date")));
                evenementEntity.setEventDescription(request.getParameter("event_description"));
                evenementEntity.setEventLastupdate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                evenementEntity.setEventLastupdater(username);
        		evenementBO.updateEvent(evenementEntity);
                response.sendRedirect("eventlist");

        	}
        } else {
            request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
            request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
        }
    }
}
