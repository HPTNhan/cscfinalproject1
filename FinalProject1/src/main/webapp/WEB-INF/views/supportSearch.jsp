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

<!-- DataTables CSS -->
<link href="<c:url value="/css/plugins/dataTables.bootstrap.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/css/sb-admin-2.css"/>" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="/css/plugins/morris.css"/>" rel="stylesheet">

<link href="<c:url value="/css/all_check.css"/>" rel="stylesheet">


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
						<a href="getAddAccount.html">
							<button type="submit" class="btn btn-success centered"
								style="float: right">Add Account</button>
						</a>
					</c:if>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
			<div class="col-lg-12">

				<div class="panel panel-default">

					<div class="row mt">
							<c:if test="${!empty message}">
								<p class="alert alert-danger">${message }</p>
							</c:if>
							<form role="form" action="search.html" method="post"
								style="margin-top: 1%">
								<div class="col-xs-6 col-md-4">
								<div class="form-group">
									<input type="text" class="form-control" name="idCardNumber"
										placeholder="ID Card Number"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="fullname"
										placeholder="Full Name"> <br>
								</div>
								<div>
									<select class="form-control" style="padding-left: 6px"
										name="accountType">
										<option value="0">All</option>
										<option value="1">Deposit account</option>
										<option value="2">Saving account</option>
										<option value="3">Others</option>
									</select><br>
								</div>
								</div>
								<div class="col-xs-6 col-md-4">
								<div>
									<select class="form-control" style="padding-left: 6px"
										name="state">
										<option value="0">All</option>
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
								</div>
								<div class="col-xs-6 col-md-4">

								<div class="form-group">
									<input type="text" class="form-control" name="address"
										placeholder="Address"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="phone"
										placeholder="Phone"> <br>
								</div>
								<button type="submit" class="btn btn-success centered">Search</button>
								</div>
							</form>
					<jsp:include page="viewListAccountsSupport.jsp"></jsp:include>
					</div>
					<!-- /row -->
				</div>

			</div>
			<!-- /col-lg-8 -->
			
		</div>
	</div>
	<!-- /container -->


	<!-- jQuery Version 1.11.0 -->
	<script src="<c:url value="/js/jquery-1.11.0.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<c:url value="/js/plugins/dataTables/jquery.dataTables.js"/>"></script>
	<script
		src="<c:url value="/js/plugins/dataTables/dataTables.bootstrap.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/js/sb-admin-2.js"/>"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})
	</script>

	<script>
		$(document).ready(function() {
			// Below code is used to remove all check property if,
			// User select/unselect options with class first options.
			$(".first").click(function() {
				$("#checkAll").attr("data-type", "uncheck");
			});
			// Below code is used to remove all check property if,
			// User select/unselect options with name=option2 options.
			$("input[name=idaccount]").click(function() {
				$("#selectall").prop("checked", false);
			});
			/////////////////////////////////////////////////////////////
			// JS for Check/Uncheck all CheckBoxes by Button //
			/////////////////////////////////////////////////////////////
			$("#checkAll").attr("data-type", "check");
			$("#checkAll").click(function() {
				if ($("#checkAll").attr("data-type") === "check") {
					$(".first").prop("checked", true);
					$("#checkAll").attr("data-type", "uncheck");
				} else {
					$(".first").prop("checked", false);
					$("#checkAll").attr("data-type", "check");
				}
			})
			/////////////////////////////////////////////////////////////
			// JS for Check/Uncheck all CheckBoxes by Checkbox //
			/////////////////////////////////////////////////////////////
			$("#selectall").click(function() {
				$(".second").prop("checked", $("#selectall").prop("checked"))
			})
		});
	</script>

</body>

</html>