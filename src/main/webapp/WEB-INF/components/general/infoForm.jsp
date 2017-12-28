<div class="wrapper">
    <form>
        <h2>Titel:</h2>
        <input name="title" value="${info.title}"><br>
        Korte omschrijving:<br>
        <textarea name="intro" rows="4" cols="30">${info.intro}</textarea><br>
        Uitgebreide info:<br>
        <textarea name="extendedInfo" rows="6" cols="60">${info.extendedInfo}</textarea><br><br>

        <input type="submit" value="Opslaan" formmethod="post" formaction="/generalInfo/update">
        <p></p>
    </form>
</div>