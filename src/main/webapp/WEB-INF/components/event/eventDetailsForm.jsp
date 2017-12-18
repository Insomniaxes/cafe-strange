<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
    <h2><b>Datum:</b> <input type="text" name="date" value="${event.date}"></h2>
    <h4><b>Titel:</b> <input type="text" name="title" value="${event.title}"></h4>
    <h4><b>Samenvatting:</b> <input type="text" name="summary" value="${event.summary}"></h4>
    <h4><b>Beschrijving:</b> <input type="text" name="description" value="${event.summary}"></h4>
    <h4><b>Afbeelding url:</b> moet nog anders gedaan worden <input name="flyerURL"
                                                                    value="${pageContext.request.contextPath}/images/banner1.jpg}">
    </h4>

    <c:choose>
        <c:when test="${!empty event}">
            <input type="submit" value="Opslaan" formaction="/events/update/${event.id}" formmethod="POST">
        </c:when>
        <c:otherwise>
            <input type="submit" value="Opslaan" formaction="/events/create/" formmethod="POST">
        </c:otherwise>
    </c:choose>
</form>