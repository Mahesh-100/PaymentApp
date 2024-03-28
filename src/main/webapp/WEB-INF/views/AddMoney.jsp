<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.controller.entity.UserDTO" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
   

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Money</title>
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
<h2>Add Money</h2>

 
   <h3>Welcome ${user.user_fullname}
</h3>
<form  id="addMoneyForm" action="addmoney" method="post">
     
	
	<input type="hidden" name="accountID" value="${accountID}">
    <label for="amount">Amount to Add:</label>
    <input type="number" id="amount" name="amount" required>

    <button type="submit" >Add Money</button>
</form>

</div>
 </div>
 <% }%>
 <div>
<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a></div>
</body>
</html>