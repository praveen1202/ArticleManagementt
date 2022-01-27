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
<button class="sample">Hello</button>
<button class="sign">Sign Up</button>
<div class="signUp">
    <form class="form-signup" method="post">
        <label>Enter Username : <input id="username" type="text" name="username" required></label>
        <br/>
        <label>Enter Password : <input id="password1" type="text" name="password1" required></label>
        <br/>
        <label>Re-Enter Password : <input id="password2" type="text" name="password2" required></label>
        <br/>
        <input type="submit" name="Sign Up" id="sign-submit">
    </form>
</div>
<div class="show"></div>
<a href="hello-servlet">Hello Servlet</a>
<script src="js/signUpReq.js"></script>
</body>
</html>