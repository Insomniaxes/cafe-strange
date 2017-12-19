
<form>
    <h1>Titel:</h1>
    <input name="title" value="${event.title}">
    <jsp:include page="${datePickerURL}"/>
    <h1>Korte beschrijving:</h1>
    <textarea name="summary" cols="40" rows="4">${event.summary}</textarea>
    <h1>Volledige beschrijving</h1>
    <textarea name="description" cols="40" rows="4">${event.description}</textarea>

</form>