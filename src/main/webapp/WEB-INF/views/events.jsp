<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/end.jsp" var="endUrl"/>
<html>
<head>
    <jsp:include page="${headUrl}"/>
</head>
<body>

<jsp:include page="${navigationUrl}"/>

<header>

</header>
<footer>
    <jsp:include page="${footerUrl}"/>
</footer>
<jsp:include page="${endUrl}"/>
</body>
</html>
