package in.pandit.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pandit.Entity.UserEntity;
import in.pandit.dao.UserDao;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginService() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isLogin = UserDao.validate(email,password);
		if(isLogin) {
			System.out.println("login done");
			UserEntity user = UserDao.getUserEmailInfo(email);
			session.setAttribute("login-succ", user);
			response.sendRedirect("jsp/dashboard.jsp");
		}
	}

}
