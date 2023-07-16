<%
	String isLogin = (String)session.getAttribute("login-success");
	if(isLogin!=null){
		response.sendRedirect(request.getRequestURI());
    }else{
		response.sendRedirect("login.jsp");
    }
%>