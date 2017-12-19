<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">
    Datum: <br>
    <ftm:formatDate value="${news.date}" pattern="dd.MM"/<br>
    <input type="text" name="title">
    <textarea
    <div class="wrapper pad_bot1">
        <figure class="left marg_right1"><img src="images/page5_img1.jpg" alt=""></figure>
        <p class="color1 pad_bot1">${news.intro}</p>
        <p class="pad_bot1">${news.article}</p>
    </div>
</div>