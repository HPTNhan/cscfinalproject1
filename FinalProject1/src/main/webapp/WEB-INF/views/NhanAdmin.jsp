<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" class="allstates" value="" /></th>
				<th>Account Number</th>
				<th>Full Name</th>
				<th>ID Card Number</th>
				<th>State</th>
				<th>Account Type</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="i" value="${0}" />
		<c:forEach var="account" items="${accounts}">
			<tr>
				<td><input type="checkbox" value="" /></td>
				<td>${account.accountNumber}</td>
				<td>${account.firstName}${account.lastName}${account.midName}</td>
				<td>${account.idCardNumber}</td>
				<td>${account.accountstate.stateName}</td>
				<td>${account.accounttype.typeName}</td>
				<td><a href="search">Set Active</a></td>
			</tr>
			<c:set var="i" value="${i+1 }" />
		</c:forEach>
	</table>
</body>
</html>