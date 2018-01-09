<form action="/generalInfo/update" method="post">
    <h3><input name="title" value="${info.title}"></h3>
    <p><textarea name="intro" rows="2" cols="20">${info.intro}</textarea></p>
    <p><textarea name="extendedInfo" rows="4" cols="60">${info.extendedInfo}</textarea></p>
    <br>
    <button>Opslaan</button>
</form>