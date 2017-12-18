<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub | Contact</title>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/menu.jsp" var="menuURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/contactInfo.jsp" var="contactInfoURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/mailForm.jsp" var="mailFormURL"/>
    <meta charset="utf-8">
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
<body id="page6">
<div class="bg1">
    <div class="main">
        <!--header -->
        <header>
            <jsp:include page="${menuURL}"/>
            <h1><a href="../index.jsp" id="logo">nightclub feel the rhythm</a></h1>
        </header>
        <!--header end-->
        <div class="box">
            <!--content -->
            <article id="content">
                <div class="wrapper">
                    <h2>Contact Form</h2>
                    <jsp:include page="${mailFormURL}"/>
                </div>
                <jsp:include page="${contactInfoURL}"/>
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
<script>Cufon.now();</script>
</body>
</html>
