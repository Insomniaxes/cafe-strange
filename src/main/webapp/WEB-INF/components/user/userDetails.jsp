<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2><b>Username:</b> ${user.username}</h2>
<h3><b>Voornaam:</b> ${user.firstName}</h3>
<h3><b>Achternaam:</b> ${user.lastName}</h3>
<h3><b>Geboortedatum:</b> ${user.birthday}</h3>
<h5><b>Geslacht:</b> ${user.gender}</h5>
<h5><b>Role:</b> <c:forEach items="${user.roles}" var="role">${role.role}</c:forEach></h5>

<form>
    <input type="submit" value="Wijzig gegevens" formaction="/users/edit/${user.id}"/>
</form>