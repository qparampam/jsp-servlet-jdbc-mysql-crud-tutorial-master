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
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Login</th>
                <th>Password</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.login}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td>
                    	<a href="update?id=<c:out value='${user.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
