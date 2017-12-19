<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${event.title}</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/events/event.jsp" var="eventURL"/>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <script src="js/jquery-1.6.js"></script>
    <script src="js/cufon-yui.js"></script>
    <script src="js/cufon-replace.js"></script>
    <script src="js/NewsGoth_BT_400.font.js"></script>
    <script src="js/NewsGoth_BT_700.font.js"></script>
    <script src="js/atooltip.jquery.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="all">
    <![endif]-->
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
            <jsp:include page="${eventURL}"/>
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
