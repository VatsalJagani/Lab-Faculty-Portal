/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package gen.security;

import gen.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VATSAL
 */
public class SecurityFilter implements Filter {

    /* filter for security */
    private FilterConfig filterConfig = null;

    public SecurityFilter() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String requestURI = request.getRequestURI();
        String root = request.getServletContext().getInitParameter("Root");
        String loginURI = root+"login.jsp";
        String exclude=root+"styles/";

        System.out.println(requestURI+" "+loginURI);
        User user;
        if(requestURI.startsWith(exclude)){
            chain.doFilter(request, response);
        }
        else if(requestURI.equals(loginURI) || requestURI.contains("doLogin")){
            chain.doFilter(request, response);
        }
        else if(session != null){
            if((user=(User)session.getAttribute("user"))!=null){
                if (requestURI.startsWith(root + "sp/admin")) {     /*  subject preferences admin privileges  */
                    if ((user.getUserType()).equals("admin_sp")) {
                        chain.doFilter(request, response);
                    } else {
                        response.sendRedirect(loginURI+"?msg=You are tring to get into more privilege area!!");
                    }
                } else if (requestURI.startsWith(root + "lm/admin")) {      /*  leave management admin privileges  */

                    if ((user.getUserType()).equals("admin")) {
                        chain.doFilter(request, response);
                    } else {
                        response.sendRedirect(loginURI+"?msg=You are tring to get into more privilege area!!");
                    }
                }
                else if (requestURI.startsWith(root + "user")) {      /*  leave management admin privileges  */

                    if ((user.getUserType()).equals("admin")) {
                        chain.doFilter(request, response);
                    } else {
                        response.sendRedirect(loginURI+"?msg=You are tring to get into more privilege area!!");
                    }
                }
                else if (requestURI.startsWith(root + "admin")) {     /*  subject preferences admin privileges  */
                    if ((user.getUserType()).equals("admin")) {
                        chain.doFilter(request, response);
                    } else {
                        response.sendRedirect(loginURI+"?msg=You are tring to get into more privilege area!!");
                    }
                }
                else {
                    //System.out.println("chain next");
                    chain.doFilter(request, response);
                }
            }
            else{
                response.sendRedirect(loginURI+"?msg=You are not logged-In!!");
            }
        }
        else{
            response.sendRedirect(loginURI);
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}