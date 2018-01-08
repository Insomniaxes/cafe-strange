<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="wrapper">
    <h2>${pageTitle}</h2>
    <c:forEach items="${events}" var="event">
        <div class="wrapper">
            <figure class="left marg_right1"><a href="/events/${event.id}"><img
                    src="${pageContext.request.contextPath}/img/${event.picture.url}" alt=""></a></figure>
            <h3>${event.title}</h3>
            <p class="pad_bot1">${event.summary}</p>
            <p>Hier nog extra info over het feestje</p>
            <ul class="list1 pad_bot1">
                <li><a href="#">Nog enkele interessante links</a></li>
                <li><a href="#">welke weet ik nog niet</a></li>
            </ul>
        </div>
        <sec:authorize access="hasAnyRole('ADMIN', 'OWNER')">
            <br>
            <form action="/events/edit/${event.id}">
                <button>Aanpassen</button>
            </form>
            <br>
        </sec:authorize>
        <br>
    </c:forEach>
</div>