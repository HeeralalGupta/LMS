package in.pandit.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.pandit.persistance.DatabaseConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetching data from login from
			
				String email = request.getParameter("email");
				String password = request.getParameter("pass");
				
				// Declared variable for storing data, fetched from database
				String email1 = null;
				String password1 = null;
				String isAdmin = null;
				String isSuperAdmin = null;
				try {
					Connection conn = DatabaseConnection.getConnection(); // Calling static getConnection method using class name
					
					// Fetching data from database
					PreparedStatement ps = conn.prepareStatement("select email, password, isadmin, issuperadmin from users where email = ?");
					
					ps.setString(1, email);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						email1 = rs.getString(1);
						password1 = rs.getString(2);
						isAdmin = rs.getString(3);
						isSuperAdmin = rs.getString(4);
						
					}
					
				}catch (Exception e) {
					System.out.println(e);
				}
				
				if (email.equals(email1) && password.equals(password1) && isAdmin.equals("false") && isSuperAdmin.equals("false")) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("dashboard.jsp");
				}
				else if(email.equals(email1) && password.equals(password1) && isAdmin.equals("a") && isSuperAdmin.equals("false")) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("admin.jsp");
				}
				else if(email.equals(email1) && password.equals(password1) && isSuperAdmin.equals("s") && isAdmin.equals("false")) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("superadmin.jsp");
				}
				else {
					request.setAttribute("error", "Invalid Email or Password !");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
					
				}
	}

}
