<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
        <link href="../css/styles.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../js/login.js" defer></script>
        <script src="../js/createArticle.js" defer></script>
    </head>
    <body>
        <%
            if(session.getAttribute("name") == null){
                response.sendRedirect("http://localhost:8080/articleManagement/index.jsp");
            }
        %>
                                                <%--  Navbar Section   --%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Articless</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Under Construction</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item"><form class="form-inline logout nav-form" action="log-out">
                        <input class="nav-input btn btn-outline" type="submit" value="Log Out">
                    </form></li>
                </ul>
            </div>
        </nav>
        <div class="article-content row justify-content-center">
            <div class="col-md-auto">
                <form method="post" id="create-article">     <%--form for create article--%>
                    <h3>Title :</h3>
                    <label><input type="text" name="title" /></label><br/>
                    <label for="create-content">Write Your Thoughts: </label><br/>
                    <textarea name="content" id="create-content" rows="20" cols="80"></textarea><br/>
                    <label>Premium Content:</label>
                    <label>Yes<input type="radio" name="premium" value="YES"></label>
                    <label>No<input type="radio" name="premium" value="NO" checked></label>
                    <br/>
                    <input type="hidden" name="created" id="date-time">
                    <input type="submit" class="btn btn-primary">
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
