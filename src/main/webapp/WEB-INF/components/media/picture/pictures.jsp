<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .hide-bullets {
        list-style: none;
        margin-left: -40px;
        margin-top: 20px;
    }

    .thumbnail {
        padding: 0;
    }

    .carousel-inner > .item > img, .carousel-inner > .item > a > img {
        width: 100%;
    }
</style>

<div class="container">
    <div id="main_area">
        <c:if test="${not empty pictures}">
            <!-- Slider -->
            <div class="row">
                <div class="col-sm-6" id="slider-thumbs">
                    <!-- Bottom switcher of slider -->
                    <ul class="hide-bullets">
                        <c:forEach items="${pictures}" var="picture" varStatus="status">
                            <li class="col-sm-3">
                                <a class="thumbnail" id="carousel-selector-${status}">
                                    <img src="${pageContext.request.contextPath}/${picture.url}">
                                </a>
                            </li>
                        </c:forEach></ul>
                </div>
                <div class="col-sm-6">
                    <div class="col-xs-12" id="slider">
                        <!-- Top part of the slider -->
                        <div class="row">
                            <div class="col-sm-12" id="carousel-bounding-box" style="width: 500px">
                                <div class="carousel slide" id="myCarousel">
                                    <!-- Carousel items -->
                                    <div class="carousel-inner">
                                        <c:forEach items="${pictures}" var="picture" varStatus="status">
                                            <c:choose>
                                                <c:when
                                                        test="${status.first}">
                                                    <div class="active item" data-slide-number="${status}"><img
                                                            src="${pageContext.request.contextPath}/${picture.url}">
                                                        <div class="carousel-caption"><h3>${picture.title}</h3></div>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="item" data-slide-number="${status}"><img
                                                            src="${pageContext.request.contextPath}/${picture.url}">
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach></div>
                                    <!-- Carousel nav -->
                                    <a class="left carousel-control" href="#myCarousel" role="button"
                                       data-slide="prev"> <span
                                            class="glyphicon glyphicon-chevron-left"></span> </a> <a
                                        class="right carousel-control" href="#myCarousel" role="button"
                                        data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span> </a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/Slider-->
            </div>
        </c:if>
    </div>
    <form action="/pictures/uploadMultiple" method="post" enctype="multipart/form-data">
        <input name="category">
        <input type="file" name="multipartFiles" multiple>
        <input type="submit" value="Opslaan">
    </form>
</div>

<script>
    jQuery(document).ready(function ($) {
        $('#myCarousel').carousel({
            interval: 10000
        });
        //Handles the carousel thumbnails
        $('[id^=carousel-selector-]').click(function () {
            var id_selector = $(this).attr("id");
            try {
                var id = /-(\d+)$/.exec(id_selector)[1];
                console.log(id_selector, id);
                jQuery('#myCarousel').carousel(parseInt(id));
            } catch (e) {
                console.log('Regex failed!', e);
            }
        });
// When the carousel slides, auto update the text
        $('#myCarousel').on('slid.bs.carousel', function (e) {
            var id = $('.item.active').data('slide-number');
            $('#carousel-text').html($('#slide-content-' + id).html());
        });
    });
</script>
