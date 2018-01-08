<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="/home">Cafe-Strange</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navBarMain">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Evenementen</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/events?argName=upcoming">Aankomend</a>
                    <a class="dropdown-item" href="/events?argName=past">Afgelopen</a>
                    <a class="dropdown-item" href="/events?argName=all">Alle</a>
                    <sec:authorize access="hasAnyRole('ADMIN','OWNER')">
                        <a class="dropdown-item" href="#">Nieuw aanmaken</a>
                    </sec:authorize>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown02" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Media</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/pictures">Foto's</a>
                    <a class="dropdown-item" href="/videos">Filmpjes</a>
                </div>
            </li>
        </ul>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.authenticated}">
                <sec:authentication var="user" property="principal" />
                <a href="/users/${user.id}">${user.firstName} ${user.lastName}</a>
            </c:when>
            <c:otherwise>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Username" name="username">
                    <input class="form-control mr-sm-2" type="password" placeholder="Password" name="password">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" formaction="login"
                            formmethod="post">Login
                    </button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</nav>