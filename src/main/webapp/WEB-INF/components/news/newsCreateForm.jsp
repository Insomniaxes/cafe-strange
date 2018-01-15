<script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

<script>
    tinymce.init({
        selector : "textarea",

    });
</script>

<div class="wrapper">
    <div>
        <form method="POST" enctype="multipart/form-data" action="/news/create">
            Datum:<br>
            <input name="date" type="date">
            <br><br>
            Titel:<br>
            <input name="title">
            <br><br>
            Intro:<br>
            <textarea name="intro" cols="30" rows="4"></textarea>
            <br><br>
            Uitgebreide info: <br>
            <textarea name="article" cols="50" rows="6"></textarea>
            <br><br>
            Bron:<br>
            <input name="source">
            <br><br>
            <br> <button>Opslaan</button> <br>
        </form>
    </div>
</div>