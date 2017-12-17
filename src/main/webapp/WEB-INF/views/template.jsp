<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cafe Strange</title>
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
                <div class="wrapper pad_bot1">
                    <section class="col1">
                        <h2 id="welcom">Hello!</h2>
                        <p class="color1">Night Club is one of free website templates created by TemplateMonster.com
                            team. This website template is optimized for 1024X768 screen resolution. It is also XHTML
                            &amp; CSS valid.</p>
                        <p class="pad_bot1">This Night Club Template goes with two packages – with PSD source files and
                            without them. PSD source files are available for free for the registered members of
                            Templates.com. The basic package (without PSD source) is available for anyone without
                            registration.</p>
                        <a href="#" class="link1">Read More</a></section>
                    <section class="col1 pad_left1">
                        <h2>Latest Events</h2>
                        <div id="gallery1">
                            <ul>
                                <li><span class="dropcap_1">30<span>august</span></span>
                                    <p><span class="color1">Lorem ipsum dolor sit amet</span><br>
                                        adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
                                        aliqua.<br>
                                        <a href="#" class="link1">View Details</a></p>
                                </li>
                                <li><span class="dropcap_1">26<span>august</span></span>
                                    <p><span class="color1">Ut enim ad minim veniam nostrud</span><br>
                                        Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. <br>
                                        <a href="#" class="link1">View Details</a></p>
                                </li>
                            </ul>
                        </div>
                        <a href="#" class="next"></a> <a href="#" class="prev"></a></section>
                </div>
                <div class="wrapper">
                    <h2>Next Party</h2>
                    <div class="wrapper">
                        <figure class="left marg_right1"><a href="#"><img src="${pageContext.request.contextPath}/images/banner1.jpg" alt=""></a></figure>
                        <h3>Best RNB from Europe</h3>
                        <p class="pad_bot1">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium
                            doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo:</p>
                        <ul class="list1 pad_bot1">
                            <li><a href="#">Ut enim ad minima veniam, quis nostrum exercitationem ullam</a></li>
                            <li><a href="#">Quis autem vel eum iure reprehenderit qui in voluptate</a></li>
                            <li><a href="#">Velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum</a>
                            </li>
                            <li><a href="#">Fugiat quo voluptas nulla pariatur lorem ipsum dolor sit amet</a></li>
                        </ul>
                        <p>Inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
                            aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                            voluptatem quia voluptas sit aspernatur.</p>
                    </div>
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
