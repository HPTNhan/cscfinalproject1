<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function isChecked()
	{
		$(document).ready(function() {
			  var oTable = $('#dataTables-example').dataTable();
			   
			  // Get the nodes from the table
			  var nNodes = oTable.fnGetNodes();
			  alert(nNodes.length);
			} );
		
		var x = document.forms["submitAction"].idaccount;
		for (i = 0; i < x.length; i++) {
			if (x[i].checked) {
				return true;
			}
		}
		alert("Please select one !");
		return false;
	}
   

</script>
</head>

<body>
	<form action="setListAccountState" method="post" name="submitAction"
		onsubmit="return isChecked()">
		<div class="col-lg-12">
			<h1 class="page-header"></h1>
			<div class="col-md-6 col-md-offset-6" style="padding: 0px;">
				<c:if test="${(flat =='123')}">
					<button type="submit" class="btn btn-success centered"
						name="action" value="Removable" action="removable"
						style="float: right; margin-left: 1%">Set Removable</button>
					<button type="submit" class="btn btn-success centered"
						name="action" value="Disable" action="disable"
						style="float: right; margin-left: 1%">Set Disable</button>
					<button type="submit" class="btn btn-success centered"
						name="action" value="Active" action="active"
						style="float: right; margin-left: 1%">Set Active</button>

				</c:if>
				<c:if test="${(flat =='3')}">
					<button type="submit" class="btn btn-success centered"
						name="action" value="Removable" action="removable"
						style="float: right; margin-left: 1%">Set Removable</button>
					<button type="submit" class="btn btn-success centered"
						name="action" value="Active" action="active"
						style="float: right; margin-left: 1%">Set Active</button>
				</c:if>
				<c:if test="${(flat =='1')}">
					<button type="submit" class="btn btn-success centered"
						name="action" value="Active" action="active"
						style="float: right; margin-left: 1%">Set Active</button>
				</c:if>
				<c:if test="${(flat =='2')}">
					<button type="submit" class="btn btn-success centered"
						name="action" value="Disable" action="disable"
						style="float: right; margin-left: 1%">Set Disable</button>
				</c:if>
				<c:if test="${(flat =='12')}">
					<button type="submit" class="btn btn-success centered"
						name="action" value="Disable" action="removable"
						style="float: right; margin-left: 1%">Set Disable</button>
					<button type="submit" class="btn btn-success centered"
						name="action" value="Active" action="active"
						style="float: right; margin-left: 1%">Set Active</button>
				</c:if>


			</div>
		</div>
		<!-- /.col-lg-12 -->
		<div class="col-lg-12">
			<div class="panel-body"
				style="border-style: solid; border-width: 1px; margin-top: 1%; border-color: #eee">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th width="35px"><input class="second" id="selectall"
									name="check" type="checkbox" /></th>
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
									<td>${account.firstName} ${account.lastName}
										${account.midName}</td>
									<td>${account.idCardNumber}</td>
									<td>${account.accountstate.stateName}</td>
									<td>${account.accounttype.typeName}</td>
									<td class="tooltip-demo"><a href="#" data-toggle="tooltip"
										data-placement="right" title="View detail"> <span
											class="glyphicon glyphicon-list-alt" data-toggle="modal"
											data-target="#myModal${i }"></span>
									</a> <c:if test="${(account.accountstate.stateName =='New')}">
											<a
												href="setAccountStateActive?idaccount=${account.idaccount}"
												data-toggle="tooltip" data-placement="right" title="Active">
												<span class="glyphicon glyphicon-check"></span>
											</a>
										</c:if> <c:if test="${(account.accountstate.stateName =='Active')}">
											<a
												href="setAccountStateDisable?idaccount=${account.idaccount}"
												data-toggle="tooltip" data-placement="right" title="Disable">
												<span class="glyphicon glyphicon-ban-circle"></span>
											</a>
										</c:if> <c:if test="${(account.accountstate.stateName =='Disable')}">
											<a
												href="setAccountStateActiveFromDisable?idaccount=${account.idaccount}"
												data-toggle="tooltip" data-placement="right" title="Active">
												<span class="glyphicon glyphicon-check"></span>
											</a>
											<a
												href="setAccountStateRemovable?idaccount=${account.idaccount}"
												data-toggle="tooltip" data-placement="right"
												title="Removable"> <span
												class="glyphicon glyphicon-remove"></span>
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
		<!-- /.col-lg-12 -->
	</form>
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
							<dd>${account.firstName} ${account.lastName}
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