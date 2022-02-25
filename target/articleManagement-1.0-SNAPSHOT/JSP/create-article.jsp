<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
        <link href="../css/styles.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../js/createArticle.js" defer></script>
    </head>
    <body>
        <%
            if(session.getAttribute("name") == null){
                response.sendRedirect("../index.jsp");
            }
        %>

        <div class="article-content">
            <form method="post" id="create-article">     <%--form for create article--%>
                <h3>Title :</h3>
                <label><input type="text" name="title" /><br/></label>
                <label for="create-content">Write Your Thoughts: </label>
                <textarea name="content" id="create-content" rows="10" cols="40"></textarea>

                <label>Premium Content:</label>
                <label>Yes<input type="radio" name="premium" value="YES"></label>
                <label>No<input type="radio" name="premium" value="NO" checked></label>
                <input type="hidden" name="created" id="date-time">
                <input type="submit">
            </form>
        </div>

        <div class="log-out"> <%-- logout div --%>
            <form action = "log-out">
                <input type="submit" value="Log out">
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
