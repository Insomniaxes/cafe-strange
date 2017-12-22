<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/general/generalInfo.jsp" var="infoUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all">
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
<body id="page2">
<div class="bg1">
    <div class="main">
        <jsp:include page="${navUrl}"/>
        <div class="box">
            <!--content -->
            <article id="content">
                <jsp:include page="${infoUrl}"/>
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
