<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cafe Strange</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/menu.jsp" var="menuURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/user/userDetailsForm.jsp" var="userDetailsFormURL"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all">
    <script src="${pageContext.request.contextPath}/js/jquery-1.6.js"></script>
    <script src="${pageContext.request.contextPath}/js/cufon-yui.js"></script>
    <script src="${pageContext.request.contextPath}/js/cufon-replace.js"></script>
    <script src="${pageContext.request.contextPath}/js/NewsGoth_BT_400.font.js"></script>
    <script src="${pageContext.request.contextPath}/js/NewsGoth_BT_700.font.js"></script>
    <script src="${pageContext.request.contextPath}/js/jcarousellite.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.mousewheel.js"></script>
    <script src="${pageContext.request.contextPath}/js/atooltip.jquery.js"></script>
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie.css" type="text/css" media="all">
    <![endif]-->
</head>
<body id="page1">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${menuURL}"/>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <jsp:include page="${userDetailsFormURL}"/>
            </article>
            <!--content end-->
            <!--footer -->
            <footer>
                <jsp:include page="${footerURL}"/>
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
