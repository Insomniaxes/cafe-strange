<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">
    <div>
        <form method="POST" enctype="multipart/form-data" >
            Titel:<br>
            <input name="title" value="${event.title}"> <br><br>
            Datum:<br>
            <input name="date" value="${event.date}" type="date"><br><br>
            Intro:<br>
            <textarea name="summary" cols="30" rows="4">${event.summary}</textarea><br><br>
            Uitgebreide info: <br>
            <textarea name="description" cols="50" rows="6">${event.description}</textarea> <br>
            Media: <br>
            <input type="file" name="file"><br>
            <img src="${pageContext.request.contextPath}/img/${event.picture.url}" alt="">
            <c:choose>
                <c:when test="${empty event.id}">
                    <input type="submit" name="submit" value="save" formaction="/events/create">
                </c:when>
                <c:otherwise>
                    <input type="submit" name="submit" value="save" formaction="/events/update/${event.id}">
                </c:otherwise>
            </c:choose>
            <br>

        </form>
    </div>
</div>