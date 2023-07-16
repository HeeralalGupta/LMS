<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Leads</title>
</head>
<body>
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
</body>
</html>