<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Project </title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/assets/css/main.css"/>" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/assets/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<c:url value="/resources/assets/css/plugins/timeline.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/assets/css/sb-admin-2.css"/>" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<c:url value="/resources/assets/css/plugins/morris.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/assets/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<c:url value="/resources/assets/js/hover.zoom.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/hover.zoom.conf.js"/>"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <img src="resources/assets/img/csc_logo.png" alt="CSC" style="height: 50px">

        </div>
        <div class="navbar-header" STYLE="MARGIN-LEFT:   20px">
            <a class="navbar-brand" href="index.html">FINAL PROJECT</a></div>
        <div class="navbar-collapse collapse">
            <!--<ul class="nav navbar-nav navbar-right">
                <li><a href="work.html">Work</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>-->
            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw" style="color:#2a6496"></i>  <i class="fa fa-caret-down"style="color:#2a6496"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"style="color:#2a6496"></i>  <i class="fa fa-caret-down"style="color:#2a6496"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<img src="resources/assets/img/user.png" alt="Stanley">
                    <div class="container pt">
                        <div class="row mt">
                            <div class="col-lg-6 col-lg-offset-3 centered">
                                <h3>Login</h3>
                                <p>Please enter your information.</p>
                            </div>
                        </div>
                        <div class="row mt">
                            <div class="col-lg-6 col-lg-offset-3"centered>
                                <form role="form">
                                    <div class="form-group">
                                        <input type="name" class="form-control" id="userName" placeholder="User Name">
                                        <br>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="password" placeholder="Password">
                                        <br>
                                    </div>
                                    <button type="submit" class="btn btn-success centered">SUBMIT</button>
                                </form>
                            </div>
                        </div><!-- /row -->
                    </div>
				
				</div><!-- /col-lg-8 -->
			</div><!-- /row -->
	    </div> <!-- /container -->
	</div><!-- /ww -->
	
	
	<!-- +++++ Projects Section +++++ -->
	<!--
	<div class="container pt">
		<div class="row mt centered">	
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port01.jpg" alt="" /></a>
				<p>APE</p>
			</div>
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port02.jpg" alt="" /></a>
				<p>RAIDERS</p>
			</div>
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port03.jpg" alt="" /></a>
				<p>VIKINGS</p>
			</div>
		</div><!-- /row -->
    <!--
		<div class="row mt centered">	
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port04.jpg" alt="" /></a>
				<p>YODA</p>
			</div>
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port05.jpg" alt="" /></a>
				<p>EMPERORS</p>
			</div>
			<div class="col-lg-4">
				<a class="zoom green" href="work01.html"><img class="img-responsive" src="assets/img/portfolio/port06.jpg" alt="" /></a>
				<p>CHIEFS</p>
			</div>
		</div><!-- /row -->
	</div><!-- /container -->

	
	<!-- +++++ Footer Section +++++ -->
	
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<p style="margin-top:10%">Java Fresher Final Project<br>Manage accounts in banking system
					</p>
				</div><!-- /col-lg-4 -->
				<div class="col-lg-4">
				<p style="margin-top:10%">Team 1<br>
				
					</p>
				</div>
				<div class="col-lg-4">
                <h4>My Links</h4>

                <p>
                    <a href="#">Instagram</a><br/>
                    <a href="#">Twitter</a><br/>
                    <a href="#">Facebook</a>
                </p>
            </div>
            <!-- /col-lg-4 -->
				
			
			</div>
		
		</div>
	</div>
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
    <!-- jQuery Version 1.11.0 -->
    <script src="<c:url value="/resources/assets/js/jquery-1.11.0.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/assets/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<c:url value="/resources/assets/js/plugins/morris/raphael.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/plugins/morris/morris.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/plugins/morris/morris-data.js"/>"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/assets/js/sb-admin-2.js"/>"></script>
  </body>
</html>