package in.pandit.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pandit.Entity.UserEntity;
import in.pandit.dao.UserDao;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
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
		
		
	}

}
