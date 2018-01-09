<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${media}" var="video">
    <h3><a href="/videos/${video.id}">${video.title}</a></h3>
    <iframe width="280" height="155" src="https://www.youtube.com/embed/${video.url}?rel=0" frameborder="0"
            allow="autoplay; encrypted-media" allowfullscreen></iframe>
</c:forEach>

<%--<iframe width="560" height="315" src="https://www.youtube.com/embed/anKmU1J0l9g?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>--%>