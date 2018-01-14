<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">Cafe Strange</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <sec:authorize access="hasAnyRole('ADMIN','MASTER')">
                    <li class="active"><a href="/users">Leden</a></li>
                </sec:authorize>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Evenementen <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a class="dropdown-item" href="/events?argName=upcoming">Aankomend</a></li>
                        <li><a class="dropdown-item" href="/events?argName=past">Afgelopen</a></li>
                        <li><a class="dropdown-item" href="/events?argName=all">Alle</a></li>
                        <sec:authorize access="hasAnyRole('ADMIN','MASTER')">
                            <li class="divider"></li>
                            <li><a class="dropdown-item" href="/events/new">Nieuw aanmaken</a></li>
                        </sec:authorize>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Media <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a class="dropdown-item" href="/pictures">Foto's</a></li>
                        <li><a class="dropdown-item" href="/videos">Filmpjes</a></li>
                        <sec:authorize access="hasAnyRole('ADMIN','MASTER')">
                            <li class="divider"></li>
                            <li><a class="dropdown-item" href="/videos/new">Nieuwe video</a></li>
                            <li><a class="dropdown-item" href="/media/new">Nieuwe Foto's</a></li>
                        </sec:authorize>
                    </ul>
                </li>
                <li><a href="/news">Nieuws</a></li>
            </ul>
            <%--<form class="navbar-form navbar-left" role="search">--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="Search">--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-default">Submit</button>--%>
            <%--</form>--%>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.authenticated}">
                        <sec:authentication var="user" property="principal"/>
                        <form action="/logout"><button class="navbar-text">Logout</button></form>
                    </c:when>
                    <c:otherwise>
                        <li><p class="navbar-text">Reeds een account?</p></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span
                                    class="caret"></span></a>
                            <ul id="login-dp" class="dropdown-menu">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            Login via
                                            <div class="social-buttons">
                                                <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i>
                                                    Facebook</a>
                                                <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                            </div>
                                            or
                                            <form class="form" role="form" method="post" action="/login"
                                                  accept-charset="UTF-8" id="login-nav">
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputEmail2">Email
                                                        address</label>
                                                    <input name="username" type="text" class="form-control"
                                                           id="exampleInputEmail2" placeholder="Username" required>
                                                </div>
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                    <input name="password" type="password" class="form-control"
                                                           id="exampleInputPassword2" placeholder="Password">
                                                    <div class="help-block text-right"><a href="">password vergeten?                                                        ?</a></div>
                                                </div>
                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-primary btn-block">Sign in
                                                    </button>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox"> hou me ingelogd
                                                    </label>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="bottom text-center">
                                            Nieuw hier? <a href="/users/register"><b>Registreer</b></a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


</body>