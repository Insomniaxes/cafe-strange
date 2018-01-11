<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    <h3><a href="${pageContext.request.contextPath}/events/${event.id}"><fmt:formatDate value="${event.date}" pattern="dd MMMM yyy"/> ${event.title}</a></h3>
    <div class="wrapper">
        <figure class="left marg_right1"><a href="${pageContext.request.contextPath}/events/${event.id}"><img
                src="${pageContext.request.contextPath}/img${event.picture.url}" alt="" width="500px"></a></figure>
        <p class="pad_bot1">${event.summary}</p>
        <p>${event.description}</p>
        <sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
            <form action="/events/edit/${event.id}">
                <button>Aanpassen</button>
            </form>
        </sec:authorize>
    </div>
</div>