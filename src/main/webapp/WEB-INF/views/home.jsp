<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
 <%@ page isELIgnored="false" %>
 <%@ page import="com.controller.entity.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>">
<script type="text/javascript"  src="<c:url value="/resources/scripts/Script.js"/>" ></script>
</head>
<body>
<form id="accountForm" action="navigate" method="post">
<input type="hidden" id="selectedPage" name="selectedPage">
<header>
        <img src="" alt="Company Logo">
        <h1>MyDigiPurse</h1>
</header>


<% UserDTO user=(UserDTO)session.getAttribute("user");
   if(user==null) {
	   response.sendRedirect("login");
   }else{
   %>
 <div class="userDetails">

 <h2>Welcome, ${user.username}</h2>
   
<p>Full Name:${user.user_fullname}</p>
<p>Phone Number:${user.phone_no }</p>
<p>Email:${user.email }</p>
<p>Address:${user.user_address }</p>
</div>
    
<div class="accountsList">
 <a href="addaccount" class="AllBtn" style="float: right; margin-right: 20px;"  >Add Account</a>
    <!-- Display accounts in radio buttons here -->
   <h2>Accounts</h2>
 	
     <table class="Bank-table">
     <thead>
     <tr>
     <th>Select</th>
     <th>Account Number</th>
     <th>Bank Name</th>
     <th>IFSC code</th>
     <th>Account type</th>
     <th>Current Balance</th>
     
     </tr>
     </thead>
    
     <tbody>
      <c:forEach items="${banklist}" var="bank">
                <tr>
                	<td><input  type="radio" name="selectedAccount" value="${bank.accountID}"></td>
                    <td>${bank.bank_account_no}</td>
                    <td>${bank.bank_name}</td>
                    <td>${bank.IFSC_code}</td>
                    
                    <td>${bank.account_type}</td>
                    <td>${bank.current_balance}</td>
                </tr>
            </c:forEach>
        </tbody>
         </table>
   
 
</div>

  
<div class="transactions">
    <!-- Buttons for transaction requests -->
    <input type="hidden" id="selectedAction" name="selectedAction">
    <button  type="button" style="width:25%" class="AllBtn" onclick="validateAndRedirect('Statement')"> Statement</button>
    
    <button  style="width:25%"class="AllBtn" onclick="validateAndRedirect('AddMoney')"> Add Money</button>
     
    <button type="button" style ="width:25%" class="AllBtn" onclick="validateAndRedirect('SendMoney')">Send Money</button>
     
    
</div>

 <% }%>
   
</form>
<div>

<a href="http://localhost:8082/MyDigiPurse/logout" style="width:10%" class="logout">Logout</a>
</div>

</body>
</html>


