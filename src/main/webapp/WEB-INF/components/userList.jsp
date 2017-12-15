<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"/>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <table style="width:100%">
        <tr>
            <th>Gebruikersnaam</th>
            <th>Achternaam</th>
            <th>Voornaam</th>
            <th>Geboortedatum</th>
            <th>Role</th>
            <th></th>
        </tr>
        <tr>
            <td>${user.username}</td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.birthday}</td>
            <td>${user.gender}</td>
            <td><c:forEach items="${user.roles}" var="role">${role.role}</c:forEach></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
