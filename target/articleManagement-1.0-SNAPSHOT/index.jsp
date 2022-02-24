<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP</title>
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/login.js" defer></script>
        <script src="js/signUpReq.js" defer></script>
    </head>
    <body>
                                <%--   Navbar Section     --%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Articless</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">

            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Under Construction</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item create-article">
                    <a class="nav-link log-button" href="JSP/create-article.jsp">Create Article</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link log-button" href="#">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link sign-button" href="#">Sign Up</a>
                </li>

            </ul>
        </div>
    </nav>
        <h2 class="session">${name}</h2>
        <input id="session-name" type="hidden" value="${name}">         <%--  checks if user is logged in or not and changes js files accordingly  --%>
        <br/>
        <div id="form-entry">       <%--  login and signup forms  --%>
            <div class="sign-up"> <%-- signup div --%>
                <form id="form-signup" method="post">
                    <label>Enter Username : <input type="text" name="sign-username" required></label>
                    <br/>
                    <label>Enter Password : <input id="sign-password-1" type="text" name="sign-password-1" required></label>
                    <br/>
                    <label>Re-Enter Password : <input id="sign-password-2" type="text" name="sign-password-2" required></label>
                    <br/>
                    <label>Email Id : <input id="email-id" type="email" name="email-id" required></label>
                    <input type="submit" value="Sign Up">
                </form>
            </div>

            <div class="log-in"> <%-- login div --%>
                <form id="form-login" method="post">
                    <label>Enter Username : <input type="text" name="log-username" required></label>
                    <br/>
                    <label>Enter Password : <input type="password" name="log-password" required></label>
                    <br/>
                    <input type="submit" value="Log In">
                </form>
            </div>
        </div>

        <div class="log-out"> <%-- logout div --%>
            <form action = "log-out" method = "POST">
                <input type="submit" value="Log out">
            </form>
        </div>

        <div class="show"></div>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>