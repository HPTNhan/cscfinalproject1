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

	<!-- Header -->
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<img src="<c:url value="img/csc_logo.png"/>"
					alt="CSC" style="height: 50px" />

			</div>
			<div class="navbar-header" STYLE="MARGIN-LEFT: 20px">
				<a class="navbar-brand" href="index.html">FINAL PROJECT</a>
			</div>
			<c:if test="${!empty role }"> 
			<div class="navbar-collapse collapse">
				
				<ul class="nav navbar-top-links navbar-right">

					<!-- /.dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"
							style="color: #2a6496"></i> <i class="fa fa-caret-down"
							style="color: #2a6496"></i>
					</a>
						<ul class="dropdown-menu dropdown-alerts" style="width: 254px;">
							<li><a href="searchState?state=1">
									<div>
										<i class="fa fa-user fa-fw"></i> New Account <span
											class="pull-right text-muted small">${newAccount }</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="searchState?state=2">
									<div>
										<i class="fa fa-user fa-fw"></i> Active Account <span
											class="pull-right text-muted small">${activeAccount }</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="searchState?state=3">
									<div>
										<i class="fa fa-user fa-fw"></i> Disable Account <span
											class="pull-right text-muted small">${disableAccount }</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="searchState?state=4">
									<div>
										<i class="fa fa-user fa-fw"></i> Removable Account <span
											class="pull-right text-muted small">${removableAccount }</span>
									</div>
							</a></li>
						</ul> <!-- /. end dropdown-alerts -->
						</li>
					<!-- /.end dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"
							style="color: #2a6496"></i> <i class="fa fa-caret-down"
							style="color: #2a6496"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#"><i class="fa fa-user fa-fw"></i> ${username }</a></li>
							<li><a href="#"><i class="fa fa-gear fa-fw"></i>
									Settings</a></li>
							<li class="divider"></li>
							<li><a href="logout.html"><i class="fa fa-sign-out fa-fw"></i>
									Logout</a></li>
						</ul> <!-- /.dropdown-user --></li>
					<!-- /.dropdown -->
				</ul>
				<!-- /.navbar-top-links -->
			</div>
			<!--/.nav-collapse -->
			
				</c:if>
		</div>
	</div>
</body>
</html>