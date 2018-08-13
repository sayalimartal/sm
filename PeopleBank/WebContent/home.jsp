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
	<a href="addNewAccount.app">Add New Account</a><br>
	<a href="viewAllCustomers.app">View All Accounts</a><br>
	<a href="search.app">Search Account</a><br>
	<a href="withdraw.app">Withdraw Amount</a><br>
	<a href="deposit.app">Deposit Amount</a><br>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>