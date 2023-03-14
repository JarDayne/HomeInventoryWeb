/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author Jaren
 */
public class LoginServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String message = "";
        HttpSession session = request.getSession();
        
        switch(action) {
            case "signin":
                String email = request.getParameter("user_email");
                String password = request.getParameter("user_password");
                
                UserService us = new UserService();
                User user=null;
                
               
                if(email == null && password == null)
                { 
               
                    message = "Missing Email & Password!";
                } else if(password == null) { 
                    
                    message = "Missing Password!";
                } else if(email == null) {
                    
                    message = "Missing Email!";
                } else {

                    user = us.loginUser(email, password);
                }

                if (user == null) {
                    message = "Invalid account.";
                    request.setAttribute("message", message);
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }

                session.setAttribute("email", email);
                session.setAttribute("role", user.getRole().getRoleId());

                if (user.getRole().getRoleId() == 1) {
                    response.sendRedirect("admin");
                } else {
                    response.sendRedirect("inventory");
                }
                break;
            
            
            case "register": 
//                String userRegister = (String) session.getAttribute("userRegisterForm");
                
                
                session.setAttribute("userRegisterForm", "true");
                
                response.sendRedirect("login");
                break;
                
                
            default: response.sendRedirect("login"); break;
        }
    }
    
}
