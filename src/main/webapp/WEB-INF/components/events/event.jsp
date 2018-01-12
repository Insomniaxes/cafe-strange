<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    <h2><fmt:formatDate value="${event.date}" pattern="dd MMMM yyy"/></h2>
    <div class="wrapper">
        <figure class="left marg_right1"><a href="${event.picture.url}" target="_blank"><img
                src="${event.picture.url}" alt="" width="500px"></a></figure>
        <h3>${event.title}</h3>
        <p class="pad_bot1">${event.summary}</p>
        <p>${event.description}</p>
        <sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
            <form action="/events/edit/${event.id}">
                <button>Aanpassen</button>
            </form>
        </sec:authorize>
    </div>
</div>