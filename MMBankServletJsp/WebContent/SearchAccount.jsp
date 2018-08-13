<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Account</title>
</head>
<style>body {
	background-color: #7fffda;
}</style>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div id="check" align="center">
		<form id="search" action="searchAcc.app">
		<table>
		<tr><td>Enter Account Number:<input type ="number" id="accountNo" name="accountNo"></td></tr>
		<tr><td><input type="submit" value="Search"></td></tr>
		</table>
		</form>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>