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


@WebServlet("/udpateSuperAdminProfile")
public class udpateSuperAdminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("update users set name = ?, email = ?, mobile = ? where email = ?");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, mobile);
			pst.setString(4, email);
			
			int check = pst.executeUpdate();
			if(check > 0 ) {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "Data Updated Successfully");
				response.sendRedirect("superAdminProfile.jsp");	
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "Data Not Updated Successfully");
				response.sendRedirect("superAdminProfile.jsp");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
