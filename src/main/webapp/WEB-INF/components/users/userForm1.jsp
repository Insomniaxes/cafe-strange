<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="/users/update/${user.id}" method="post">
    <div class="container">
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
                            <h4 style="color:#00b1b1;">${user.username} </h4></span>
                            <span><p><c:forEach items="${user.roles}" var="role">${role.role}</c:forEach></p></span>
                        </div>
                        <div class="clearfix"></div>
                        <hr style="margin:5px 0 5px 0;">


                        <div class="col-sm-5 col-xs-6 tital ">Voornaam:</div>
                        <div class="col-sm-7 col-xs-6"><input name="firstName" value="${user.firstName}"></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Achternaam:</div>
                        <div class="col-sm-7"><input name="lastName" value="${user.lastName}"></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Geboortedatum:</div>
                        <div class="col-sm-7"><input name="birthday" value="${user.birthday}"></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Geslacht:</div>
                        <div class="col-sm-7"><input name="gender" value="${user.gender}"></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Lid sinds:</div>
                        <div class="col-sm-7">${user.joinDate}</div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div class="col-sm-5 col-xs-6 tital ">Nationaliteit:</div>
                        <div class="col-sm-7"><input name="nationality" value="${user.nationality}"></div>

                        <div class="clearfix"></div>
                        <div class="bot-border"></div>

                        <div align="centre"><button>Opslaan</button></div>
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