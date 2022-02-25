<%--
  Created by IntelliJ IDEA.
  User: praveen-pt4650
  Date: 15/02/22
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Read Article</title>
        <link href="../../css/styles.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../../js/login.js" defer></script>
        <script src="../../js/readArticle.js" defer></script>
    </head>
    <body>
        <%
            if(session.getAttribute("name") == null){
                response.sendRedirect("http://localhost:8080/articleManagement/index.jsp");
            }
        %>
        <input id="session-name" type="hidden" value="${name}">
        <input id="article-id" type="hidden" name="article_id" value="${article_id}" >
        <input id="user-id" type="hidden" name="user-id" value="${user_id}">
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
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item create-article">
                        <a class="nav-link log-button" href="../JSP/create-article.jsp">Create Article</a>
                    </li>
                    <li class="nav-item"><form class="form-inline logout nav-form" action="log-out">
                        <input class="nav-input btn btn-outline" type="submit" value="Log Out">
                    </form></li>
                </ul>
            </div>
        </nav>
        <div id ="write-article">
        </div>
        <div id="user-activities">
            <button type="button" class="btn btn-white" id="like-button">
                <i class="bi bi-hand-thumbs-up" id="like"></i><span>Like</span>
            </button>
            <button type="button" class="btn btn-white">
                <i class="bi bi-chat"></i> Comment
            </button>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
