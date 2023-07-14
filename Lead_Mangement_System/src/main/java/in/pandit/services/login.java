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
				try {
					Connection conn = DatabaseConnection.getConnection(); // Calling static getConnection method using class name
					
					// Fetching data from database
					PreparedStatement ps = conn.prepareStatement("select email, password from users where email = ?");
					
					ps.setString(1, email);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						email1 = rs.getString(1);
						password1 = rs.getString(2);
						
					}
					
				}catch (Exception e) {
					System.out.println(e);
				}
				if (email.equals(email1) && password.equals(password1)) {
					RequestDispatcher rd1 = request.getRequestDispatcher("jsp/dashboard.jsp");
					rd1.forward(request, response);
				}
				else {
					
				}
	}

}
