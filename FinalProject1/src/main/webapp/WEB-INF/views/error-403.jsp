<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>403</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet">

<style>
.error-template {
	padding: 40px 15px;
	text-align: center;
}

.error-actions {
	margin-top: 15px;
	margin-bottom: 15px;
}

.error-actions .btn {
	margin-right: 10px;
}
</style>
</head>
<body>	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template">
					<h1>Oops!</h1>
					<h2>403 Access is denied</h2>
					<c:choose>
						<c:when test="${empty username}">
							<div class="error-details">You do not have permission to access this page!</div>
						</c:when>
						<c:otherwise>
							<div class="error-details">
								Username : ${username} <br />You do not have permission to
								access this page!
							</div>
						</c:otherwise>
					</c:choose>					
					<div class="error-actions">
						<button class="btn btn-success centered" onclick="history.back()">Back
							to Previous Page</button>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>