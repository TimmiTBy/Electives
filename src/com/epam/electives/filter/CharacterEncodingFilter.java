package com.epam.electives.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * filter for UTF-8 encoding
 *
 */
public class CharacterEncodingFilter implements Filter {

    private String code="UTF-8";
    static final Logger LOG = Logger.getLogger(CharacterEncodingFilter.class);

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();
        if (code!=null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
            chain.doFilter(request, response);
        }

    }

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        code = config.getInitParameter("encoding");
    }

    /**
     *
     */
    @Override
    public void destroy() {
        code = null;
    }
}
