package com.epam.electives.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter to protect jsp from manual access (when someone trying to type adress manually)
 */
public class PageSecurityFilter implements Filter {

    static final Logger LOG = Logger.getLogger(PageSecurityFilter.class);
    private String indexPath;

    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        indexPath = filterConfig.getInitParameter("INDEX_PATH");
    }

    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
