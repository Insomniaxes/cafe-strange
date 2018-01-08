<div class="wrapper">
    <div>
        <form method="POST" enctype="multipart/form-data" action="/events/update/${event.id}">
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
            <input type="file" name="file" value="${event.picture}">
            <br> <input type="submit" name="submit" value="save"> <br>
        </form>
    </div>
</div>