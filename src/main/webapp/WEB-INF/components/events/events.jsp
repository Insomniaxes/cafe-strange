<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    <h2>${pageTitle}</h2>
    <c:forEach items="${events}" var="event">
        <div class="wrapper">
            <h3><fmt:formatDate value="${event.date}" pattern="dd MMMM yyy"/></h3>
            <figure class="left marg_right1"><a href="/events/${event.id}"><img
                    src="${pageContext.request.contextPath}/${event.picture.url}" alt="" style="max-width: 200px"></a></figure>
            <h3>${event.title}</h3>
            <p class="pad_bot1">${event.summary}</p>
            <ul class="list1 pad_bot1">
                <li><a href="/events/${event.id}">Lees meer...</a></li>
            </ul>
        </div>
        <sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
            <br>
            <form action="/events/edit/${event.id}">
                <button>Aanpassen</button>
            </form>
            <br>
        </sec:authorize>
        <br>
    </c:forEach>
</div>