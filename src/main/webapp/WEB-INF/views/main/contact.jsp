<%@ taglib prefix="Spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cafe Strange | Contact</title>
    <meta charset="utf-8">
    <Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navigationURL"/>
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
<body id="page6">
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
                <div class="wrapper">
                    <h2>Contact Form</h2>
                    <form id="ContactForm" action="#">
                        <div>
                            <div class="wrapper"><span>Name:</span>
                                <input type="text" class="input">
                            </div>
                            <div class="wrapper"><span>Email:</span>
                                <input type="text" class="input">
                            </div>
                            <div class="wrapper"><span>Subject:</span>
                                <input type="text" class="input">
                            </div>
                            <div class="textarea_box"><span>Message:</span>
                                <textarea name="textarea" cols="1" rows="1"></textarea>
                            </div>
                            <a href="#" class="button">send</a> <a href="#" class="button">clear</a></div>
                    </form>
                </div>
                <div class="wrapper">
                    <div class="col1">
                        <h2>Contact</h2>
                        <p class="color1 pad_bot1">Dambruggestraat 161 <br>2018 Antwerpen</p>
                        <p class="address">Gsm:<br>
                            <br>
                            E-Mail:<br>
                            </p>
                        <p>+32 0400 00 00 00<br>
                            <br>
                            <br>
                            <a href="mailto:stef@sitefun.be" class="link2">stef@sitefun.be</a></p>
                    </div>
                    <div class="col2 pad_left1">
                        <h2>Miscellaneous Info</h2>
                        <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium
                            voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati
                            cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id
                            est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam
                            libero tempore, cum soluta nobis est eligendi optio cumque.</p>
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
<script>Cufon.now();</script>
</body>
</html>
