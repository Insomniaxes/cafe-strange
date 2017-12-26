<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<article id="content">
    <div class="wrapper">
        <c:forEach items="${newsList}" var="news">
            <h2><strong><fmt:formatDate value="${news.date}" pattern="dd.MM"/> </strong> ${news.title}</h2>
            <div class="wrapper pad_bot1">
                <figure class="left marg_right1"><img src="images/page5_img1.jpg" alt=""></figure>
                <p class="color1 pad_bot1">${news.intro}</p>
                <p class="pad_bot1">${news.article}</p>
                <p><div align="right"><blockquote>${news.source}</blockquote></div></p>
                <a href="#" class="link2">Read More</a>
            </div>
        </c:forEach>
    </div>
</article>