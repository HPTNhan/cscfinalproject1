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
<link href="<c:url value="/resources/css/vendor/bootstrap.min.css"/>" type="text/css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<c:url value="/resources/css/flat-ui.css"/>" type="text/css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/main.css"/>" type="text/css"  rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>"
	 type="text/css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="/resources/css/plugins/timeline.css"/>" rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet" type="text/css">

<!-- Morris Charts CSS -->
<link href="<c:url value="/resources/css/plugins/morris.css"/>" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<c:url value="/resources/js/hover.zoom.js"/>"></script>
<script src="<c:url value="/resources/js/hover.zoom.conf.js"/>"></script>



</head>

<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- +++++ Container +++++ -->
	<div id="ww">
		<div class="container">
			<!-- Breadcrumb -->
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="searchPage">Search</a></li>
					<li class="active">Create Account</li>
				</ol>
			</div>
			<!-- End Breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Create Account</h1>
				</div>
			</div>
			<form:form cssClass="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/support/doAddAccount"
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
								<c:if test="${!empty messageAS}">
									<p>${messageAS }</p>
								</c:if>
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
								<c:if test="${!empty messageAN}">
									<p>${messageAN }</p>
								</c:if>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">ID
								Card:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" type="text"
									pattern='[0-9]{9,10}'
									title="ID Card Number has 9 or 10 numbers" path="idCardNumber"
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
								<form:input cssClass="form-control" type="text" path="firstName"
									name="firstName" pattern="[A-Z a-z]{1,50}"
									title="Only letter(no numbers or special characters)"
									placeholder="First Name" required="true" />
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
									name="midName" pattern="[A-Z a-z]{1,50}"
									title="Only letter(no numbers or special characters)"
									placeholder="Mid Name" />
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
									name="lastName" pattern="[A-Z a-z]{1,50}"
									title="Only letter(no numbers or special characters)"
									placeholder="last Name" required="true" />
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
									type="tel" pattern='^(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$'
									title='Phone number( format: (457) 123-9054 )' name="phoneNumber1"
									placeholder="Phone Number 1" required="true" />
								<form:errors path="phoneNumber1" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Phone
								2:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" type="tel"
									pattern='^(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$'
									title='Phone number( format: (457) 123-9054 )' path="phoneNumber2"
									name="phoneNumber2" placeholder="Phone Number 2" />
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
									name="address1" placeholder="Address 1" required="true" />
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
								<form:input cssClass="form-control" path="email1" name="email1"
									type="email" placeholder="Email 1" required="true" />
								<form:errors path="email1" cssClass="error" />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-4">
						<div class="form-group form-group-sm">
							<label class="col-md-4 control-label" for="formGroupInputSmall">Email
								2:</label>
							<div class="col-md-8">
								<form:input cssClass="form-control" path="email2" name="email2"
									type="email" placeholder="Email 2" />
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
							<a href="${pageContext.request.contextPath}/searchPage"><button type="button"
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
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<!-- jQuery Version 1.11.0 -->
	<script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/resources/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

	<!-- Morris Charts JavaScript -->
	<script src="<c:url value="/resources/js/plugins/morris/raphael.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris-data.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/resources/js/sb-admin-2.js"/>"></script>

	<!-- JS for Select -->
	<script src="/resources/js/application.js"></script>
</body>
</html>