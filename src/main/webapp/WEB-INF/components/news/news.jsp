<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article id="content">
    <c:forEach items="${newsList}" var="news">
        <div class="wrapper">
            <h2><strong><ftm:formatDate value="${news.date}" pattern="dd.MM"/> </strong><a
                    href="/news/${newsId}"> ${news.title}</a></h2>
            <div class="wrapper pad_bot1">
                <figure class="left marg_right1"><img src="images/page5_img1.jpg" alt=""></figure>
                <p class="color1 pad_bot1">${news.intro}</p>
                <p class="pad_bot1">${news.article}</p>
            </div>
        </div>
    </c:forEach>
</article>