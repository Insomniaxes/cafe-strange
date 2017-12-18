<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
    <h2><b>Username:</b> <input type="text" name="username" value="${user.username}"></h2>
    <h4><b>Voornaam:</b> <input type="text" name="firstName" value="${user.firstName}"></h4>
    <h4><b>Achternaam:</b> <input type="text" name="lastName" value="${user.lastName}"></h4>
    <h4><b>Geboortedatum:</b> ${user.birthday}</h4>
    <h5><b>Geslacht:</b>
        <select name="gender">
            <option value="${user.gender}" selected>${user.getGender()}</option>
            <c:forEach items="${genderList}" var="option">
                <c:if test="${option != user.gender}">
                    <option value="${option}"><c:out value="${option.getGender()}"/>
                </c:if>
                </option>
            </c:forEach>
        </select></h5>
    <h5><b>Role:</b> <option value="${user.role}" selected>${user.getRole()}</option>
        <c:forEach items="${roleList}" var="option">
            <c:if test="${option != user.role}">
                <option value="${option}"><c:out value="${option.getRole()}"/>
            </c:if>
            </option>
        </c:forEach></h5>
    <input type="submit" value="Opslaan" formaction="/users/update/${user.id}" formmethod="POST">
</form>