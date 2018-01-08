<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/end.jsp" var="endUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/upcoming.jsp" var="upcomingUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/welcome.jsp" var="welcomeUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/index/nextEvent.jsp" var="nextUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="${headUrl}"/>
    <link type="text/css" href="${pageContext.request.contextPath}/css/myCss/reset.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/css/myCss/layout.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/css/myCss/myStyle.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/templateJs/jquery-1.6.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/cufon-yui.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/cufon-replace.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/NewsGoth_BT_400.font.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/NewsGoth_BT_700.font.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/jcarousellite.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/jquery.easing.1.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/jquery.mousewheel.js"></script>
    <script src="${pageContext.request.contextPath}/js/templateJs/atooltip.jquery.js"></script>
    <!--[if lt IE 9]>
    <script src="../../../js/templateJs/html5.js"></script>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="all">
    <![endif]-->
</head>
<body id="page1">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <nav>
                <jsp:include page="${navigationUrl}"/>
            </nav>
            <h1><a href="index.html" id="logo">nightclub feel the rhythm</a></h1>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <div class="wrapper pad_bot1">
                    <jsp:include page="${welcomeUrl}"/>
                    <jsp:include page="${upcomingUrl}"/>
                </div>
                <jsp:include page="${nextUrl}"/>
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
    $(document).ready(function () {
        //gallery
        $("#gallery1").jCarouselLite({
            btnNext: ".next",
            btnPrev: ".prev",
            mouseWheel: true,
            vertical: true,
            circular: true,
            visible: 2,
            speed: 600,
            easing: 'easeOutCirc'
        });
        Cufon.now();
    })
</script>
</body>
</html>
