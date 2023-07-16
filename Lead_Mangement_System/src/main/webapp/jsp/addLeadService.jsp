<%@page import="in.pandit.dao.AddLeadsDao"%>
<%@page import="in.pandit.Entity.UserEntity"%>
<%@page import="in.pandit.Entity.LeadListEntity"%>
<%@page import="in.pandit.Entity.ClientListEntity"%>
<%
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String gender = request.getParameter("gender");
	String dob = request.getParameter("dob");
	String email = request.getParameter("email");
	String contact = request.getParameter("contact");
	String address = request.getParameter("address");
	
	ClientListEntity client = new ClientListEntity();
	client.setFirstname(fname);
	client.setLastname(lname);
	client.setGender(gender);
	client.setDob(dob);
	client.setEmail(email);
	client.setContact(contact);
	client.setAddress(address);
	
	//lead info
	
	String interested = request.getParameter("interested");
	String source = request.getParameter("source");
	String remarks = request.getParameter("remarks");
	String assigned_to = request.getParameter("assigned_to");
	String status  = request.getParameter("status");
	
	LeadListEntity lead = new LeadListEntity();
	lead.setAssigned_to(assigned_to);
	lead.setInterested_in(interested);
	lead.setRemarks(remarks);
	lead.setSource_id(source);
	lead.setStatus(status);
	
	UserEntity user = (UserEntity)session.getAttribute("login-succ");
	
	int st = AddLeadsDao.addLead(client, lead, user.getId());
	
	if(st>0) {
		session.setAttribute("lead-added", "Lead Added Successfuly");
		response.sendRedirect("dashboard.jsp");
	}else {
		session.setAttribute("lead-failed", "Something went Wrong! Please Try Again.");
		response.sendRedirect("dashboard.jsp");
	}

%>