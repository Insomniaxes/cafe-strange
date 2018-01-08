<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
    <table style="background: white; border-spacing: 35px">
        <tr>
            <th>Gebruikersnaam</th>
            <th>Voornaam</th>
            <th>Achternaam</th>
            <th>Geboortedatum</th>
            <th>Geslacht</th>
            <th>Gebruikersrechten</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="/users/${user.id}">${user.username}</a></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.birthday}</td>
                <td>${user.gender}</td>
                <c:forEach items="${user.roles}" var="role">
                    <td>${role.role}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</article>