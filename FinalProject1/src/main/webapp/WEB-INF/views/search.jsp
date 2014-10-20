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
	<!-- 
	<div id="ww" style="height: 700px">
		<div class="container" style="padding-top: 5%"> -->
	<div id="page-wrapper">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="">Home</a></li>
				<li class="active">Search</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Search
					<c:if test="${role =='support'}"> 
					<a href="getAddAccount.html"> <button type="submit" class="btn btn-success centered" 
						 style="float:right">Add Account</button> </a> </c:if>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
			<div class="col-lg-12">

				<div class="panel panel-default">
					
					<div class="row mt">
						<div class="col-lg-4 col-lg-offset-4 centered">
						<c:if test="${!empty message}"> 
						<p class="alert alert-danger">${message }</p> 
						</c:if>
							<form role="form" action="search.html" method="post" style="margin-top: 5%">
								<div class="form-group">
									<input type="text" class="form-control" name="idCardNumber"
										placeholder="ID Card Number"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="fullname"
										placeholder="Full Name"> <br>
								</div>
								<div>
									<select class="form-control" style="padding-left:6px" name="accountType">
										<option value="0">All</option>
										<option value="1">Deposit account</option>
										<option value="2">Saving account</option>
										<option value="3">Others</option>
									</select><br>
								</div>
								<div>
									<select class="form-control" style="padding-left:6px" name="state">
										<!-- <option value="0">All</option> -->
										<option value="1">New</option>
										<option value="2">Active</option>
										<option value="3">Disable</option>
										<option value="4">Removable</option>
									</select><br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="accountNumber"
										placeholder="Account Number"><br>
								</div>

								<div class="form-group">
									<input type="text" class="form-control" name="address"
										placeholder="Address"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="phone"
										placeholder="Phone"> <br>
								</div>
								<button type="submit" class="btn btn-success centered">Search</button>
							</form>
						</div>
					</div>
					<!-- /row -->
				</div>

			</div>
			<!-- /col-lg-8 -->
		</div>
		<!-- /row -->
		<!-- </div> -->
		<!-- /container -->
	</div>
	<!-- /container -->





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