<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/end.jsp" var="endUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/upcoming.jsp" var="upcomingUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/welcome.jsp" var="welcomeUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/nextEvent.jsp" var="nextEventUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="${headUrl}"/>
</head>
<body id="page1">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${navigationUrl}"/>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <div class="wrapper pad_bot1">
                    <jsp:include page="${welcomeUrl}"/>
                    <jsp:include page="${upcomingUrl}"/>
                </div>
                <jsp:include page="${nextEventUrl}"/>
            </article>
            <!--content end-->
            <!--footer -->
            <footer>
                <jsp:include page="${footerUrl}"/>
            </footer>
            <!--footer end-->
        </div>
    </div>
</div>

<jsp:include page="${endUrl}"/>
</body>
</html>
