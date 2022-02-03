<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<br/>
<button class="log">Log In</button>
<button class="sign">Sign Up</button>
<div class="sign-up">
    <form class="form-signup" method="post" enctype="application/x-www-form-urlencoded">
        <label>Enter Username : <input type="text" name="sign-username" required></label>
        <br/>
        <label>Enter Password : <input id="sign-password-1" type="text" name="sign-password-1" required></label>
        <br/>
        <label>Re-Enter Password : <input id="sign-password-2" type="text" name="sign-password-2" required></label>
        <br/>
        <input type="submit" value="Sign Up">
    </form>
</div>

<div class="log-in">
    <form class="form-login" method="get" enctype="application/x-www-form-urlencoded">
        <label>Enter Username : <input type="text" name="log-username" required></label>
        <br/>
        <label>Enter Password : <input type="password" name="log-password" required></label>
        <br/>
        <input type="submit" value="Log In">
    </form>
</div>

<div class="show"></div>
<a href="hello-servlet">Hello Servlet</a>
<script src="js/signUpReq.js"></script>
</body>
</html>