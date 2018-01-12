<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .container {
        width: 50%;
    }

    input.hidden {
        position: absolute;
        left: -9999px;
    }
    #profile-image1 {
        cursor: pointer;

        width: 100px;
        height: 100px;
        border:2px solid #03b1ce ;}
    .tital{
        font-size:16px;
        font-weight:500;
        color: white;
    }
    .infoText {
        color: white;
    }
    .bot-border{
        border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0
    }
</style>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><h4>User Profile</h4></div>
        <div class="panel-body">

            <div class="box box-info">

                <div class="box-body">
                    <div class="col-sm-6">
                        <div align="center">
                            <c:choose>
                                <c:when test="${empty user.picture}">
                                    <img alt="User Pic"
                                         src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
                                         id="profile-image1" class="img-circle img-responsive">
                                </c:when>
                                <c:otherwise>
                                    <img alt="User Pic"
                                         src="${pageContext.request.contextPath}/${user.picture.url}"
                                         id="profile-image1" class="img-circle img-responsive">
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <br>

                        <!-- /input-group -->
                    </div>
                    <div class="col-sm-6">
                        <h4 style="color:#00b1b1;">${user.username} </h4></span>
                        <span><p><c:forEach items="${user.roles}" var="role">${role.role}</c:forEach></p></span>
                    </div>
                    <div class="clearfix"></div>
                    <hr style="margin:5px 0 5px 0;">


                    <div class="col-sm-5 col-xs-6 tital ">Voornaam:</div>
                    <div class="col-sm-7 col-xs-6 infoText">${user.firstName}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div class="col-sm-5 col-xs-6 tital ">Achternaam:</div>
                    <div class="col-sm-7 infoText"> ${user.lastName}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div class="col-sm-5 col-xs-6 tital ">Geboortedatum:</div>
                    <div class="col-sm-7 infoText"><fmt:formatDate value="${user.birthday}" pattern="dd-MM-YYY"/></div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div class="col-sm-5 col-xs-6 tital ">Geslacht:</div>
                    <div class="col-sm-7 infoText">${user.gender}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div class="col-sm-5 col-xs-6 tital ">Lid sinds:</div>
                    <div class="col-sm-7 infoText"><fmt:formatDate value="${user.joinDate}" pattern="dd-MM-YYY"/></div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div class="col-sm-5 col-xs-6 tital ">Nationaliteit:</div>
                    <div class="col-sm-7 infoText">${user.nationality}</div>

                    <div class="clearfix"></div>
                    <div class="bot-border"></div>

                    <div align="centre"><form method="get" action="/users/edit/${user.id}"><button>Aanpassen</button></form></div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->

            </div>


        </div>
    </div>
</div>

</div>
</div>