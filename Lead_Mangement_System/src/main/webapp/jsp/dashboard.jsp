<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.pandit.Entity.UserEntity"%>
			
<!Doctype HTML>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<div class="main-container">
		<div id="mySidenav" class="sidenav">
			<p class="logo"> <span>L </span>M S </p>
			<a href="homejsp.jsp" class="icon-a"><i class="fa fa-dashboard icons"></i> Dashboard</a>
			<a href="myleads.jsp" class="icon-a"><i class="fa fa-users icons"></i> My Leads</a>
			<a href="profile.jsp" class="icon-a"><i class="fa fa-list icons"></i> Profile</a> 
			<a href="tasks.jsp" class="icon-a"><i class="fa fa-shopping-bag icons"></i> Tasks</a> 
			<a href="about.jsp" class="icon-a"><i class="fa fa-users icons"></i> About </a> 
			<a href="faq.jsp" class="icon-a"><i class="fa fa-user icons"></i> FAQ</a> 
			<a href="logout.jsp" class="icon-a"><i class="fa fa-list-alt icons"></i> Logout</a>
		</div>
		<div id="main">
			<div class="head">
				<div class="col-div-6">
					<span style="font-size: 30px; cursor: pointer; color: white;"
						class="nav"> Dashboard</span> <span
						style="font-size: 30px; cursor: pointer; color: white;"
						class="nav2"> Dashboard</span>
				</div>
				<div class="col-div-6">
					<div class="profile">

						<img src="img/user.png" class="pro-img" />
						<p style="font-size: 20px;">
							<%
							UserEntity user = (UserEntity)session.getAttribute("login-succ");
							if (user != null) {
							%>
								<%= user.getName() %>
							<%
							}
							%>
							<span style="font-size: 12px;">Web Developmemt</span>
						</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<br />
			<div class="col-div-3">
				<div class="box">
					<p>
						0<br />
						<span>My Leads</span>
					</p>
					<i class="fa fa-users box-icon"></i>
				</div>
			</div>
			<div class="col-div-3">
				<div class="box">
					<p>
						0<br />
						<span>Projects</span>
					</p>
					<i class="fa fa-list box-icon"></i>
				</div>
			</div>
			<div class="col-div-3">
				<div class="box">
					<p>
						0<br />
						<span>Tasks</span>
					</p>
					<i class="fa fa-shopping-bag box-icon"></i>
				</div>
			</div>
			<div class="col-div-3">
				<div class="box">
					<p>
						0<br />
						<span>Orders</span>
					</p>
					<i class="fa fa-tasks box-icon"></i>
				</div>
			</div>
			<div class="clearfix"></div>
			<br>	
		</div>
	</div>
	
	<div class="clearfix"></div>
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Add Leads
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <!--  -->
        <h2 class="add">Add New Lead</h2>
			<div class="add-lead-btn">
				<form class="form" action="AddLead" method="post">
					<div class="client-info">
						<h3>Client Information</h3>
						<div>
							<label>First Name</label> <input type="text" name="fname"
								placeholder="Enter First Name..." >
						</div>
						<div>
							<label>Last Name</label> <input type="text" name="lname"
								placeholder="Enter Last Name...">
						</div>
						<div>
							<label>Gender</label> <select name="gender">
								<option value="male" name="male">Male</option>
								<option value="female" name="female">Female</option>
								<option value="other" name="other">Other</option>
							</select>
						</div>
						<div>
							<label>DOB</label> <input type="date" name="dob">
						</div>
						<div>
							<label>Email</label> <input type="email" name="email"
								placeholder="Enter Email...">
						</div>
						<div>
							<label>Contact</label> <input type="tel" name="contact"
								placeholder="Enter Contact Number...">
						</div>
						<div>
							<label>Address</label> <input type="text" name="address"
								placeholder="Enter Address...">
						</div>
					</div>
					<div class="lead-info">
						<h3>Lead Information</h3>
						<div>
							<label>Interested in</label> <input type="text" name="interested"
								placeholder="Enter Interest...">
						</div>
						<div>
							<label>Lead Source</label> <select name="gender">
								<option value="male" name="male">Google ads</option>
								<option value="female" name="female">Social media</option>
								<option value="other" name="other">Email newsletters</option>
								<option value="other" name="other">Company Website</option>
								<option value="other" name="other">Facebook ads</option>
								<option value="other" name="other">Referral</option>
								<option value="other" name="other">Other Sources</option>
							</select>
						</div>
						<div>
							<label>Remarks</label>
							<textarea rows="10" cols="40" name="remarks"
								placeholder="Enter Remarks..."></textarea>
						</div>
						<div>
							<label>Assigned to</label> <select name="gender">
								<option value="gopal" name="gopal">Gopal</option>
								<option value="satyam" name="satyam">Satyam</option>
								<option value="ram" name="ram">Ram</option>
							</select>
						</div>
						<div>
							<label>Status</label> <select name="status">
								<option value="New/Prospect" name="New/Prospect">New/Prospect</option>
								<option value="Open" name="Open">Open</option>
								<option value="Working" name="Working">Working</option>
								<option value="Not a Target" name="Not a Target">Not a
									Target</option>
								<option value="Disqualified" name="Disqualified">Disqualified</option>
								<option value="Nature" name="Nature">Nature</option>
							</select>
						</div>
						<div class="btn-div">
							<input class="btn-add" type="submit" value="Add Lead" />
						</div>
					</div>
				</form>
			</div>
			
			<!--  -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(".nav").click(function() {
			$("#mySidenav").css('width', '70px');
			$("#main").css('margin-left', '70px');
			$(".logo").css('visibility', 'hidden');
			$(".logo span").css('visibility', 'visible');
			$(".logo span").css('margin-left', '-10px');
			$(".icon-a").css('visibility', 'hidden');
			$(".icons").css('visibility', 'visible');
			$(".icons").css('margin-left', '-8px');
			$(".nav").css('display', 'none');
			$(".nav2").css('display', 'block');
		});

		$(".nav2").click(function() {
			$("#mySidenav").css('width', '300px');
			$("#main").css('margin-left', '300px');
			$(".logo").css('visibility', 'visible');
			$(".icon-a").css('visibility', 'visible');
			$(".icons").css('visibility', 'visible');
			$(".nav").css('display', 'block');
			$(".nav2").css('display', 'none');
		});
	</script>

</body>


</html>