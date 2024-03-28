<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
 <%@ page import="com.controller.entity.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account Form</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"  src="<c:url value="/resources/scripts/Script.js"/>" ></script>

</head>
<body>
<header>
        <img src="company-logo.png" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>

<%   UserDTO user=(UserDTO)session.getAttribute("user");
if(user==null) {
	   response.sendRedirect("login");
}else{%>
<div class="container">
<div class="form-box">
<h2>Bank Account Form</h2>
<form id="bankDetailsForm" action="addaccount" method="post">
	
    <h2>${error}</h2>
 
   <h3>Welcome,${user.username}</h3>
   
     <input type="hidden" name="user_id" value= ${user.user_id }>
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" required>

    <label for="bankName">Bank Name:</label>
    <input type="text" id="bankName" name="bankName" required>

    <label for="ifscCode">IFSC Code:</label>
    <input type="text" id="ifscCode" name="ifscCode" required>

    <label for="accountType">Account Type:</label>
    <select id="accountType" name="accountType" required>
     <option value="savings"></option>
        <option value="savings">Savings</option>
        <option value="current">Current</option>
        <!-- Add more options if needed -->
    </select>

    <label for="initialBalance">Initial Balance:</label>
    <input type="number" id="initialBalance" name="initialBalance" required>

    <button type="submit">Submit</button>
</form>

</div>
</div>
<% }%>
<div>
<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a>
</div>
</body>
</html>