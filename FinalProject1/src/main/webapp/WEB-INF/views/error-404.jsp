<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>404</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="resources/css/bootstrap.css"/>" rel="stylesheet">

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
	<%@ page isErrorPage="true"%>
	<!-- 	<button onclick="history.back()">Back to Previous Page</button> -->
	<!-- 	<h1>404 Page Not Found.</h1> -->
	<!-- 	<br /> -->
	<!-- 	<p> -->
	<%-- 		<b>Error code:</b> ${pageContext.errorData.statusCode} --%>
	<!-- 	</p> -->
	<!-- 	<p> -->
	<!-- 		<b>Request URI:</b> -->
	<%-- 		${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI} --%>
	<!-- 	</p> -->
	<!-- 	<br /> -->

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template">
					<h1>Oops!</h1>
					<h2>404 Page Not Found</h2>
					<div class="error-details">Sorry, an error has occured,
						Requested page not found!</div>
					<div class="error-actions">
						<button class="btn btn-success centered" onclick="history.back()">Back
							to Previous Page</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<img src="http://cdn.css-tricks.com/images/404.jpg"
		alt="Page Not Found (404)."
		style="position: absolute; left: 50%; top: 50%; margin-left: -285px; margin-top: -190px;">
</body>
</html>