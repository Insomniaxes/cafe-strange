<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="col1 pad_left1">
    <h2>Upcoming Events</h2>
    <div id="gallery1">
        <ul>
            <c:forEach items="${events}" var="event">
                <li><span class="dropcap_1"><fmt:formatDate value="${event.date}" pattern="dd"/><span><fmt:formatDate
                        value="${event.date}" pattern="MMMM"/></span></span>
                    <p><span class="color1">${event.title}</span><br>
                            ${event.description}<br>
                        <a href="/events/${event.id}" class="link1">Lees meer</a></p>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="#" class="next"></a> <a href="#" class="prev"></a>
</section>