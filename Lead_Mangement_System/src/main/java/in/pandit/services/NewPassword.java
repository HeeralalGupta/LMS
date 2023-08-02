package in.pandit.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.pandit.persistance.DatabaseConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		RequestDispatcher dispatcher = null;
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

			try {
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement pst = con.prepareStatement("update users set password = ? where email = ? ");
				pst.setString(1, newPassword);
				pst.setString(2, (String) session.getAttribute("email"));

				int rowCount = pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("success", "resetSuccess");
					dispatcher = request.getRequestDispatcher("index.jsp");
				} else {
					request.setAttribute("failed", "resetFailed");
					dispatcher = request.getRequestDispatcher("signup.jsp");
				}
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
