/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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
 * @author Jaren
 */
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        //int role = Integer.parseInt((String)session.getAttribute("role"));
        int role = (int) session.getAttribute("role");
        
        if(role != 1) {
            
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("inventory");
            return;
        } 
        
        // Any code before chain.doFilter() will be executed before the servlet
        chain.doFilter(request, response);
        // Any code after chain.doFilter() will be executed after the servlet
    }

    // These methods will not be used, however then do need to exist
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
 
}
