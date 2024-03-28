<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.controller.entity.UserDTO" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"  src="<c:url value="/resources/scripts/Script.js"/>" ></script>

</head>
<body>

<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>
<form action="transaction" method="post">

<div class="container">
<div class="form-box">

<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login");
   }else{%>


<h2>Account Statement</h2>

 
   <h3>Welcome ${user.user_fullname}</h3>




<label for="StartDate">Start Date:</label>
        <input type="date" id="StartDate" name="startDate" required>
        <span id="startDateError" class="error-message"></span><br>
<label for="EndDate">End Date:</label>
        <input type="date" id="EndDate" name="endDate" required>
        <span id="endDateError" class="error-message"></span><br>
        <input type="hidden" name="accountID" value="${accountID}">
         <button type="submit">Submit</button> 

</div>

</div>
 
 <% }%>
 <div>
<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a>
</div>
</form>
</body>
</html>