<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">Cafe-Strange</a>
    </div>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
            <li><a href="#">Nog niets</a></li>
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">Evenementen <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/events?argName=upcoming">Aankomend</a></li>
                    <li><a class="dropdown-item" href="/events?argName=past">Afgelopen</a></li>
                    <li><a class="dropdown-item" href="/events?argName=all">Alle</a></li>
                    <sec:authorize access="hasAnyRole('ADMIN','OWNER')">
                        <li><a class="dropdown-item" href="/events/new">Nieuw aanmaken</a></li>
                    </sec:authorize>
                </ul>
            </li>
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">Media <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/pictures">Foto's</a></li>
                    <li><a class="dropdown-item" href="/videos">Filmpjes</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search">
                <span class="input-group-btn">
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Login</a></li>
        </ul>
    </div>
</nav>