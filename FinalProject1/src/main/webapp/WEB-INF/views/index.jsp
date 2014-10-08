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
				<img src="<c:url value="/resources/assets/img/csc_logo.png"/>"
					alt="CSC" style="height: 50px" />

			</div>
			<div class="navbar-header" STYLE="MARGIN-LEFT: 20px">
				<a class="navbar-brand" href="index.html">FINAL PROJECT</a>
			</div>
			<div class="navbar-collapse collapse">
				<!--<ul class="nav navbar-nav navbar-right">
                <li><a href="work.html">Work</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>-->
				<ul class="nav navbar-top-links navbar-right">

					<!-- /.dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"
							style="color: #2a6496"></i> <i class="fa fa-caret-down"
							style="color: #2a6496"></i>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a href="#">
									<div>
										<i class="fa fa-comment fa-fw"></i> New Comment <span
											class="pull-right text-muted small">4 minutes ago</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
									<div>
										<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
											class="pull-right text-muted small">12 minutes ago</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
									<div>
										<i class="fa fa-envelope fa-fw"></i> Message Sent <span
											class="pull-right text-muted small">4 minutes ago</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
									<div>
										<i class="fa fa-tasks fa-fw"></i> New Task <span
											class="pull-right text-muted small">4 minutes ago</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
									<div>
										<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
											class="pull-right text-muted small">4 minutes ago</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a class="text-center" href="#"> <strong>See
										All Alerts</strong> <i class="fa fa-angle-right"></i>
							</a></li>
						</ul> <!-- /.dropdown-alerts --></li>
					<!-- /.dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"
							style="color: #2a6496"></i> <i class="fa fa-caret-down"
							style="color: #2a6496"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#"><i class="fa fa-user fa-fw"></i> User
									Profile</a></li>
							<li><a href="#"><i class="fa fa-gear fa-fw"></i>
									Settings</a></li>
							<li class="divider"></li>
							<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
									Logout</a></li>
						</ul> <!-- /.dropdown-user --></li>
					<!-- /.dropdown -->
				</ul>
				<!-- /.navbar-top-links -->
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</body>
</html>