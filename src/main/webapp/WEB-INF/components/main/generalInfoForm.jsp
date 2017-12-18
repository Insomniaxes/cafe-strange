<form>
    <div class="wrapper pad_bot1">
        <section class="col1">
            <h2 id="welcom">Welkomsttitel:<br> <input name="title" value="${generalInfo.title}"></h2>
            <p class="color1">Intro:<br> <input name="intro" value="${generalInfo.intro}"></p>
            <p class="pad_bot1">Extra informatie:<br> <input name="extendedInfo" value="${generalInfo.extendedInfo}"></p>
            <input type="submit" formaction="/generalinfo/update" value="Opslaan" formmethod="post">

            <a href="#" class="link1">Lees meer</a>

        </section>
    </div>
</form>