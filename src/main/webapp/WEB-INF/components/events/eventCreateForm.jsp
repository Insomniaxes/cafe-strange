<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

<script>
    tinymce.init({
        selector: "textarea",

    });
</script>

${error}

<div class="wrapper">
    <div>
        <form method="POST" enctype="multipart/form-data" action="/events/create">
            Titel:<br>
            <input name="title" value="${event.title}">
            <br><br>
            Datum:<br>
            <input name="date" value="${event.date}" type="date">
            <br><br>
            Intro:<br>
            <textarea name="summary" cols="30" rows="4">${event.summary}</textarea>
            <br><br>
            Uitgebreide info: <br>
            <textarea name="description" cols="50" rows="6">${event.description}</textarea>
            <br>
            Foto: <br>
            <input type="file" name="file" id="file">
            <img name="picture" src="" id="image"/>

            <br> <input type="submit" name="submit" value="save"> <br>
        </form>
    </div>
</div>

<script>
    document.getElementById("file").onchange = function () {
        var reader = new FileReader();

        reader.onload = function (e) {
            // get loaded data and render thumbnail.
            document.getElementById("image").src = e.target.result;
        };

        // read the image file as a data URL.
        reader.readAsDataURL(this.files[0]);
    };
</script>