<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Project</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/css/main.css"/>" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<c:url value="/css/plugins/metisMenu/metisMenu.min.css"/>"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="/css/plugins/timeline.css"/>" rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/css/sb-admin-2.css"/>" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="/css/plugins/morris.css"/>" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<c:url value="/js/hover.zoom.js"/>"></script>
<script src="<c:url value="/js/hover.zoom.conf.js"/>"></script>


</head>

<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww" style="height: 700px">
		<div class="container" style="padding-top: 5%">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<img src="img/user.png" alt="Stanley">
					<div class="container pt">
						<div class="row mt">
							<div class="col-lg-6 col-lg-offset-3 centered">
								<h3>Login</h3>
								<hr>
								<c:if test="${message == 'loginfail'}">
									<p class="alert alert-danger"  data-dismiss="alert">Wrong ID or Password!</p>
								</c:if>
								<c:if test="${message == 'logout'}">
									<p class="alert alert-success" data-dismiss="alert">Successfully logged you out!</p>
								</c:if>
							</div>
						</div>
						<div class="row mt">
							<div class="col-lg-6 col-lg-offset-3" centered>

								<form:form action="checkLogin" method="post">
									<div class="form-group">
										<input type="text" class="form-control" name="username" title="Please enter your username.">
										<br>
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="password" title="Please enter your password.">
										<br>
									</div>
									<button type="submit" class="btn btn-success centered">Submit</button>
								</form:form>
							</div>
						</div>
						<!-- /row -->
					</div>

				</div>
				<!-- /col-lg-8 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /container -->


	<!-- +++++ Footer Section +++++ -->
	<jsp:include page="footer.jsp"></jsp:include>



	<!-- JavaScript
    ================================================== -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<!-- jQuery Version 1.11.0 -->
	<script src="<c:url value="/js/jquery-1.11.0.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="/js/plugins/morris/raphael.min.js"/>"></script>
	<script src="<c:url value="/js/plugins/morris/morris.min.js"/>"></script>
	<script src="<c:url value="/js/plugins/morris/morris-data.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/js/sb-admin-2.js"/>"></script>
</body>
</html>