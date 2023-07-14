package in.pandit.services;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/RegisterUsers")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		try {
			Connection connect = DatabaseConnection.getConnection();
			
//			 Fetching max id from sign up table for auto increment id
			int count = 0;
			PreparedStatement st = connect.prepareStatement("select max(id) as id from users");

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt("id");
			}
			
			// Inserting data into data base
			PreparedStatement stmt = connect.prepareStatement("insert into users values(?, ?, ?, ?, ?)");
			stmt.setInt(1, ++count);
			stmt.setString(2, username);
			stmt.setString(3, email);
			stmt.setString(4, mobile);
			stmt.setString(5, password);
			int status = stmt.executeUpdate();
		if(status > 0) {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You have registered successfully');");
			pw.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
		else {
			pw.print("Something wrong with database");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
