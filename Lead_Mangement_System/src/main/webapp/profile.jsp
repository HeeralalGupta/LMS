<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import = "in.pandit.persistance.DatabaseConnection" %>
<!Doctype HTML>
	<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="css/style.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<!-- cdn for table with pagination -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
<style>
body{
	margin:0px;
	padding: 0px;
	background-color:#1b203d;
	overflow: hidden;
	font-family: system-ui;
}
.clearfix{
	clear: both;
}
.logo{
	margin: 0px;
	margin-left: 80px;
    font-weight: bold;
    color: white;
    margin-bottom: 30px;
}
.logo span{
	color: #f7403b;
}
.sidenav {
  height: 100%;
  width: 300px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #272c4a;
  overflow: hidden;
  transition: 0.5s;
  padding-top: 30px;
}
.sidenav a {
  padding: 15px 8px 15px 32px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
  transition: 0.3s;
}
.sidenav a:hover {
  color: #f1f1f1;
  background-color:#1b203d;
}
.sidenav{
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
}
#main {
  transition: margin-left .5s;
  padding: 16px;
  margin-left: 300px;
}
.head{
	padding:20px;
}
.col-div-6{
	width: 50%;
	float: left;
}
.profile{
	display: inline-block;
	float: right;
	width: 160px;
}
.pro-img{
	float: left;
	width: 40px;
	margin-top: 5px;
	border-radius: 50px;
}
.profile p{
	color: white;
	font-weight: 500;
	margin-left: 55px;
	margin-top: 10px;
	font-size: 13.5px;
}
.profile p span{
	font-weight: 400;
    font-size: 12px;
    display: block;
    color: #8e8b8b;
}
.col-div-3{
	width: 25%;
	float: left;
}
.box{
	width: 85%;
	height: 100px;
	background-color: #272c4a;
	margin-left: 10px;
	padding:10px;
}
.box p{
	 font-size: 35px;
    color: white;
    font-weight: bold;
    line-height: 30px;
    padding-left: 10px;
    margin-top: 20px;
    display: inline-block;
}
.box p span{
	font-size: 20px;
	font-weight: 400;
	color: #818181;
}
.box-icon{
	font-size: 40px!important;
    float: right;
    margin-top: 35px!important;
    color: #818181;
    padding-right: 10px;
}
.col-div-8{
	width: 70%;
	float: left;
}
.col-div-4{
	width: 30%;
	float: left;
}
.content-box{
	padding: 20px;
}
.content-box p{
	margin: 0px;
    font-size: 20px;
    color: #f7403b;
}
.content-box p span{
	float: right;
    background-color: #ddd;
    padding: 3px 10px;
    font-size: 15px;
}
.box-8, .box-4{
	width: 95%;
	background-color: #272c4a;
	height: 330px;
	
}
.nav2{
	display: none;
}

.box-8{
	margin-left: 10px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  
}
td, th {
  text-align: left;
  padding:15px;
  color: #ddd;
  border-bottom: 1px solid #81818140;
}
.circle-wrap {
  margin: 50px auto;
  width: 150px;
  height: 150px;
  background: #e6e2e7;
  border-radius: 50%;
}
.circle-wrap .circle .mask,
.circle-wrap .circle .fill {
  width: 150px;
  height: 150px;
  position: absolute;
  border-radius: 50%;
}
.circle-wrap .circle .mask {
  clip: rect(0px, 150px, 150px, 75px);
}

.circle-wrap .circle .mask .fill {
  clip: rect(0px, 75px, 150px, 0px);
  background-color: #f7403b;
}
.circle-wrap .circle .mask.full,
.circle-wrap .circle .fill {
  animation: fill ease-in-out 3s;
  transform: rotate(126deg);
}

@keyframes fill {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(126deg);
  }
}
.circle-wrap .inside-circle {
  width: 130px;
  height: 130px;
  border-radius: 50%;
  background: #fff;
  line-height: 130px;
  text-align: center;
  margin-top: 10px;
  margin-left: 10px;
  position: absolute;
  z-index: 100;
  font-weight: 700;
  font-size: 2em;
}

/* Css for add lead form */
.boxheading{
	width: 96%;
	height: 550px;
	background-color: #272c4a;
	margin-left: 10px;
	padding:10px;
}
.boxheading p{
	 font-size: 25px;
    color: white;
    line-height: 30px;
    padding-left: 10px;
    margin-top: 7px;
    display: inline-block;
}
/* Table Desing */


table th , table td{
    text-align: center;
}

table tr:nth-child(even){
    background-color: #1b203d;
}

.pagination li:hover{
    cursor: pointer;
}
		table tbody tr {
			display: none;
		}

/* Profile Image Styling */
.profile-img{
	float: left;
	width: 60px;
	margin-top: 5px;
	border-radius: 50px;
}
</style>


</head>


	<body>
		
		<div id="mySidenav" class="sidenav">
		<p class="logo"><span>L </span>M S</p>
	  <a href="dashboard.jsp" class="icon-a"><i class="fa fa-dashboard icons"></i>   Dashboard</a>
	  <a href="myLeads.jsp"class="icon-a"><i class="fa fa-users icons"></i>   My Leads</a>
	  <a href="profile.jsp"class="icon-a"><i class="fa fa-user icons"></i>   Profile</a>
	  <!-- <a href="#"class="icon-a"><i class="fa fa-shopping-bag icons"></i>  Task</a> -->
	  <!-- <a href="#"class="icon-a"><i class="fa fa-users icons"></i>  About </a> -->
	  <a href="help.jsp"class="icon-a"><i class="fa fa-list icons"></i>   Help</a>
	  <form action = "logout">
	  <a href="index.jsp"class="icon-a"><i class="fa fa-list-alt icons"></i>  Logout</a>
		</form>
	</div>
	<div id="main">

		<div class="head">
			<div class="col-div-6">
	<span style="font-size:30px;cursor:pointer; color: white;" class="nav"  > My Profile</span>
	<span style="font-size:30px;cursor:pointer; color: white;" class="nav2"  > My Profile</span>
	</div>
		
		<div class="col-div-6">
		<div class="profile">

			<img src="image/xyz.jfif" class="pro-img" />
			<p style="font-size:20px;">PanditSoft <span  style="font-size:12px;">Web Development</span></p>
		</div>
	</div>
		<div class="clearfix"></div>
	</div>

		<div class="clearfix"></div>
		<br/>
		
		<div class="col-div-3">
			<div class="box">
				<p>
					<%
						Connection connect = DatabaseConnection.getConnection();
						int count = 0;
						PreparedStatement st = connect.prepareStatement("select max(id) as id from leads");

						ResultSet rs = st.executeQuery();
						while (rs.next()) {
						count = rs.getInt("id");
						}
						out.print(count);
					%> 
				<br/><span>My Leads</span></p>
				<i class="fa fa-users box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p>0<br/><span>New Leads</span></p>
				<i class="fa fa-cart-plus box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p>0<br/><span>Social Media</span></p>
				<i class="fa fa-globe box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p>0<br/><span>Enrolled</span></p>
				<i class="fa fa-tasks box-icon"></i>
			</div>
		</div>
		
		<div class="clearfix"></div>
		<br/>
		
		
		<!-- Adding new leads form -->
		<div class="clearfix"></div>
		<br/>
		
		<div class="col-12">
			<div class="boxheading">
				<p>My Profile</p>
				<img src="image/xyz.jfif" class="profile-img" />	
				
			
		<div class="container-fluid">
				<div class="form-group"> 	<!--		Show Numbers Of Rows 		-->
				
				
				
			 <%
			 	String email = request.getParameter("email");
			 	String user = null;
			 	String emailid = null;
			 	String mobile = null;
			 	try{
	  					Connection connect1 = DatabaseConnection.getConnection();
	  				
	  					PreparedStatement ps = connect1.prepareStatement("select name, email, mobile from users where email = ?");
	  					ps.setString(1, email);
	  					ResultSet rs1 = ps.executeQuery();

	  					while (rs.next()) {
	  						user = rs.getString(1);
	  						emailid = rs.getString(2);
	  						mobile = rs.getString(3);
	  					}
	  					
	  					out.print("Name  " + user);
	  					out.print("Email " + emailid);
	  					out.print("Mobile " +mobile);
	  					
	  				}catch(Exception e) {
	  					System.out.println(e);
	  				}
			 	%>
			 
		</div>

		</div>
		</div>
		</div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

	  $(".nav").click(function(){
	    $("#mySidenav").css('width','70px');
	    $("#main").css('margin-left','70px');
	    $(".logo").css('visibility', 'hidden');
	    $(".logo span").css('visibility', 'visible');
	     $(".logo span").css('margin-left', '-10px');
	     $(".icon-a").css('visibility', 'hidden');
	     $(".icons").css('visibility', 'visible');
	     $(".icons").css('margin-left', '-8px');
	      $(".nav").css('display','none');
	      $(".nav2").css('display','block');
	  });

	$(".nav2").click(function(){
	    $("#mySidenav").css('width','300px');
	    $("#main").css('margin-left','300px');
	    $(".logo").css('visibility', 'visible');
	     $(".icon-a").css('visibility', 'visible');
	     $(".icons").css('visibility', 'visible');
	     $(".nav").css('display','block');
	      $(".nav2").css('display','none');
	 });
	

	</script>

	</body>


	</html>