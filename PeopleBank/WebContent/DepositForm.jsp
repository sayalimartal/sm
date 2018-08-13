<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div align ="center">
<form id="deposit" action="depositAmount.app">
Enter account Number: <input type = "number" name="accountNumber" min=101>
Enter amount to be withdrawn:<input type="number" name="amount" min="0">
<input type="submit" value="Deposit">
</form>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>