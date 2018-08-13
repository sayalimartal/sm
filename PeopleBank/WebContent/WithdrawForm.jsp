<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdrawal</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div align ="center">
<form id="withdraw" action="withdrawAmount.app">
Enter account number: <input type = "number" name="accountNumber" min=101>
Enter amount to be withdrawn:<input type="number" name="amount" min="0">
<input type="submit" value="Withdraw">
</form>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>