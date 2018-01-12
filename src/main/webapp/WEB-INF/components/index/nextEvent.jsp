<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="wrapper">
    <h2>Eerstkomend feestje</h2>
    <div class="wrapper">
        <figure class="left marg_right1"><a href="/events/${event.id}"><img src="${event.picture.url}" alt=""></a></figure>
        <h3>${event.title}</h3>
        <p class="pad_bot1">${event.summary}</p>
        <p>Hier nog extra info over het feestje</p>
        <ul class="list1 pad_bot1">
            <li><a href="#">Nog enkele interessante links</a></li>
            <li><a href="#">welke weet ik nog niet</a></li>
        </ul>
    </div>
</div>