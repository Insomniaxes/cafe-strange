<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="wrapper">
    <h2>${pageTitle}</h2>
    <dl class="folio">
        <dt>
            <c:forEach items="${media}" var="mediaItem" varStatus="rowCounter">
                <img src="${pageContext.request.contextPath}/img/${mediaItem.url}" alt="" id="img${rowCounter.count}">
            </c:forEach>
        </dt>
        <dd>

            <c:forEach items="${media}" var="mediaItem" varStatus="rowCounter">
                <c:if test="${rowCounter.count % 3 == 1}">
                    <ul>
                </c:if>
                <li>
                    <a href="#img${rowCounter.count}">
                        <img src="${pageContext.request.contextPath}/img/${mediaItem.url}"
                             width="150px"/><br/> ${mediaItem.title}
                    </a>
                </li>
                <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
                    </ul>
                </c:if>
            </c:forEach>

        </dd>
    </dl>
    <script>
        $(document).ready(function () {
            var Img = '#' + $(".folio .active").attr('id')
            $(".folio dt img").css({
                opacity: '0'
            });
            $(".folio dt img.active").css({
                opacity: '1'
            });
            $(".folio ul li a").click(function () {
                var ImgId = $(this).attr("href");
                if (ImgId != Img) {
                    $(".folio dt .active").animate({
                        opacity: "0"
                    }, 600, function () {
                        $(this).removeClass('active');
                    })
                    $(ImgId).animate({
                        opacity: "1"
                    }, 600).addClass('active');
                }
                Img = ImgId;
                return false;
            })
        });
    </script>
</div>



