<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"  src="<c:url value="/resources/scripts/Script.js"/>" ></script>
</head>
<body>
<header>
        <img src="" alt="Company Logo">
        <h1>MyDigiPurse</h1>
    </header>

    <div class="container">
        <div class="form-box">
             <h2>${success}</h2>
            <h2>Login</h2>
            <form action="login" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>

                <button type="submit">Login</button> </form>
                <form action="registration">
                <h3>New user?</h3>
             <button type="submit" >Register</button>
             </form>
        </div>
    </div>
    
</body>
</html>