<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/icons.jsp"
        var="iconsUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/navigation.jsp"
        var="navigationUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/header.jsp"
        var="headerUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/login-modal.jsp"
        var="loginUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/homeCarousel.jsp"
        var="homeCarouselUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/footer.jsp"
        var="footerUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/testimonials.jsp"
        var="testimonialsUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/blogHome.jsp"
        var="blogHomeUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/memberCarousel.jsp"
        var="memberCarouselUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/summary.jsp"
        var="summaryUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/extraTeaser.jsp"
        var="extraTeaserUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/csslinks.jsp"
        var="cssLinksUrl"/>
<spring:url
        value="${pageContext.request.contextPath}/WEB-INF/components/newComponents/scriptLinks.jsp"
        var="scriptLinksUrl"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Eindwerk Stefan Meynen</title>

    <meta name="keywords" content="">

    <jsp:include page="${cssLinksUrl}"/>

    <!-- Favicon and apple touch icons-->
    <jsp:include page="${iconsUrl}"/>
    <!-- owl carousel css -->

    <jsp:include page="${scriptLinksUrl}" />
</head>

<body>

<div id="all">

    <header>

        <!-- *** TOP *** -->
        <jsp:include page="${headerUrl}"/>

        <!-- *** NAVBAR *** -->
        <jsp:include page="${navigationUrl}"/>

    </header>

    <!-- *** LOGIN MODAL *** -->
    <jsp:include page="${loginUrl}"/>

    <!-- *** HOMEPAGE CAROUSEL *** -->
    <jsp:include page="${homeCarouselUrl}"/>

    <jsp:include page="${summaryUrl}"/>

    <!-- *** TESTIMONIALS CAROUSEL *** -->
    <jsp:include page="${testimonialsUrl}"/>

    <jsp:include page="${extraTeaserUrl}"/>


    <!-- *** BLOG HOMEPAGE *** -->
    <jsp:include page="${blogHomeUrl}"/>

    <jsp:include page="${memberCarouselUrl}"/>


    <!-- *** FOOTER *** -->
    <jsp:include page="${footerUrl}"/>

</div>
<!-- /#all -->

</body>

</html>