<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/end.jsp" var="endUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/carousel.jsp" var="carouselUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/nextEvent.jsp" var="nextEventUrl"/>
<!doctype html>
<html lang="nl">
<head>
    <jsp:include page="${headUrl}"/>
    <link type="text/css" href="${pageContext.request.contextPath}/css/myCss/myStyle.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="${navigationUrl}"/>
</nav>
<section><br><br>
    <main role="main" class="container">

        <br><br>
        <jsp:include page="${nextEventUrl}"/>
        <br><br>
        <jsp:include page="${carouselUrl}"/>
        <br><br>

    </main><!-- /.container -->
</section>
<footer>
    <jsp:include page="${footerUrl}"/>
</footer>

<jsp:include page="${endUrl}"/>
</body>
</html>
