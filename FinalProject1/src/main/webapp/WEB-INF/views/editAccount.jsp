<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Acccount</title>

<!-- Loading Bootstrap -->
<link href="<c:url value="/css/vendor/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<c:url value="/css/flat-ui.css"/>" rel="stylesheet">

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

	<!-- +++++ Container +++++ -->
	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Edit Account</h1>
				</div>
			</div>
			<form class="form-horizontal" role="form"
				action="<c:url value="/doUpdateAccountInfo" /> " method="post">
				<div class="row">
					<input type="text" style="display: none;" name="idAccount"
						value="${ accountInfo.idaccount}">
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Account
								Type:</label>
							<div class="col-md-8">
								<select id="selectAccountType" name="accountType"
									class="form-control">
									<c:if test="${accountInfo.accounttype.idtype eq 1 }">
										<option selected="selected" value="Deposit account">Deposit
											Account</option>
										<option value="Saving account">Saving Account</option>
										<option value="Others">Others</option>
									</c:if>
									<c:if test="${accountInfo.accounttype.idtype eq 2 }">
										<option value="Deposit account">Deposit Account</option>
										<option selected="selected" value="Saving account">Saving
											Account</option>
										<option value="Others">Others</option>
									</c:if>
									<c:if test="${accountInfo.accounttype.idtype eq 3 }">
										<option value="Deposit account">Deposit Account</option>
										<option value="Saving account">Saving Account</option>
										<option selected="selected" value="Others">Others</option>
									</c:if>
								</select>

							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">ID
								Card:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" 
									id="formGroupInputSmall" name="idCardNumber"
									placeholder="ID Card Number" required
									value="${accountInfo.idCardNumber}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">First
								Name:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" id="formGroupInputSmall"
									name="firstName" placeholder="First Name" required
									value="${accountInfo.firstName}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Mid
								Name:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" id="formGroupInputSmall"
									name="midName" placeholder="Mid Name"
									value="${accountInfo.midName}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Last
								Name:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" id="formGroupInputSmall"
									name="lastName" placeholder="last Name" required
									value="${accountInfo.lastName}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Phone
								1:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" 
									id="formGroupInputSmall" name="phoneNumber1"
									placeholder="Phone Number 1" required
									value="${accountInfo.phoneNumber1}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Phone
								2:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" min="0"
									id="formGroupInputSmall" name="phoneNumber2"
									placeholder="Phone Number 2"
									value="${accountInfo.phoneNumber2}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Address
								1:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" id="formGroupInputSmall"
									name="address1" placeholder="Address 1" required
									value="${accountInfo.address1}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Address
								2:</label>
							<div class="col-md-8">
								<input class="form-control" type="text" id="formGroupInputSmall"
									name="address2" placeholder="Address 2"
									value="${accountInfo.address2}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Email
								1:</label>
							<div class="col-md-8">
								<input class="form-control" type="email"
									id="formGroupInputSmall" name="email1" placeholder="Email 1"
									required value="${accountInfo.email1}">
							</div>
						</div>
					</div>
					<div class="col-md-4 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Email
								2:</label>
							<div class="col-md-8">
								<input class="form-control" type="email"
									id="formGroupInputSmall" name="email2" placeholder="Email 2"
									value="${accountInfo.email2}">
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<button style="margin-left: 50%" type="submit"
								class="btn btn-primary btn-sm">Submit</button>
							<a href="view.html"><button type="button"
									class="btn btn-default btn-sm">Cancel</button></a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

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

	<!-- JS for Select -->
	<script src="/js/application.js"></script>
</body>
</html>