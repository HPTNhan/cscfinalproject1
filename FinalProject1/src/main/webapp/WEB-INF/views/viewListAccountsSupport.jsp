<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<body>
	<form action="deleteListAccount" method="post">
	<div class="col-lg-12">
		<h1 class="page-header"></h1>
		<div class="col-md-6 col-md-offset-6" style="padding: 0px;">
		<c:if test="${(flat =='4')}">
			<button type="submit" class="btn btn-success centered"
				action="delete" style="float: right; margin-left: 1%">Delete</button>
		</c:if>
		</div>
	</div>
	<div class="col-lg-12">
		<div class="panel-body"
			style="border-style: solid; border-width: 1px; margin-top: 1%; border-color: #eee">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th width="35px"><input class="second" id="selectall" name="check"
								type="checkbox" /></th>
							<th>Account Number</th>
							<th width="200px">Full Name</th>
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
								<td><input class="second" id="selectall" name="idaccount"
									type="checkbox" value="${account.idaccount}" /></td>
								<td>${account.accountNumber}</td>
								<td>${account.firstName}${account.lastName}
									${account.midName}</td>
								<td>${account.idCardNumber}</td>
								<td>${account.accountstate.stateName}</td>
								<td>${account.accounttype.typeName}</td>
								<td class="tooltip-demo"><a href="#" data-toggle="tooltip"
									data-placement="right" title="View detail"> <span
										class="glyphicon glyphicon-list-alt" data-toggle="modal"
										data-target="#myModal${i }"></span>
								</a> <a href="getAccountInfo?accountId=${account.idaccount}"
									data-toggle="tooltip" data-placement="right"
									title="Edit Account"> <span
										class="glyphicon glyphicon-edit"></span>
								</a> <c:if test="${(account.accountstate.stateName =='Removable')}">
										<a href="#" data-toggle="tooltip" data-placement="right"
											title="Remove"> <span class="glyphicon glyphicon-trash"></span>
										</a>
									</c:if></td>
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
	</form>
	<!-- /.panel -->
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
							<dd>${account.firstName}${account.lastName}
								${account.midName}</dd>
							<dt>Account Number</dt>
							<dd>${account.accountNumber}</dd>
							<dt>ID Card Number</dt>
							<dd>${account.idCardNumber}</dd>
							<dt>Phone Number</dt>
							<dd>${account.phoneNumber1}</dd>
							<dd>${account.phoneNumber2}</dd>
							<dt>Address</dt>
							<dd>${account.address1}</dd>
							<dd>${account.address2}</dd>
							<dt>Email</dt>
							<dd>${account.email1}</dd>
							<dd>${account.email2}</dd>
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

</body>

</html>