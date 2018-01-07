<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Aankomende evenementen</h2>
<div id="mycarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <c:forEach items="${upcomingEvents}" var="event" varStatus="status">
            <c:choose>
                <c:when test="${status.first}">
                    <li data-target="#mycarousel" data-slide-to="${status.count}" class="active"></li>
                </c:when>
                <c:otherwise>
                    <li data-target="#mycarousel" data-slide-to="${status.count}"></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ol>
    <div class="carousel-inner">
        <c:forEach items="${upcomingEvents}" var="event" varStatus="status">
        <c:choose>
        <c:when test="${status.first}">
        <div class="carousel-item active">
            </c:when>
            <c:otherwise>
            <div class="carousel-item">
                </c:otherwise>
                </c:choose>
                <img class="d-block w-100" src="${pageContext.request.contextPath}/img/site/bg/blackbgimg.jpg"
                     alt="">
                <div class="carousel-caption d-none d-md-block">
                    <img src="${pageContext.request.contextPath}/img/${event.picture.url}" align="left" hspace="20">
                    <h3>${event.title}</h3>
                    <p>${event.summary}</p>
                </div>
            </div>
            </c:forEach>
        </div>


        <a class="carousel-control-prev" href="#mycarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#mycarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>