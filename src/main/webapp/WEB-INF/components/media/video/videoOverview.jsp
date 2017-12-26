<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="wrapper">
    <h2>Video's</h2>
    <dl>
        <dd>
            <c:forEach items="${videos}" var="video" varStatus="rowCounter">
                <c:if test="${rowCounter.count % 3 == 1}">
                    <ul>
                </c:if>
                <li>
                    <iframe width="280" height="157" src="${video.url}" frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen></iframe>
                    </a>
                </li>
                <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
                    </ul>
                </c:if>
            </c:forEach>

        </dd>
    </dl>

</div>