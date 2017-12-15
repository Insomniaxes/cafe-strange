<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details: ${user.username}</title>
</head>
<body>

<table style="width:100%">
    <tr>
    <th>Gebruikersnaam</th>
    <th>Achternaam</th>
    <th>Voornaam</th>
    <th>Geboortedatum</th>
    <th>Geslacht</th>
    </tr>
    <form>
        <tr>
            <td><input name="username" value="${user.username}"></td>
            <td><input name="lastName" value="${user.lastName}"></td>
            <td><input name="firstName" value="${user.firstName}"></td>
            <td><input name="birthday" value="${user.birthday}"></td>
            <td><input name="gender" value="${user.gender}"></td>
        </tr>

        <input type="submit" value="Update" formaction="/users/update/${user.id}" formmethod="post">
    </form>
</table>

</body>
</html>
