<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="userListTable">
    <tr>
        <th>Username</th>
        <th>Achternaam</th>
        <th>Voornaam</th>
        <th>Geboortedatum</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><a href="/users/${user.id}">${user.username}</a></td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.birthday}</td>
        </tr>
    </c:forEach>
</table>