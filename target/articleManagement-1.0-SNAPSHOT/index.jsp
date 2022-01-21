<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<br/>
<button class="sign">Sign Up</button>
<div class="signUp">
    <form action="">
        <label>Enter Username : </label><input type="text" name="username">
        <label>Enter Password : </label><input type="text" name="password1">
        <label>Re-Enter Password : </label><input type="text" name="password2">
    </form>
</div>
<a href="hello-servlet">Hello Servlet</a>
<script src="js/signUpReq.js"></script>
</body>
</html>