<%-- 
    Document   : inventory
    Created on : 22-Apr-2022, 9:16:35 AM
    Author     : Jaren
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/resources/css/pageStylez.css"/>
    <title>nVentory - Inventory</title>
</head>
<body>
<div class="mainpanel">
    <h1>nVentory - Inventory Management</h1>

    <hr>

    <div id="actionpane">
        <div><a href="/admin">&lt;Admin</a></div>
        <div><a href="/login">Logout&gt;</a></div>
    </div>

    <hr>

    <form action="inventory?action=deactivate" method="post">
        <div id="deactivate">
            <input type="submit" value="Deactivate Account">
        </div>
    </form>

    <hr>

    <form action="inventory?action=accountedit" method="post">
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
        <input type="submit" value="Edit Account">
    </form>

    <hr>

    <form action="inventory?action=add" method="post">
        <div class="centeredpanel fields">
            <input type="text" placeholder="Category" name="add_category">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Name" name="add_itemname">
        </div>
        <div class="centeredpanel fields">
            <input type="text" placeholder="Price" name="add_price">
        </div>
        <input type="submit" value="Add Item">
    </form>

    <hr>

    <div>
        Home Items
        <table>
            <tr>
                <th>Category</th>
                <th>Name</th>
                <th>Price</th>
                <th>
                </th>
                <th>
                </th>
            </tr>

            <tr>
                <td>Category</td>
                <td>Name</td>
                <td>Price</td>
                <td>
                    <form action="inventory?action=edit" method="post">
                        <input value="id" hidden>
                        <input value="name" hidden>
                        <input value="price" hidden>
                        <input value="category" hidden>
                        <input value="owner" hidden>
                        <input type="submit" value="edit">
                    </form>
                </td>
                <td>
                    <form action="inventory?action=remove" method="post">
                        <input value="id" hidden>
                        <input value="name" hidden>
                        <input value="price" hidden>
                        <input value="category" hidden>
                        <input value="owner" hidden>
                        <input type="submit" value="remove">
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
