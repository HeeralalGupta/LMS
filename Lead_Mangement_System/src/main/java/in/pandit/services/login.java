package in.pandit.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pandit.Entity.UserEntity;
import in.pandit.dao.UserDao;
import in.pandit.persistance.DatabaseConnection;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Fetching data from login from
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		UserEntity user = UserDao.login(email, password);
		
		try {
			if(user!=null) {
				session.setAttribute("login-succ", user);
				response.sendRedirect("jsp/dashboard.jsp");
			}else {
				session.setAttribute("login-failed", "Please Try Again...");
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
