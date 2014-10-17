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
		<form action="AdminSetListActive" method="post">		
		<c:forEach var="account" items="${accounts}">
			<tr>
				<td><input type="checkbox" name="CheckBoxList" value="${account.idaccount}" /></td>
				<td>
					${account.accountNumber}
					<%-- <input type="text" name="accountNumber" value="${account.accountNumber}" style="display: none;"> --%>
				</td>
				<td>
					${account.firstName}${account.lastName}${account.midName}
					<%-- <input type="text" name="accountNumber" value="${account.accountNumber}" style="display: none;"> --%>
				</td>
				<td>${account.idCardNumber}</td>
				<td>${account.accountstate.stateName}</td>
				<td>${account.accounttype.typeName}</td>
				<td><a href="AdminSetActive?idaccount=${account.idaccount}">Set Active</a></td>
			</tr>
			<c:set var="i" value="${i+1 }" />
		</c:forEach>
		<tr><td colspan="6"><input type="submit" value="Set state"></td></tr>
		</form>				
	</table>
	
</body>
</html>