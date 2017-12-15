<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>

<table style="width:100%">
    <tr>
        <th>Gebruikersnaam</th>
        <th>Achternaam</th>
        <th>Voornaam</th>
        <th>Geboortedatum</th>
    </tr>
    <tr>
        <td><input name="userName" value="${user.username}"></td>
        <td><input name="lastName" value="${user.lastName}"></td>
        <td><input name="firstName" value="${user.firstName}"></td>
        <td><input name="birthday" value="${user.birthday}"></td>
        <td><input name="gender" value="${user.gender}"></td>
    </tr>
</table>

</body>
</html>
