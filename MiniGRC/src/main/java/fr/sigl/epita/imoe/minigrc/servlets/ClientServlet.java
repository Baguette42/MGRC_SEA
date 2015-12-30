package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.bo.ClientBO;

import java.io.IOException;
import java.util.ArrayList;
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
        name = "ClientServlet",
        urlPatterns = {"/client"}
)
public class ClientServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(ClientServlet.class.getName());

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
            ClientBO clientBO = new ClientBO();
            ClientEntity clientEntity = clientBO.getClient(request.getParameter("selectedClientId"));
            request.setAttribute("client", clientEntity);

            List eventList = new ArrayList<>();
            eventList = clientBO.getClientEvenements(clientEntity);
            request.setAttribute("eventList", eventList);

            response.addCookie(new Cookie("clientId", request.getParameter("selectedClientId")));
            request.getRequestDispatcher("client_MINIGRC.jsp").forward(request, response);
            
        } else if (method.equals("POST")) {
            ClientBO clientBO = new ClientBO();
            
            ClientEntity clientEntity = clientBO.getClient(request.getParameter("selectedClientId"));
            request.setAttribute("client", clientEntity);
            
            clientEntity.setClientCivilite(request.getParameter("client_civilite"));
            clientEntity.setClientNom(request.getParameter("client_nom"));
            clientEntity.setClientPrenom(request.getParameter("client_prenom"));
            clientEntity.setClientAdresse(request.getParameter("client_adresse"));
            clientEntity.setClientTelephone(request.getParameter("client_telephone"));
            clientEntity.setClientEmail(request.getParameter("client_email"));
            clientEntity.setClientProfil(request.getParameter("client_type"));
            clientEntity.setClientRegion(request.getParameter("client_region"));
            
            clientBO.updateClient(clientEntity);

            response.sendRedirect("clientlist");
        }
        
    }
}
