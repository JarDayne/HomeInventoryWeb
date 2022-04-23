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
    <link type="text/css" rel="stylesheet" href="/WEB-INF/resources/css/loginStylez.css"/>
    <title>nVentory - Login</title>
    </head>
    <body>
    <div class="mainpanel">
    <h1>HOME nVentory</h1>

    <form action="login?action=login" method="post">
    <div class="centeredpanel" id="loginpane">
    <h2>Login</h2>

    <div class="centeredpanel fields">
    <input type="text" placeholder="Email" name="user_email">
    </div>
    <div class="centeredpanel fields">
    <input type="text" placeholder="Password" name="user_email">
    </div>
    </div>

    <div id="actionpane">
    <div id="signin">
    <input type="submit" value="Sign In">
    </div>
    <div id="registerprompt">
    <a href="<c:url value='/login' />">Register</a>
    </div>
    </div>
    </form>
    </div>
    </body>
    </html>
