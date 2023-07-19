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


@WebServlet("/help")
public class help extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String comments = request.getParameter("comments");
		try {
			Connection conn = DatabaseConnection.getConnection();
			int count = 0;
			PreparedStatement st = conn.prepareStatement("select max(id) as id from contacts");

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			count = rs.getInt("id");
			}
			
			PreparedStatement stmt = conn.prepareStatement("insert into contacts values(?, ?, ?, ?, ?)");
			
			stmt.setInt(1, ++count);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, mobile);
			stmt.setString(5, comments);
			int check = stmt.executeUpdate();
			if(check>0) {
				RequestDispatcher rd = request.getRequestDispatcher("help.jsp");
				rd.include(request, response);
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Thanks! We will connect you soon');");
				pw.println("</script>");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
