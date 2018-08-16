<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Form</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div align="center">
<form action="transfer">
Sender account number: <input type="number" min="101" name="sender"><br>
Receiver account number: <input type="number" min="101" name="receiver"><br>
Amount to be transferred: <input type="number"  name="amount" min="1"><br>
<input type="submit" value="Fund Transfer">
</form>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>