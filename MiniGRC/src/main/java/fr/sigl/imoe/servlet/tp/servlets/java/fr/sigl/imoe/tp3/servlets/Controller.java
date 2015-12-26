package fr.sigl.imoe.tp3.servlets;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(
        name = "ControllerServlet",
        urlPatterns = {"/contacts"}
)public class Controller extends HttpServlet {
	/**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691985L;

    /**
     * Logger JUL.s
     */
    private static final Logger LOGGER = Logger.getLogger(ListingServlet.class.getName());

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
    	
    	Evenement selectedEvent = null;

        // Récupération de la liste des événements disponibles
    	EvenementDAO currentEventDAO = DAOFactory.getInstance().getEvenementDAO();
        // Alimentation de la request avec les informations trouvées
    	String id = request.getParameter("selectedEventId");
    	
    	try {
			selectedEvent = currentEventDAO.getEvenement(id);
		} catch (DAORequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	RequestDispatcher requestD;
    	
    	request.setAttribute("selectedEvent", selectedEvent);

    	
    	requestD = request.getRequestDispatcher("contacts.jsp");
    	requestD.forward(request, response);
        // Ajouter le forward vers la page JSP accueil.jsp
    	//response.sendRedirect("contacts.jsp");
    }
}
