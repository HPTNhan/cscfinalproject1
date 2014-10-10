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

	<div id="page-wrapper">
		<div class="row">
			<ol class="breadcrumb">
				<li>
					<a href="home.jsp">Home</a>
				</li>
				<li class="active">
					Account Management
				</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Account Management</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="form-group" style="width: 30%">
							<label>Select States</label> <select class="form-control">
								<option>All</option>
								<option>New</option>
								<option>Active</option>
								<option>Disable</option>
								<option>Removable</option>
							</select>
						</div>
						<div style="float: right; margin-top: -3%">
							<button type="submit" class="btn btn-success centered">New</button>
							<button type="submit" class="btn btn-success centered"
								data-toggle="modal" data-target="#myFilter">Filter</button>
						</div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></th>
										<th>Account Number</th>
										<th>Full Name</th>
										<th>ID Card Number</th>
										<th>State</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<tr class="odd gradeX">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td class="tooltip-demo"><a href="#"
											data-toggle="tooltip" data-placement="left"
											title="View detail"> <span
												class="glyphicon glyphicon-list-alt" data-toggle="modal"
												data-target="#myModal"></span>
										</a> <a href="#" data-toggle="tooltip" data-placement="right"
											title="Edit Account"> <span
												class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="even gradeC">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td class="tooltip-demo"><a href="#"
											data-toggle="tooltip" data-placement="left"
											title="View detail"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#" data-toggle="tooltip" data-placement="right"
											title="Edit Account"> <span
												class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="odd gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="even gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>

									<tr class="gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>OmniWeb</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>
									<tr class="gradeA">
										<td><div class="checkbox">
												<label> <input type="checkbox" value="" />
												</label>
											</div></td>
										<td>10051234</td>
										<td>Jack Jones</td>
										<td>3205426</td>
										<td>New</td>
										<td><a href="#"> <span
												class="glyphicon glyphicon-list-alt"></span>
										</a> <a href="#"> <span class="glyphicon glyphicon-edit"></span>
										</a></td>
									</tr>

								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
						<div style="float: right; margin-top:5px">
							<button type="submit" class="btn btn-success centered">Approve</button>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Account Information</h4>
				</div>
				<div class="modal-body">
					<dl class="dl-horizontal">
						<dt>Full Name</dt>
						<dd>Jack Jones</dd>
						<dt>Account Number</dt>
						<dd>10051234</dd>
						<dt>ID Card Number</dt>
						<dd>3205426</dd>
						<dt>Phone Number</dt>
						<dd>01654896805</dd>
						<dt>Address</dt>
						<dd>NTT, District 7</dd>
						<dt>Email</dt>
						<dd>leechimi@gmail.com</dd>
						<dd>lchimi@gmail.com</dd>
					</dl>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success centered"
						data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- Filter -->
	<div class="modal fade" id="myFilter" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Account Information</h4>
				</div>
				<div class="modal-body">
					<dl class="dl-horizontal">
						<dt>ID Card number</dt>
						<dd>
							<div class="form-group">
								<input type="text" class="form-control" id="idCardNumber"
									placeholder="ID Card Number"> <br>
							</div>
						</dd>
						<dt>Full Name</dt>
						<dd>
							<div class="form-group">
								<input type="text" class="form-control" id="fullName"
									placeholder="Full Name"> <br>
							</div>
						</dd>
						<dt>Account type</dt>
						<dd>
							<select class="form-control">
								<option>Deposit account</option>
								<option>Saving account</option>
								<option>Others</option>
							</select>
						</dd>
						<dt>Account Number</dt>
						<dd>
							<div class="form-group">
								<input type="text" class="form-control" id="accNumber"
									placeholder="Account Number"> <br>
							</div>
						</dd>
						<dt>Address</dt>
						<dd>
							<div class="form-group">
								<input type="text" class="form-control" id="address"
									placeholder="Address"> <br>
							</div>
						</dd>
						<dt>Phone</dt>
						<dd>
							<div class="form-group">
								<input type="text" class="form-control" id="phone"
									placeholder="Phone"> <br>
							</div>
						</dd>
					</dl>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success centered"
						data-dismiss="modal">Filter</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
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

</body>

</html>