package fr.sigl.epita.imoe.minigrc.servlets;

import fr.sigl.epita.imoe.minigrc.bo.UserloginBO;

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
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    /**
     * Generated Serial Version UID.
     */
    private static final long serialVersionUID = 8814373079661691995L;

    /**
     * Logger JUL.
     */
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    /**
     * Surcharge de la méthode service qui effectue les traitements indépendamment du type de requète.
     *
     * @param request  La requète HTTP.
     * @param response La réponse HTTP.
     * @throws ServletException Exception générique pour le traitement de la servlet.
     * @throws IOException      Exception générique d'entrée / sortie.
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equals("GET")) {
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("user")) {
                    cookies[i].setValue("");
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
        } else if (method.equals("POST")) {
            String login = request.getParameter("login_form");
            String password = request.getParameter("password_form");
            UserloginBO userloginBO = new UserloginBO();
            String region = userloginBO.checkLogin(login, password);
            if (region != null) {
                response.addCookie(new Cookie("user", login));
                response.addCookie(new Cookie("region", region));
                response.sendRedirect("mainpage");
            } else {
                request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect.");
                request.getRequestDispatcher("login_MINIGRC.jsp").forward(request, response);
            }
        }
    }
}
