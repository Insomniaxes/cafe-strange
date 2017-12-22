<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    <h2>Afgelopen feestjes</h2>
    <div class="wrapper">
        <c:forEach items="${pastEvents}" var="event">
            <div class="cols marg_right1">
                <h2><strong><fmt:formatDate value="${event.date}" pattern="dd.MM.yyy"/></strong></h2>
                <h4>${event.title}</h4>
                <figure class="pad_bot1"><a href="/events/${event.id}"><img src="${pageContext.request.contextPath}/img/${event.picture.pictureURL}" alt="${event.title}"></a></figure>
            </div>
        </c:forEach>
    </div>
</div>