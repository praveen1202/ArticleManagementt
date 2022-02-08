<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
        <link href="css/styles.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/createArticle.js" defer></script>
    </head>
    <body>
        <%
            if(session.getAttribute("name") == null){
                response.sendRedirect("index.jsp");
            }
        %>

        <div class="article-content">
            <form action="CreateArticle" method="post" id="create-article">
                <h3>Title :</h3>
                <input type="text" name="title" /><br/>
                <label for="create-content">Write Your Thoughts: </label>
                <textarea name="content" id="create-content" rows="10" cols="40"></textarea>
                <label>Premium Content:<input class="content-type" type="checkbox" name="premium" value="YES" checked></label>
                <input id="create-article-submit" type="submit">
            </form>
        </div>

        <div class="add">
            <button id="time">Get Time</button>
            <p id="get-time"></p>
        </div>

        <div class="log-out"> <%-- logout div --%>
            <form action = "log-out" method = "POST">
                <input type="submit" value="Log out">
            </form>
        </div>
    </body>
</html>