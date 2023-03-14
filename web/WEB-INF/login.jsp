<%-- 
    Document   : login
    Created on : 22-Apr-2022, 9:16:49 AM
    Author     : Jaren
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="resources/css/loginStylez.css"/>
    <title>nVentory - Login</title>
    </head>
    <body>
    <div class="mainpanel">
    <h1>HOME nVentory</h1>

    
    
    
            <c:choose>
            <c:when test="${empty userRegisterForm}">
                <form action="login?action=signin" method="post">
                <div class="centeredpanel" id="loginpane">
                <h2>Login</h2>

                <div class="centeredpanel fields">
                <input type="text" placeholder="Email" name="user_email">
                </div>
                <div class="centeredpanel fields">
                <input type="text" placeholder="Password" name="user_password">
                </div>
                </div>

                <div id="actionpane">
                <div id="signin">
                <input type="submit" value="Sign In">
                </div>
                </div>
                </form>
            </c:when>
            <c:when test="${userRegisterForm eq 'true'}">
                <form action="login?action=signup" method="post">
                <div class="centeredpanel" id="loginpane">
                <h2>Register</h2>

                <div class="centeredpanel fields">
                <input type="text" placeholder="Email" name="user_email">
                </div>
                <div class="centeredpanel fields">
                <input type="text" placeholder="Password" name="user_password">
                </div>
                </div>

                <div id="actionpane">
                <div id="signin">
                <input type="submit" value="Sign Up">
                </div>
                </div>
                </form>
                </form>
            </c:when>
        </c:choose>
    
        <c:choose>
            <c:when test="${empty userRegisterForm}">
                <form action="login?action=register" method="post">
                    <input type="submit" value="Register">
                </form>
            </c:when>
            <c:when test="${userRegisterForm eq 'true'}">
                <form action="login?action=logonForm" method="post">
                    <input type="submit" value="Already have an account.">
                </form>
            </c:when>
        </c:choose>

    </div>
    </body>
    </html>
