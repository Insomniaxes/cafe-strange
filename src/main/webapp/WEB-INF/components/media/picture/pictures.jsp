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
        <!-- Slider -->
        <div class="row">
            <div class="col-sm-6" id="slider-thumbs">
                <!-- Bottom switcher of slider -->
                <ul class="hide-bullets">
                    <c:forEach items="${pictures}" var="picture" varStatus="status">

                        <li class="col-sm-3">
                            <a class="thumbnail" id="carousel-selector-${status}"></a>
                            <img src="${pageContext.request.contextPath}/img${picture.url}">
                            <form action="/pictures/delete/${picture.id}" method="post">
                                <button class="btn btn-info btn-lg">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </button>
                            </form>
                        </li>

                    </c:forEach>
                </ul>
            </div>
            <div class="col-sm-6">
                <div class="col-xs-12" id="slider">
                    <!-- Top part of the slider -->
                    <div class="row">
                        <div class="col-sm-12" id="carousel-bounding-box">
                            <div class="carousel slide" id="myCarousel">
                                <!-- Carousel items -->
                                <div class="carousel-inner">
                                    <c:forEach items="${pictures}" var="picture" varStatus="status">
                                        <c:choose>
                                            <c:when test="${status.first}">
                                                <div class="active item" data-slide-number="${status}">
                                                    <img src="${pageContext.request.contextPath}/img${picture.url}">
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="item" data-slide-number="${status}">
                                                    <img src="${pageContext.request.contextPath}/img${picture.url}">
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                                <!-- Carousel nav -->
                                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/Slider-->
        </div>

    </div>
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