<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<p>${article.date}</p>
<h2 id="welcom">${article.title}</h2>
<c:forEach items="${article.media}" var="media">
    ${media.title}
    <c:choose>
        <c:when test="${media.mediaType eq picture}">

            <img src="${pageContext.request.contextPath}/img/${media.url}" alt="${media.url}">
        </c:when>
        <c:otherwise>
            ${media.url}
            <iframe width="560" height="315" src="https://www.youtube.com/embed/${media.url}?rel=0" frameborder="0"
                    allow="autoplay; encrypted-media" allowfullscreen></iframe>
        </c:otherwise>
    </c:choose>
</c:forEach>
<p class="color1">${article.intro}</p>
<p class="pad_bot1">${article.article}</p>
<br>
<p class="right">${article.source}</p>
<br>
<sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
    <form action="/news/edit/${article.id}">
        <button>Aanpassen</button>
    </form>
</sec:authorize>