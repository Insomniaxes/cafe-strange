<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/news/news.jsp" var="newsUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Strange | News</title>
    <jsp:include page="${headUrl}"/>
</head>
<body id="page5">
<div class="bg1">
    <div class="main">
        <jsp:include page="${navigationUrl}"/>
        <div class="box">
            <!--content -->
            <jsp:include page="${newsUrl}"/>
            <!--content end-->
            <!--footer -->
            <footer>
                <jsp:include page="${footerUrl}"/>
            </footer>
            <!--footer end-->
        </div>
    </div>
</div>
<script>Cufon.now();</script>
</body>
</html>
