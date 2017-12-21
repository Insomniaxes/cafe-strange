<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/welcome.jsp" var="welcomeUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/upcomingIndex.jsp" var="upcomingUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/next.jsp" var="nextEventUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <script src="js/jquery-1.6.js"></script>
    <script src="js/cufon-yui.js"></script>
    <script src="js/cufon-replace.js"></script>
    <script src="js/NewsGoth_BT_400.font.js"></script>
    <script src="js/NewsGoth_BT_700.font.js"></script>
    <script src="js/jcarousellite.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.mousewheel.js"></script>
    <script src="js/atooltip.jquery.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="all">
    <![endif]-->
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
