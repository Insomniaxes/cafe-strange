<div class="wrapper">
    <div>
        <form method="POST" enctype="multipart/form-data" action="/events/create">
            Titel:<br>
            <input name="title" value=""> <br><br>
            Datum:<br>
            <input name="date" value="" type="date"><br><br>
            Intro:<br>
            <textarea name="summary" cols="30" rows="4"></textarea><br><br>
            Uitgebreide info: <br>
            <textarea name="description" cols="50" rows="6"></textarea> <br>
            Media: <br>
            <input type="file" name="file"><br>
            <input type="submit" name="submit" value="save"> <br>
        </form>
    </div>
</div>