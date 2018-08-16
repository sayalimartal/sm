<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People's Bank</title>
<style>body {
	background-color: #D8F1F2;
}</style>
</head>

<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div>
	<!-- <a href="addNewAccount">Add New Account</a><br>
	<a href="viewAllCustomers">View All Accounts</a><br>
	<a href="search">Search Account</a><br> -->
	<a href="withdraw">Withdraw Amount</a><br>
	<a href="deposit">Deposit Amount</a><br>
	<a href="fundtransfer">Fund Transfer</a><br>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>