<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    <h2>Next Party</h2>
    <div class="wrapper">
        <figure class="left marg_right1"><a href="#"><img src="${pageContext.request.contextPath}/images/banner1.jpg" alt=""></a></figure>
        <h3>${event.title}</h3>
        <p class="pad_bot1">${event.summary}</p>

        <%--Misschien kan ik hier nog een lijst met links plaaten--%>
        <%--<ul class="list1 pad_bot1">--%>
            <%--<li><a href="#">${pointOfInterest}</a></li>--%>
        <%--</ul>--%>
        <p>${event.description}</p>
    </div>
</div>