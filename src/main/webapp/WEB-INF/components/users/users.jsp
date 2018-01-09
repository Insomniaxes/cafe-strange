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
                    <th><button data-sort="0">id</button></th>
                    <th>Gebruikersnaam</th>
                    <th>Voornaam</th>
                    <th>
                        <button data-sort="0">Achternaam</button>
                    </th>
                    <th>Geboortedatum</th>
                    <th>Geslacht</th>
                    <th>Email</th>
                    <th>Machtiging</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <div class="clist">
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
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</article>

<script type="text/javascript">
    $(document).ready(function () {
        $('button').on('click', function () {
            var s = $(this).data('sort');
            console.log(s);
            if (s === 0) {
                $(this).data('sort', 1);
                $('.clist div').sort(function (a, b) {
                    return a.dataset.sid < b.dataset.sid
                }).appendTo('.clist')
            } else {
                $(this).data('sort', 0);
                $('.clist div').sort(function (a, b) {
                    return a.dataset.sid > b.dataset.sid
                }).appendTo('.clist')
            }
        });
    });
</script>