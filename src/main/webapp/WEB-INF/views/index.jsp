<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/welcome.jsp" var="welcomeUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/upcomingIndex.jsp" var="upcomingUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/event.jsp" var="nextEventUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="${headUrl}"/>
</head>
<body id="page1">
<div class="bg1">
    <div class="main">
        <jsp:include page="${navUrl}"/>
        <div class="box">
            <article id="content">
                <div class="wrapper pad_bot1">
                    <a href="/index" id="logo">Cafe Strange</a>
                    <jsp:include page="${welcomeUrl}"/>
                    <jsp:include page="${upcomingUrl}"/>
                </div>
                <div class="wrapper">
                    <h2>Eerstkomend feestje:</h2>
                    <jsp:include page="${nextEventUrl}"/>
                </div>
            </article>
            <footer>
                <jsp:include page="${footerUrl}"/>
            </footer>
        </div>
    </div>
</div>

</body>
</html>
