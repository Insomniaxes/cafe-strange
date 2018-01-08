<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="${pageContext.request.contextPath}/night/js/jquery-1.6.js" ></script>
<script src="${pageContext.request.contextPath}/night/js/cufon-yui.js"></script>
<script src="${pageContext.request.contextPath}/night/js/cufon-replace.js"></script>
<script src="${pageContext.request.contextPath}/night/js/NewsGoth_BT_400.font.js"></script>
<script src="${pageContext.request.contextPath}/night/js/NewsGoth_BT_700.font.js"></script>
<script src="${pageContext.request.contextPath}/night/js/jcarousellite.js"></script>
<script src="${pageContext.request.contextPath}/night/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/night/js/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/night/js/atooltip.jquery.js"></script>
<section class="col1 pad_left1">
    <h2>Aankomend</h2>
    <div id="gallery1">
        <c:forEach items="${upcomingEvents}" var="event">
        <ul>
                <li><span class="dropcap_1"><fmt:formatDate value="${event.date}" pattern="dd"/><span><fmt:formatDate value="${event.date}" pattern="MMM"/></span></span>
                    <p><span class="color1">${event.title}</span><br>
                        adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br>
                        <a href="/events/${event.id}" class="link1">Details</a></p>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="#" class="next"></a> <a href="#" class="prev"></a>
</section>

<script type="text/javascript">
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