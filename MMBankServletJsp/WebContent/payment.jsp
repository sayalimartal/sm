<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="transfer.app">
Enter sender account :<input type="number" min="101" name="sender"><br>
Enter receiver account no:<input type="number" min="101" name="reciever"><br>
Enter amount:<input type="number"  name="amount" min="1"><br>
<input type="submit" value="Transfer">
</form>
</div>
</body>
</html>