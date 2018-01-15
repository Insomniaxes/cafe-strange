<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <img src="${pageContext.request.contextPath}/picture.url">
</div>

<div class="container">
    <ul>
        <c:forEach items="${picture.comments}" var="comment">
            <li>
                ${comment.comment}
                <div align="right"><a href="/users/${comment.user.id}">${comment.user.username}</a><br>${comment.timestampCreation}</div>
                <hr>
            </li>
        </c:forEach>
    </ul>
</div>