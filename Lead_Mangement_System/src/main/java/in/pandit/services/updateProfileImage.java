package in.pandit.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.pandit.persistance.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet("/updateProfileImage")
@MultipartConfig(maxFileSize = 16177215)
public class updateProfileImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		InputStream inputStream = null;
		Part image = request.getPart("pfImage");
		
	    inputStream = image.getInputStream();
		try {
			Connection conn = DatabaseConnection.getConnection();
			HttpSession session = request.getSession();
			String email = session.getAttribute("email").toString();
            PreparedStatement stmt = conn.prepareStatement("update users set image = ? where email = ?");
    
            if(image != null) {
            	stmt.setBinaryStream(1, inputStream);
            }
            stmt.setString(2, email);
            
            int status = stmt.executeUpdate();
            if(status > 0) {
            	System.out.println("Image updated successfully");
            	response.sendRedirect("profile.jsp");
            }
            else {
            	System.out.println("Something went wrong!");
            }
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
