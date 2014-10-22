<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Create Acccount</title>

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
					<h1 class="page-header">Create Account</h1>
				</div>
			</div>
			<form:form cssClass="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/doAddAccount"
				method="post" modelAttribute="account">
				<div class="row">
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Type:</label>
							<div class="col-md-8">
								<form:select path="accounttype.idtype" cssClass="form-control">
									<form:option value="1">Deposit Account</form:option>
									<form:option value="2">Saving Account</form:option>
									<form:option value="3">Others</form:option>
								</form:select>
								<form:errors path="accounttype.idtype" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Number:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="accountNumber"
									type="text" placeholder="Acount Number"
									value="${accountNumber}" readonly="true" />
								<form:errors path="accountNumber" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">ID
								Card:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" type="number" path="idCardNumber"
									 placeholder="ID Card Number" required="true" />
								<form:errors path="idCardNumber" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">First
								Name:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="firstName"
									name="firstName" placeholder="First Name" />
								<form:errors path="firstName" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Mid
								Name:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="midName"
									name="midName" placeholder="Mid Name" />
								<form:errors path="midName" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Last
								Name:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="lastName" 
									name="lastName" placeholder="last Name" />
								<form:errors path="lastName" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Phone
								1:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="phoneNumber1"
									type="number" min="0" name="phoneNumber1"
									placeholder="Phone Number 1" />
								<form:errors path="phoneNumber1" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Phone
								2:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="phoneNumber2"
									 name="phoneNumber2"
									placeholder="Phone Number 2" />
								<form:errors path="phoneNumber2" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Address
								1:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="address1" 
									name="address1" placeholder="Address 1" />
								<form:errors path="address1" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Address
								2:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="address2" 
									name="address2" placeholder="Address 2" />
								<form:errors path="address2" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Email
								1:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="email1" 
									name="email1" type="email" placeholder="Email 1" />
								<form:errors path="email1" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Email
								2:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="email2" 
									name="email2" placeholder="Email 2" />
								<form:errors path="email2" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4"></div>
					<div class="col-sm-6 col-lg-4"></div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<button style="margin-left: 50%" type="submit"
								class="btn btn-primary btn-sm">Submit</button>
							<a href="view.html"><button type="button"
									class="btn btn-default btn-sm">Cancel</button></a>
						</div>
					</div>
				</div>
			</form:form>
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

	<!-- JS for Select -->
	<script src="/js/application.js"></script>
</body>
</html>