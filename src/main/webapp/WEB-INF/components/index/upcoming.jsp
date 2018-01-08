<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="col1 pad_left1">
    <h2>Aankomend</h2>
    <div id="gallery1">
        <ul>
            <c:forEach items="${upcomingEvents}" var="event">
                <li><span class="dropcap_1"><fmt:formatDate value="${event.date}" pattern="dd"/><span><fmt:formatDate value="${event.date}" pattern="MMM"/></span></span>
                    <p><span class="color1">Lorem ipsum dolor sit amet</span><br>
                        adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br>
                        <a href="/events/${event.id}" class="link1">Details</a></p>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="#" class="next"></a> <a href="#" class="prev"></a>
</section>

