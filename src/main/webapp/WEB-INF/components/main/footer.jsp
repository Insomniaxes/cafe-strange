<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="line1">
    <div class="line2 wrapper">
        <div class="icons">
            <h4>Connect With Us</h4>
            <ul id="icons">
                <li><a href="#" class="normaltip"><img src="images/icon1.jpg" alt=""></a></li>
                <li><a href="#" class="normaltip"><img src="images/icon3.jpg" alt=""></a></li>
                <li><a href="#" class="normaltip"><img src="images/icon4.jpg" alt=""></a></li>
            </ul>
            <!-- {%FOOTER_LINK} -->
        </div>
        <div class="info">
            <h4>About Us</h4>
            <ul>
                <li><a href="#">Club Info</a></li>
                <li><a href="#">Music</a></li>
                <li><a href="#">DJ Sets</a></li>
                <li><a href="#">News</a></li>
            </ul>
        </div>
        <div class="info">
            <h4>Join In</h4>
            <ul>
                <li><a href="#">Sign In</a></li>
                <li><a href="#">Forums</a></li>
                <li><a href="#">Promotions</a></li>
            </ul>
        </div>
        <div class="phone">
            <table style="text-align: left; width: 100%">
                <c:forEach items="${openingHours}" var="open">
                    <tr>
                        <th>${open.weekday}</th>
                        <td><c:if test="${empty open.open}"><b>Closed</b></c:if>${open.open}</td>
                        <td>${open.closed}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    Copyright &copy; <a href="#">www.cafe-strange.be</a> All Rights Reserved | Design by <a target="_blank"
                                                                                            href="http://www.templatemonster.com/">TemplateMonster.com</a>
</div>