<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<form action="/news/update/${article.id}" method="post">
    <input type="date" name="date" value="${article.date}" style="color: black">
    <h2 style="color: black"><input name="title" value="${article.title}"></h2>
    <p style="color: black"><textarea name="intro" rows="2" cols="20">${article.intro}</textarea></p>
    <p style="color: black"><textarea name="article" rows="4" cols="60">${article.article}</textarea></p>
    <br>
    <p class="right" style="color: black"><input name="source" value="${article.source}"></p>
    <br>
    <button>Opslaan</button>
</form>
