<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
 <%@ page import="com.controller.entity.UserDTO" %>
 <%@ page import="java.util.ArrayList" %>
    
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
<div class="container">


<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login.jsp");
   }else{%>


<h2>Account Statement</h2>

 
   <h3>Welcome ${user.user_fullname}</h3>

<table class="Bank-table">
    <thead>
        <tr>
        	<th>TransactionId</th>
            <th>Transaction Date</th>
            <th>Transaction Type</th>
          	<th>Amount</th>
          	<th>SourceId</th>
          	<th>TargetId</th>
        </tr>
    </thead>
    <tbody>
       
      <c:forEach items="${transactions}" var="txn">
                <tr>
                	
                    <td>${txn.transactionID}</td>
                    <td>${txn.transactionDate}</td>
                    <td>${txn.transactionType}</td>
                    <td>${txn.amount}</td>
                    <td>${txn.sourceAcctID}</td>
                    <td>${bank.targetAcctID}</td>
                </tr>
            </c:forEach>
    
        
    </tbody>
</table>
</div>

 <% }%>
 <div>
<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a>
</div>
</body>
</html>