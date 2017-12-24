<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/upcomingEvents.jsp" var="upcomingEventsUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="${headUrl}"/>
</head>
<body id="page2">
<div class="bg1">
    <div class="main">
        <!--header -->

            <jsp:include page="${navUrl}"/>

        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <jsp:include page="${upcomingEventsUrl}"/>
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
<script>
    Cufon.now();
</script>
</body>
</html>
