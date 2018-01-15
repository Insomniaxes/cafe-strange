<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

<script>
    tinymce.init({
        selector: "textarea",
        width: 250,

    });
</script>

<div class="container">
    <img src="${pageContext.request.contextPath}/${picture.url}">
    <br>


        <c:forEach items="${picture.comments}" var="comment">
            <li>
                    ${comment.comment}
                <div align="right"><a href="/users/${comment.user.id}">${comment.user.username}</a><br>${comment.timestampCreation}</div>
                <hr>
            </li>
        </c:forEach>

    <form action="/pictures/addComment/${picture.id}" method="post">
        <textarea name="comment"></textarea>
        <button>Plaats reaktie</button>
    </form>

</div>