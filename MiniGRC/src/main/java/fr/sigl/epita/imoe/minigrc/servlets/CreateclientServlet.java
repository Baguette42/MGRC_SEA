package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;
import fr.sigl.epita.imoe.minigrc.dao.DAOFactory;

import java.io.IOException;
import java.sql.Date;
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
        name = "CreateclientServlet",
        urlPatterns = {"/createclient"}
)
public class CreateclientServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(CreateclientServlet.class.getName());

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
                request.getRequestDispatcher("createClient_MINIGRC.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Vous devez être connecté pour accéder à cette page.");
                request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
            }
        } else if (method.equals("POST")) {
            ClientEntity newClient = new ClientEntity();
            newClient.setClientCivilite(request.getParameter("client_civilite"));
            newClient.setClientNom(request.getParameter("client_nom"));
            newClient.setClientPrenom(request.getParameter("client_prenom"));
            newClient.setClientNaissance(Date.valueOf(request.getParameter("client_date")));
            newClient.setClientAdresse(request.getParameter("client_adresse"));
            newClient.setClientTelephone(request.getParameter("client_telephone"));
            newClient.setClientEmail(request.getParameter("client_email"));
            newClient.setClientFacebook(request.getParameter("client_facebook"));
            newClient.setClientTwitter(request.getParameter("client_twitter"));
            newClient.setClientLinkedin(request.getParameter("client_linkedin"));
            newClient.setClientProfil(request.getParameter("client_type"));
            newClient.setClientRegion(request.getParameter("client_region"));
            newClient.setClientEmailrefus(Boolean.valueOf(request.getParameter("client_emailing")));

            DAOFactory.getInstance().getClientDAO().persist(newClient);

            request.getRequestDispatcher("clientlist_MINIGRC.jsp").forward(request, response);
        }
    }
}
