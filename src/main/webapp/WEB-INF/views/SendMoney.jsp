<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.entity.UserDTO" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Money</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"  src="<c:url value="/resources/scripts/Script.js"/>" ></script>

</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
    </header>

<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login");
   }else{%>
<div class="container">
<div class="form-box">
<h2>Send Money</h2>

 
   <h3>Welcome ${user.user_fullname}
</h3>
<form action="sendmoney" method="post">
	
	<input type="hidden" name="accountID" value="${accountID}">
   

    <label for="recipientAccount">Recipient's Account Number:</label>
    <input type="text" id="recipientAccount" name="recipientAccount" required>

    <label for="amount">Amount to Send:</label>
    <input type="number" id="amount" name="amount" required>

    <button type="submit">Send Money</button>   
</form>
</div>
 </div>
 <% }%>
 <div>
<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a></div>
</body>
</html>