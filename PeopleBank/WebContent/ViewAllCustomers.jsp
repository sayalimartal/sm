<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Customers</title>
</head>
<style>body {
	background-color: #D8F1F2;
}</style>
<body>
<div>
	<jsp:include page="header.jsp" />
</div>
<div align="center">
<h1>List of Account Holders</h1>
<jstl:if test="${requestScope.customers != null }">
<jstl:forEach items="${requestScope.customers}" var="customer">
    ${customer}<br>
</jstl:forEach>
</jstl:if>
<jstl:if test="${requestScope.customers == null }">
<h2>No customers found!</h2>
</jstl:if>
</div>
<div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>