<%--
  Created by IntelliJ IDEA.
  User: book
  Date: 19.07.2019
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<div align="center">

    <body>
    <h1>Авторизация</h1>
    <form action="/" method="post">
        <table style="with: 100%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
    </body>
</html>
