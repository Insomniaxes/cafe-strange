<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<p>${article.date}</p>
<h2 id="welcom">${article.title}</h2>
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