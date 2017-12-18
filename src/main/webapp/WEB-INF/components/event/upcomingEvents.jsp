<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="col1 pad_left1">
    <h2>Latest Events</h2>
    <div id="gallery1">
        <ul>
            <c:forEach items="${upcomingEvents}" var="event">
                <li>
                    <span class="dropcap_1"><fmt:formatDate value="${event.date}" pattern="dd"/><span><fmt:formatDate value="${event.date}" pattern="MMMM"/></span></span>
                    <p>
                        <span class="color1">${event.summary}</span><br>
                        Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. <br>
                        <a href="#" class="link1">View Details</a>
                    </p>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="#" class="next"></a> <a href="#" class="prev"></a>
</section>

<script>
    $(document).ready(function () {
        //gallery
        $("#gallery1").jCarouselLite({
            btnNext: ".next",
            btnPrev: ".prev",
            mouseWheel: true,
            vertical: true,
            circular: true,
            visible: 2,
            speed: 600,
            easing: 'easeOutCirc'
        });
        Cufon.now();
    })
</script>