<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article id="content">
    <h3>Aankomende evenementen</h3>
    <div class="wrapper">
        <c:forEach items="${upcomingEvents}" var="event">
        <h2>${event.title}</h2>
        <div class="wrapper">
            <div class="cols marg_right1">
                <figure class="pad_bot1"><a href="/events/${event.id}"><img src="${event.flyerURL}" alt=""></a></figure>
                <p>${event.summary}</p>
                <p>${event.description}</p>
            </div>
        </div>
        </c:forEach>
    </div>
    <h3>Voorbije evenementen</h3>
    <div class="wrapper">
        <c:forEach items="${pastEvents}" var="event">
            <h2>${event.title}</h2>
            <div class="wrapper">
                <div class="cols marg_right1">
                    <figure class="pad_bot1"><a href="#"><img src="${event.flyerURL}" alt=""></a></figure>
                    <p>${event.summary}</p>
                    <p>${event.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</article>