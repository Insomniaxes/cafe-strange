<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub | Parties</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/menu.jsp" var="menuURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
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
                    <figure class="left marg_right1"><a href="#"><img
                            src="${pageContext.request.contextPath}/${event.flyerURL}"
                            alt="${pageContext.request.contextPath}/${event.flyerURL}"></a></figure>
                    <h3>${event.title}</h3>
                    <p class="pad_bot1"><b>${event.summary}</b></p>
                    <%--Misschien kan ik hier nog een lijst met links plaaten--%>
                    <%--<ul class="list1 pad_bot1">--%>
                    <%--<li><a href="#">${pointOfInterest}</a></li>--%>
                    <%--</ul>--%>
                    <p>${event.description}</p>
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
