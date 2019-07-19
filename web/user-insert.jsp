<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="insert">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>

    </h2>
</center>
<div align="center">

        <form action="insert" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Add New User
                    </h2>
                </caption>
                <tr>
                    <th>User Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Login: </th>
                    <td>
                        <input type="text" name="login" size="45"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Password: </th>
                    <td>
                        <input type="text" name="password" size="15"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Role: </th>
                    <td>
                        <input type="text" name="role" size="45"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
