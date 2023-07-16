<%
	session.removeAttribute("login-succ");
	response.sendRedirect("../index.jsp");
%>