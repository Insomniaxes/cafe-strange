<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">

                <form action="/events/create" method="post">
                    <h1>Titel:</h1>
                    <input name="title">
                    <br><br>
                    Datum:<br>
                    <input type="date" name="date">
                    <h1>Korte beschrijving:</h1>
                    <textarea name="summary" cols="40" rows="4"></textarea>
                    <h1>Volledige beschrijving</h1>
                    <textarea name="description" cols="60" rows="6"></textarea>
                    <br><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>


    <%--<script>--%>
        <%--$(document).ready(function () {--%>
            <%--var date_input = $('input[name="date"]'); //our date input has the name "date"--%>
            <%--var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";--%>
            <%--var options = {--%>
                <%--format: 'mm/dd/yyyy',--%>
                <%--container: container,--%>
                <%--todayHighlight: true,--%>
                <%--autoclose: true,--%>
            <%--};--%>
            <%--date_input.datepicker(options);--%>
        <%--})--%>
    <%--</script>--%>