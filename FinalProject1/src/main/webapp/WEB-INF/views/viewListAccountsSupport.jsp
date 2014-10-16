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
				<li><a href="home.jsp">Home</a></li>
				<li class="active">Account Management</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Account Management  and ${username }</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
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
										<th>Account Type</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="i" value="${0 }" />
									<c:forEach var="account" items="${accounts}">
										<tr>
											<td><input style="display:none" name="idaccount" value="${account.idaccount}"/>
												<div class="checkbox">
													<label> <input type="checkbox" value="" /></label>
												</div>
											</td>
											<td>${account.accountNumber}</td>
											<td>${account.firstName} ${account.lastName} ${account.midName}</td>	
											<td>${account.idCardNumber}</td>
											<td>${account.accountstate.stateName}</td>	
											<td>${account.accounttype.typeName}</td>	
											<td class="tooltip-demo">
												<a href="#" data-toggle="tooltip" data-placement="right" title="View detail"> 
													<span class="glyphicon glyphicon-list-alt" data-toggle="modal" data-target="#myModal${i }"></span>
												</a> 
												<a href="editAcc.html?accountId=id" data-toggle="tooltip" data-placement="right" title="Edit Account"> 
													<span class="glyphicon glyphicon-edit"></span>
												</a> 
												<c:if test="${(account.accountstate.stateName =='Removable')}"> 
													<a href="#" data-toggle="tooltip" data-placement="right" title="Remove"> 
														<span class="glyphicon glyphicon-trash"></span>
													</a>
												</c:if>
												<c:if test="${(account.accountstate.stateName =='Active')}"> 
													<a href="#" data-toggle="tooltip" data-placement="right" title="Disable"> 
														<span class="glyphicon glyphicon-ok"></span>
													</a>
												</c:if>
											</td>												
										</tr>
										<c:set var="i" value="${i+1 }" />
									</c:forEach>
									

								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->

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
	<c:set var="i" value="${0 }" />
	<c:forEach var="account" items="${accounts}">
	<div class="modal fade" id="myModal${i}" tabindex="-1" role="dialog"
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
						<dd>${account.firstName} ${account.lastName} ${account.midName}</dd>
						<dt>Account Number</dt>
						<dd>${account.accountNumber}</dd>
						<dt>ID Card Number</dt>
						<dd>${account.idCardNumber}</dd>
						<dt>Phone Number</dt>
						<dd>${account.phoneNumber1}</dd><dd>${account.phoneNumber2}</dd>
						<dt>Address</dt>
						<dd>${account.address1}</dd><dd>${account.address2}</dd>
						<dt>Email</dt>
						<dd>${account.email1}</dd><dd>${account.email2}</dd>
						<dt>Account State</dt>
						<dd>${account.accountstate.stateName}</dd>
						<dt>Account Type</dt>
						<dd>${account.accounttype.typeName}</dd>
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
	<c:set var="i" value="${i+1 }" />
	</c:forEach>
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