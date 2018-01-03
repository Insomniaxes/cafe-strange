<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="wrapper">
    <figure class="left marg_right1"><a href="/events/flyer/${event.id}"><img
            src="${pageContext.request.contextPath}/img/${event.picture.url}" style="width: 200px" alt="oops"></a></figure>
    <h3><strong><fmt:formatDate value="${event.date}" pattern="dd.MM"/> </strong>${event.title}</h3>
    <p class="pad_bot1">${event.summary}</p>
    <ul class="list1 pad_bot1">
        <li><a href="#">Hier kan nog extra info komen te staan</a></li>
        <li><a href="#">Quis autem vel eum iure reprehenderit qui in voluptate</a></li>
        <li><a href="#">Velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum</a></li>
        <li><a href="#">Fugiat quo voluptas nulla pariatur lorem ipsum dolor sit amet</a></li>
    </ul>
    <p>${event.description}</p>
    <sec:authorize access="hasAnyRole('ADMIN','OWNER')">
        <form>
            <button type="submit" formaction="/events/edit/${event.id}" formmethod="get">Aanpassen</button>
        </form>
    </sec:authorize>
</div>