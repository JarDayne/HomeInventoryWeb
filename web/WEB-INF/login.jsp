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
                <form action="login?action=login" method="post">
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
                <a href="<c:url value='/login' />">Register</a>
                </form>
            </c:when>
            <c:when test="${userRegisterForm == "true"}">
                <form action="login?action=register" method="post">
                <input type="hidden" name="userRegisterForm" value="<c:out value='${null}'/>">
                <a href="<c:url value='/login?action=register' />">Already have an account.</a>
            </c:when>
        </c:choose>
   
                
<%--                <form action="login?action=login" method="post">
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
    </form>--%>
    
<%--    <form action="login?action=signup" method="post">
    <div id="registerprompt">
        <c:choose>
            <c:when test="${empty userRegisterForm}">
                   <a href="<c:url value='/login' />">Register</a>
            </c:when>
            <c:when test="${userRegisterForm}">
                <a href="<c:url value='/login' />">Already have an account.</a>
            </c:when>
        </c:choose>
    </div>
    </form>--%>

    </div>
    </body>
    </html>
