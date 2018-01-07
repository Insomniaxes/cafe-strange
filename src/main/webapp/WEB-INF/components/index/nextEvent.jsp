<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="box">
    <!--content -->
    <article id="content">
        <div class="wrapper">
            <h2>Eerstkomend evenement</h2>
            <div class="wrapper">
                <figure class="left marg_right1"><a href="/events/${event.id}"><img src="${pageContext.request.contextPath}/img/${event.picture.url}" alt=""></a></figure>
                <h3>${event.title}</h3>
                <p class="pad_bot1">${event.summary}</p>
                <ul class="list1 pad_bot1">
                    <li><a href="#">Hier komen nog eventueel handige links</a></li>
                    <li><a href="#">Welke dat weet ik nog niet</a></li>
                </ul>
                <p><a href="/events/${event.id}">Lees meer ...</a></p>
            </div>
        </div>

    </article>
    <!--content end-->
</div>