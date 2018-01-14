<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        border: 2px solid #03b1ce;
    }

    .tital {
        font-size: 16px;
        font-weight: 500;
        color: white;
    }

    .infoText {
        color: white;
    }

    .bot-border {
        border-bottom: 1px #f8f8f8 solid;
        margin: 5px 0 5px 0
    }
</style>

<form action="/users/create" method="post">
    <div class="container">
        ${errorMessage}
        <div class="panel panel-default">
            <div class="panel-heading"><h4>User Profile</h4></div>
            <div class="panel-body">

                <div class="box box-info">

                    <div class="box-body">
                        <div class="col-sm-6">
                            <div align="center"><img alt="User Pic"
                                                     src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
                                                     id="profile-image1" class="img-circle img-responsive">

                                <input id="profile-image-upload" class="hidden" type="file">
                                <div style="color:#999;">click here to change profile image</div>
                                <!--Upload Image Js And Css-->


                            </div>

                            <br>

                            <!-- /input-group -->
                        </div>
                        <div class="col-sm-6">
                            <h3 style="color:#00b1b1;"><input name="username" value="${user.username}" required></h3></span>
                            <span>
                            <p>MEMBER</p>
                            </span>
                        </div>
                        <div class="clearfix"></div>
                        <hr style="margin:5px 0 5px 0;">


                        <div class="col-sm-5 col-xs-6 tital ">Voornaam:</div>
                        <div class="col-sm-7 col-xs-6"><input name="firstName" value="${user.firstName}" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Achternaam:</div>
                        <div class="col-sm-7"><input name="lastName" value="${user.lastName}" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Geboortedatum:</div>
                        <div class="col-sm-7"><input type="date" name="birthday" value="${user.birthday}" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Geslacht:</div>
                        <div class="col-sm-7"><select name="gender" required>
                            <c:forEach items="${genders}" var="gender">
                                <option value="${gender}">${gender}</option>
                            </c:forEach>
                        </select>
                        </div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital infoText">Lid sinds:</div>
                        <div class="col-sm-7">${user.joinDate}</div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital infoText">Email:</div>
                        <div class="col-sm-7"><input name="email" value="${user.email}" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Nationaliteit:</div>
                        <div class="col-sm-7"><input name="nationality" value="${user.nationality}" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Password:</div>
                        <div class="col-sm-7"><input type="password" name="password" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Password:</div>
                        <div class="col-sm-7"><input type="password" name="passwordRetype" required></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div>
                            <input type="submit" value="Opslaan">
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->

                </div>


            </div>
        </div>
    </div>
    <script>
        $(function () {
            $('#profile-image1').on('click', function () {
                $('#profile-image-upload').click();
            });
        });
    </script>


    </div>
    </div>
</form>