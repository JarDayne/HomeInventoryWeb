<%-- 
    Document   : admin
    Created on : 22-Apr-2022, 9:16:24 AM
    Author     : Jaren
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/WEB-INF/resources/css/pageStylez.css"/>
    <title>nVentory - Admin</title>
</head>
<body>
<div class="mainpanel">
    <h1>nVentory - Administration</h1>

    <hr>

    <div id="actionpane">
        <div><a href="/HomeInventory/inventory">&lt;Inventory</a></div>
        <div><a href="/HomeInventory/login">Logout&gt;</a></div>
    </div>

    <hr>

    <form action="inventory?action=accountedit" method="post">
        <div class="centeredpanel fields">
            <input type="text" placeholder="Email" name="adduser_email">
        </div>
        <div class="centeredpanel fields">
            <label>Active?</label>
            <input type="checkbox" value="true" name="adduser_email">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="First Name" name="adduser_firstname">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Last Name" name="adduser_lastname">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Password" name="adduser_password">
        </div>
        <div class="centeredpanel fields">
            <select id="p_role">
                <option value="1">System admin</option>
                <option value="2">Regular user</option>
                <option value="3">Company admin</option>
            </select>
        </div>
        <input type="submit" value="Add User">
    </form>

    <hr>

    <form action="inventory?action=add" method="post">
        <div class="centeredpanel fields">
            <input type="text" placeholder="Category" name="user_email">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Name" name="user_firstname">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Price" name="user_lastname">
        </div>
        <input type="submit" value="Add User">
    </form>

    <hr>

    <div>
        Users
        <table>
            <tr>
                <th>Email</th>
                <th>Active</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>
                </th>
                <th>
                </th>
            </tr>

            <tr>
                <td>Email</td>
                <td>Active</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>
                    <form action="inventory?action=edit" method="post">
                        <input value="email" hidden>
                        <input value="active" hidden>
                        <input value="firstname" hidden>
                        <input value="lastname" hidden>
                        <input type="submit" value="edit">
                    </form>
                </td>
                <td>
                    <form action="inventory?action=remove" method="post">
                        <input value="email" hidden>
                        <input value="active" hidden>
                        <input value="firstname" hidden>
                        <input value="lastname" hidden>
                        <input type="submit" value="remove">
                    </form>
                </td>
            </tr>
        </table>
    </div>

    <hr>

    <div>
        Categories
        <table>
            <tr>
                <th>Category Name</th>
                <th>
                </th>
                <th>
                </th>
            </tr>

            <tr>
                <td>Category</td>
                <td>
                    <form action="inventory?action=edit" method="post">
                        <input value="categoryName" hidden>
                        <input type="submit" value="edit">
                    </form>
                </td>
                <td>
                    <form action="inventory?action=remove" method="post">
                        <input value="categoryName" hidden>
                        <input type="submit" value="remove">
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
