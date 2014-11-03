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
<link href="<c:url value="resources/css/bootstrap.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="resources/css/main.css"/>" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="resources/css/plugins/metisMenu/metisMenu.min.css"/>"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="resources/css/plugins/timeline.css"/>" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<c:url value="resources/css/plugins/dataTables.bootstrap.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="resources/css/sb-admin-2.css"/>" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="resources/css/plugins/morris.css"/>" rel="stylesheet">

<link href="<c:url value="resources/css/all_check.css"/>" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<c:url value="resources/js/hover.zoom.js"/>"></script>
<script src="<c:url value="resources/js/hover.zoom.conf.js"/>"></script>

<!-- Multi-select -->
<link rel="stylesheet"
	href="<c:url value="resources/css/bootstrap-3.1.1.min.css"/>" type="text/css">
<link rel="stylesheet"
	href="<c:url value="resources/css/bootstrap-multiselect.css"/>" type="text/css">
<link rel="stylesheet" href="<c:url value="resources/css/prettify.css"/>"
	type="text/css">

<script type="text/javascript"
	src="<c:url value="resources/js/jquery-2.1.0.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="resources/js/bootstrap-3.1.1.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="resources/js/bootstrap-multiselect.js"/>"></script>
<script type="text/javascript" src="<c:url value="resources/js/prettify.js"/>"></script>

<style type="text/css">
table pre.prettyprint {
	overflow-y: auto;
	max-width: 500px;
	max-height: 250px;
}
</style>
</head>

<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End Header -->
	<!-- +++++ Welcome Body Section +++++ -->
	<div id="page-wrapper">
		<!-- Multi-select javascript-->
		<script type="text/javascript">
			$(document).ready(function() {
				window.prettyPrint() && prettyPrint();

				$('#accountType').multiselect();
				$('#state').multiselect();

			});
		</script>
		<!-- End Multi-select -->
		<!-- Breadcrumb -->
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">Search</li>
			</ol>
		</div>
		<!-- End Breadcrumb -->
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
							<c:if test="${alert eq 'success'}">
								<div class="alert alert-success">
									<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>${message }!</strong>
								</div>
							</c:if>
							<c:if test="${alert eq 'error'}">
								<div class="alert alert-danger">
									<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>${message }!</strong>
								</div>
							</c:if>
						</c:if>
						<form role="form" action="search.html" method="post"
							style="margin-top: 1%">
							<div class="col-xs-6 col-md-4">
								<div class="form-group">
									<input type="text" class="form-control" name="idCardNumber"
										placeholder="ID Card Number" title="Numbers only"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="fullname"
										placeholder="Full Name"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="accountNumber"
										placeholder="Account Number" title="Numbers only"><br>
								</div>
							</div>
							<div class="col-xs-6 col-md-4">

								<div class="form-group">
									<input type="text" class="form-control" name="address"
										placeholder="Address"> <br>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="phone"
										placeholder="Phone" title="Numbers only"> <br>
								</div>
							</div>
							<div class="col-xs-6 col-md-4">
								<div style="margin-bottom: 20px;">
									<label style="width: 30%">Account Type</label> <select
										id="accountType" multiple="multiple" class="form-control"
										name="accountType">

										<option value="1">Deposit</option>
										<option value="2">Saving</option>
										<option value="3">Others</option>
									</select>
								</div>
								<div style="margin-bottom: 20px;">
									<label style="width: 30%">Account State</label> <select
										id="state" multiple="multiple" class="form-control"
										name="state">

										<option value="1">New</option>
										<option value="2">Active</option>
										<option value="3">Disable</option>
										<option value="4">Removable</option>
									</select><br>
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
	<!-- End Body Section-->

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="resources/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

	<!-- Numeric JavaScript -->
	<script src="<c:url value="resources/js/jquery.numeric.js"/>"></script>
	
	<!-- DataTables JavaScript -->
	<script
		src="<c:url value="resources/js/plugins/dataTables/jquery.dataTables.js"/>"></script>
	<script
		src="<c:url value="resources/js/plugins/dataTables/dataTables.bootstrap.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="resources/js/sb-admin-2.js"/>"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script type="text/javascript">
		$(document).ready(function() {
			window.prettyPrint() && prettyPrint();

			$('#example54').multiselect();

		});
	</script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	<script>
		// View detail pop up
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})
	</script>
	<script type="text/javascript">
		$ = jQuery;
		$(document).ready(function() {
			$("input[name=idCardNumber]").numeric();
			$("input[name=accountNumber]").numeric();
			$("input[name=phone]").numeric();
		});
	</script>
	<!-- Multi Select -->
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