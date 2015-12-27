package fr.sigl.epita.imoe.minigrc.servlets.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtre permettant de forcer l'encoding UTF-8.
 */
@WebFilter("/*")
public class EncodingUTF8Filter implements Filter {

    /**
     * Méthode déclenchée à l'initialisation du filtre.
     *
     * @param config        Configuration du filtre.
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        // RAS
    }

    /**
     * Traitement du filtre.
     *
     * @param request       Requête.
     * @param response      Réponse.
     * @param chain         Chaîne de filtre.
     * @throws IOException Exception générique en cas d'erreur d'entrée/sortie.
     * @throws ServletException Exception générique en cas d'erreur de traitement.
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        chain.doFilter(request, response);
    }
    
    /**
     * Méthode déclenchée pour la suppression du filtre.
     *
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // RAS
    }
}
