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
    <br>
    <form action="/pictures/${picture.id}/addComment" method="post">
        <textarea name="comment"></textarea><br>
        <button>Reageer</button>
    </form>
    <c:forEach items="${picture.comments}" var="comment">
        ${comment.comment}
        ${comment.timestampCreation}
        <hr>
    </c:forEach>
</div>