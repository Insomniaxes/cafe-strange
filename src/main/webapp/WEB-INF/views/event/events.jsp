<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub | Parties</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/menu.jsp" var="menuURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
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
<body id="page2">
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
                <div class="wrapper">
                    <h2>Upcoming Parties</h2>
                    <c:forEach items="${upcomingEvents}" var="event">
                        <div class="wrapper">
                            <div class="cols marg_right1">
                                <figure class="pad_bot1"><a href="/parties/${event.id}"><img src="${event.flyerURL}" alt="${event.title}"></a>
                                </figure>
                                <figure><a href="#"><img src="images/page2_img2.jpg" alt=""></a></figure>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="wrapper">
                    <h2>Past Parties</h2>
                    <c:forEach items="${pastEvents}" var="event">
                        <div class="wrapper">
                            <div class="cols marg_right1">
                                <figure class="pad_bot1"><a href="/parties/${event.id}"><img src="${event.flyerURL}" alt="${event.title}"></a>
                                </figure>
                                <figure><a href="#"><img src="images/page2_img2.jpg" alt=""></a></figure>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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
