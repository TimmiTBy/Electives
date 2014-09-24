package com.epam.electives.filter;

import com.epam.electives.entity.UserRole;
import com.epam.electives.util.Constants;
import com.epam.electives.util.PageManager;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter to protect Servlet from user(guest) which has no right to access it(not authorised in the system user)
 */
public class ServletSecurityFilter implements Filter {

    static final Logger LOG = Logger.getLogger(ServletSecurityFilter.class);

    @Override
    public void destroy() {

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
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        UserRole type = (UserRole) session.getAttribute(Constants.ATTRIB_USER_ROLE);
        String type2 = (String) req.getParameter(Constants.PARAM_USER_ROLE);
        if (type == null & type2 == null) {
            type = UserRole.GUEST;
            session.setAttribute(Constants.ATTRIB_USER_ROLE, type);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(PageManager.getPage("path.page.index"));
            dispatcher.forward(req, resp);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
