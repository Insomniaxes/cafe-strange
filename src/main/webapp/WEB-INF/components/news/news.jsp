<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:forEach items="${news}" var="article">
    <p>${article.date}</p>
    <h2 id="welcom">${article.title}</h2>
    <p class="color1">${article.intro}</p>
    <p><a href="/news/${article.id}">Lees meer...</a> </p>
    <br>
    <p class="right">${article.source}</p>
    <br>
    <sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
        <form action="/news/edit/${article.id}">
            <button>Aanpassen</button>
        </form>
    </sec:authorize>
</c:forEach>