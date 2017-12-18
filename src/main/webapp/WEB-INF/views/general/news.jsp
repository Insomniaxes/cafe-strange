<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>nightclub | News</title>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/menu.jsp" var="menuURL"/>
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerURL"/>
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
<body id="page5">
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
                    <h2><strong>02.09.</strong> Sed ut perspiciatis unde omnis iste natus</h2>
                    <div class="wrapper pad_bot1">
                        <figure class="left marg_right1"><img src="images/page5_img1.jpg" alt=""></figure>
                        <p class="color1 pad_bot1">At vero eos et accusamus et iusto odio dignissimos ducimus qui
                            blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas.</p>
                        <p class="pad_bot1">Molestias excepturi sint occaecati cupiditate non provident, similique sunt
                            in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum
                            quidem rerufacilis est et expedita distinctio. Nam libero tepre cum soluta nobis est
                            eligendi.</p>
                        <a href="#" class="link2">Read More</a></div>
                    <h2><strong>29.08.</strong> Error sit voluptatem accusantium</h2>
                    <div class="wrapper pad_bot1">
                        <figure class="left marg_right1"><img src="images/page5_img2.jpg" alt=""></figure>
                        <p class="color1 pad_bot1">Molestias excepturi sint occaecati cupiditate non facere possimus,
                            omnis voluptas assum enda est, omnis dolor repellendus.</p>
                        <p class="pad_bot1">Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus
                            saepe eve provident, similique sunt in culpa qui officia deserunt mollitia animi, id est
                            laborum et dolorum fuga est et expedita distinctio cum soluta nobis eligendi.</p>
                        <a href="#" class="link2">Read More</a></div>
                    <h2><strong>22.08.</strong> Nemo enim ipsam voluptatem quia voluptas</h2>
                    <div class="wrapper">
                        <figure class="left marg_right1"><img src="images/page5_img3.jpg" alt=""></figure>
                        <p class="color1 pad_bot1">At vero eos et accusamus et iusto odio dignissimos ducimus qui
                            blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas.</p>
                        <p class="pad_bot1">Molestias excepturi sint occaecati cupiditate non provident, similique sunt
                            in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum
                            quidem rerufacilis est et expedita distinctio. Nam libero tepre cum soluta nobis est
                            eligendi.</p>
                        <a href="#" class="link2">Read More</a></div>
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
