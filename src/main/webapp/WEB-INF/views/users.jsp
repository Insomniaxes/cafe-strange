<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/end.jsp" var="endUrl"/>
<Spring:url value="${pageContext.request.contextPath}/${page}.jsp" var="componentUrl"/>
<html>
<body id="page1">
<head>
    <jsp:include page="${headUrl}"/>
</head>
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${navigationUrl}"/>
        </header>
        <div class="box">
            <!--content -->
            <article id="content">
                <div class="wrapper pad_bot1">
                    <jsp:include page="${componentUrl}"/>
                </div>
            </article>
        </div>

        <footer>
            <jsp:include page="${footerUrl}"/>
        </footer>
        <jsp:include page="${endUrl}"/>
    </div>
</div>
</body>
</html>
