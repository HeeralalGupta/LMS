package in.pandit.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pandit.Entity.ClientListEntity;
import in.pandit.Entity.LeadListEntity;
import in.pandit.Entity.UserEntity;
import in.pandit.dao.AddLeadsDao;

/**
 * Servlet implementation class AddLeadService
 */
@WebServlet("/AddLeadService")
public class AddLeadService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		client info
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
		
//		lead info
		
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
		
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("login-succ");
		
		int st = AddLeadsDao.addLead(client, lead, user.getId());
		
	}

}
