<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags" %>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/head.jsp" var="headUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/navigation.jsp" var="navUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/main/footer.jsp" var="footerUrl"/>
<Spring:url value="${pageContext.request.contextPath}/WEB-INF/components/media/video/videoOverview.jsp" var="videoUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Strange | Pictures</title>
  <jsp:include page="${headUrl}"/>
</head>
<body id="page3">
<div class="bg1">
  <div class="main">
    <!--header -->
    <header>
      <jsp:include page="${navUrl}"/>
    </header>
    <!--header end-->
    <div class="box">
      <!--content -->
      <article id="content">
        <jsp:include page="${videoUrl}"/>
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
<script>Cufon.now();</script>
<script>
    $(document).ready(function () {
        var Img = '#' + $(".folio .active").attr('id')
        $(".folio dt img").css({
            opacity: '0'
        });
        $(".folio dt img.active").css({
            opacity: '1'
        });
        $(".folio ul li a").click(function () {
            var ImgId = $(this).attr("href");
            if (ImgId != Img) {
                $(".folio dt .active").animate({
                    opacity: "0"
                }, 600, function () {
                    $(this).removeClass('active');
                })
                $(ImgId).animate({
                    opacity: "1"
                }, 600).addClass('active');
            }
            Img = ImgId;
            return false;
        })
    });
</script>
</body>
</html>
