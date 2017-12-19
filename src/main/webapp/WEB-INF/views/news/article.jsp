<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub | News</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/news/article.jsp" var="articleURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/scriptsEnCSS.jsp" var="scriptsEnCSSURL"/>
    <jsp:include page="${scriptsEnCSSURL}"/>
</head>
<body id="page5">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${navigationURL}"/>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <jsp:include page="${articleURL}"/>
            <!--content end-->
            <!--footer -->
            <footer>
                <jsp:include page="${footerURL}"/>
            </footer>
            <!--footer end-->
        </div>
    </div>
</div>
<script>Cufon.now();</script>
</body>
</html>
