<%-- 
    Document   : register
    Created on : 22-Apr-2022, 7:44:41 PM
    Author     : Jaren
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/resources/css/registerStylez.css"/>
    <title>nVentory - Register</title>
</head>
<body>
<div class="mainpanel">
    <h1>HOME nVentory</h1>

    <form action="login?action=register" method="post">
        <div class="centeredpanel" id="loginpane">
            <h2>Register</h2>

            <div class="centeredpanel fields">
                <input type="text" placeholder="Email" name="user_email">
            </div>
            <div class="centeredpanel fields">
                <input type="text" placeholder="First Name" name="user_firstname">
            </div>
            <div class="centeredpanel fields">
                <input type="text" placeholder="Last Name" name="user_lastname">
            </div>
            <div class="centeredpanel fields">
                <input type="text" placeholder="Password" name="user_password">
            </div>
        </div>

        <div id="actionpane">
            <div id="signin">
                <input type="submit" value="Register">
            </div>
            <div id="registerprompt">
                <a href="<c:url value='/login' />">Back to login</a>
            </div>
        </div>
    </form>
</body>
</html>
