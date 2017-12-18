<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>nightclub</title>
<meta charset="utf-8">
  <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/navigation.jsp" var="navigationURL"/>
  <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/welcome.jsp" var="welcomeURL"/>
  <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/event/upcomingEvents.jsp" var="upcomingURL"/>
  <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/event/nextEvent.jsp" var="nextEventURL"/>
  <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/footer.jsp" var="footerURL"/>
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script src="js/jquery-1.6.js" ></script>
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
    <!--header -->
    <header>
      <jsp:include page="${navigationURL}"/>
    </header>
    <!--header end-->
    <div class="box">
      <!--content -->
      <article id="content">
        <div class="wrapper pad_bot1">
          <jsp:include page="${welcomeURL}"/>
          <jsp:include page="${upcomingURL}"/>
        </div>
        <div class="wrapper">
          <jsp:include page="${nextEventURL}"/>
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

</body>
</html>
