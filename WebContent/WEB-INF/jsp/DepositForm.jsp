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
<form id="deposit" action="depositAmount">
Enter account Number: <input type = "number" name="accountNumber" required="required" >
Enter amount to deposit:<input type="number" name="amount" required="required">
<input type="submit" value="Deposit">
</form>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>