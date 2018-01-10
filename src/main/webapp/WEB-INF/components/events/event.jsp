<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="wrapper">
    <h2>${pageTitle}</h2>
    <div class="wrapper">
        <figure class="left marg_right1"><a href="#"><img
                src="${pageContext.request.contextPath}/img/${event.picture.url}" alt=""></a></figure>
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