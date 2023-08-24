package in.pandit.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.pandit.persistance.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/deleteSuperAdminLead")
public class deleteSuperAdminLead extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("delete");
		String updatedemail = email.substring(2, email.length()-1);
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("delete from leads where email = ?");
			pst.setString(1, updatedemail);
			int check = pst.executeUpdate();
			if(check>0) {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "Data Deleted Successfully");
				response.sendRedirect("allLeadsSuperAdmin.jsp");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
