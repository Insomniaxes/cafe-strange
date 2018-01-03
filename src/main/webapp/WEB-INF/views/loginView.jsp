<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/loginForm.jsp" var="loginUrl"/>
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
                    <jsp:include page="${loginUrl}"/>
                </div>
                <div class="wrapper">
                    <%--// hier komt misschien nog iets --%>
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



