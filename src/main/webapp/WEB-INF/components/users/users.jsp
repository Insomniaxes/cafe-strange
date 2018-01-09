<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
    <div class="bs-example">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">User Details</div>
            <div class="panel-body">
                <p>Lijst van users</p>
            </div>
            <!-- Table -->
            <table class="table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>Gebruikersnaam</th>
                    <th>Voornaam</th>
                    <th>Achternaam</th>
                    <th>Geboortedatum</th>
                    <th>Geslacht</th>
                    <th>Email</th>
                    <th>Machtiging</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td><a href="/users/${user.id}">${user.username}</a></td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.birthday}</td>
                        <td>${user.gender}</td>
                        <td>${user.email}</td>
                        <c:forEach items="${user.roles}" var="role">
                            <td>${role.role}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</article>