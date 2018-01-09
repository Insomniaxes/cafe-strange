<form action="/videos/update/${video.id}" method="post">
    <h3>Titel:</h3>
    <h3><input name="title" value="${video.title}"></h3>
    <h3>Caption:</h3>
    <h3><input name="caption" value="${video.caption}"></h3>
    <h3>Url:</h3>
    <h3><input name="url" value="${video.url}"></h3>
    <button>Opslaan</button>
</form>