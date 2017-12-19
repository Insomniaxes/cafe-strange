<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/welcome.jsp" var="welcomeURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/upcomingEvents.jsp"
                var="upcomingURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/nextEvent.jsp" var="nextEventURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/scriptsEnCSS.jsp" var="scriptsEnCSSURL"/>
    <jsp:include page="${scriptsEnCSSURL}"/>
</head>
<body id="page1">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${navigationURL}"/>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <div class="wrapper pad_bot1">
                    <jsp:include page="${welcomeURL}"/>
                    <jsp:include page="${upcomingURL}"/>
                </div>
                <div class="wrapper">
                    <jsp:include page="${nextEventURL}"/>
                </div>
            </article>
            <!--content end-->
            <!--footer -->
            <footer>
                <jsp:include page="${footerURL}"/>
            </footer>
            <!--footer end-->
        </div>
    </div>
</div>
</body>
</html>
