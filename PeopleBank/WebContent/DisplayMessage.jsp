<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div align="center">
${requestScope.result}
</div>
<a href="accountDetail.app">Click here to view account details</a>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>