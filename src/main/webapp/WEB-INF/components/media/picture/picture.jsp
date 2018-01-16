<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

<script>
    tinymce.init({
        selector: "textarea",
        width: 250,

    });
</script>

<div class="container">
    ${message}
    <img src="${pageContext.request.contextPath}/${picture.url}">
    <br>


    <c:forEach items="${picture.comments}" var="comment">
        <li>
                ${comment.comment}
            <div align="right"><a
                    href="/users/${comment.user.id}">${comment.user.username}</a><br>${comment.timestampCreation}</div>
            <hr>
        </li>
    </c:forEach>

<br>
    <%--<c:if test="${pageContext.request.userPrincipal.authenticated}">--%>
        <%--<sec:authentication var="user" property="principal"/>--%>
        <form action="/pictures/${picture.id}/addComment" method="post">
            <textarea name="comment"></textarea>
            <button>Plaats reaktie</button>
        </form>
    <%--</c:if>--%>
</div>