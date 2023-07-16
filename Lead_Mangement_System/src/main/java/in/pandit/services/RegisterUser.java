package in.pandit.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

<<<<<<< HEAD
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
=======
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pandit.persistance.DatabaseConnection;
>>>>>>> refs/remotes/origin/gopal2

import in.pandit.Entity.UserEntity;
import in.pandit.dao.UserDao;


@WebServlet("/RegisterUsers")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
=======
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("name");
>>>>>>> refs/remotes/origin/gopal2
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
<<<<<<< HEAD
		String cfpassword = request.getParameter("cfpassword");
		System.out.println(email);
		System.out.println(mobile);
		UserEntity emailInfo = UserDao.getUserEmailInfo(email);
//		UserEntity mobileInfo = UserDao.getUserMobileInfo(mobile);
//		System.out.println(emailInfo);
//		System.out.println(mobileInfo);
//		if(emailInfo == null && mobileInfo == null) {
		
//			if(password.length()>=8 && password.length()<=25 && cfpassword.length()>=8 && cfpassword.length()<=25) {
//				if(password.equals(cfpassword)) {
//					UserEntity user = new UserEntity();
//					user.setName(name);
//					user.setEmail(email);
//					user.setMobile(mobile);
//					user.setPassword(password);
//					user.setCfpassword(cfpassword);
//					try {
//						int st = UserDao.RegisterUser(user);
//						if(st>0) {
//							session.setAttribute("reg-done", emailInfo);
//							response.sendRedirect("jsp/login.jsp");
//						}else {
//							session.setAttribute("server-error", "Oops something went wrong !");
//							response.sendRedirect("isError.jsp");
//						}
//					}catch(Exception e) {
//						System.out.println(e);
//					}	
//					
//				}else {
//					session.setAttribute("not-same", "Please enter same password");
//					response.sendRedirect("index.jsp");
//				}
//			}else {
//				session.setAttribute("pass-length", "Password should be >=8 and <=25");
//				response.sendRedirect("index.jsp");
//			}
		
//		}else {
//			session.setAttribute("already-acc", "Already have account with same email and mobile");
//			response.sendRedirect("index.jsp");
//		}
=======
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
>>>>>>> refs/remotes/origin/gopal2
		
		
	}

}
