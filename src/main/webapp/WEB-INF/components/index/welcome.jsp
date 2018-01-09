<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<section class="col1">
    <h2 id="welcom">${info.title}</h2>
    <p class="color1">${info.intro}</p>
    <p class="pad_bot1">${info.extendedInfo}</p>
    <sec:authorize access="hasAnyRole('ADMIN', 'MASTER')">
        <form action="/generalInfo/edit">
            <button>Aanpassen</button>
        </form>
    </sec:authorize>
</section>