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
    <form>
        <label>Enter Username : </label><input type="text" name="username" required>
        <br/>
        <label>Enter Password : </label><input type="text" name="password1" required>
        <br/>
        <label>Re-Enter Password : </label><input type="text" name="password2" required>
        <br/>
        <input type="submit" name="Sign Up">
    </form>
</div>
<a href="hello-servlet">Hello Servlet</a>
<script src="js/signUpReq.js"></script>
</body>
</html>