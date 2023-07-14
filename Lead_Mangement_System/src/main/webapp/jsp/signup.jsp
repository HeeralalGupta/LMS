<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration or Sign Up form in HTML CSS | CodingLab </title> 
        <link rel="stylesheet" href="./css/signup.css"/>
    </head>

    <body>
        <div class="wrapper">
            <h2>Registration</h2>
            <form action="RegisterUser" method="post">
            	<%
            		String alreadyAcc =(String)session.getAttribute("already-acc");
            		if(alreadyAcc!=null)
            		{
            		%>
            			<div><%= alreadyAcc %></div>
            		<%
            		session.removeAttribute("already-acc");
            		}
            	%>
            	<%
            		String notSame =(String)session.getAttribute("not-same");
            		if(notSame!=null)
            		{
            		%>
            			<div><%= notSame %></div>
            		<%
            		session.removeAttribute("not-same");
            		}
            	%>
            	<%
            		String passLength =(String)session.getAttribute("pass-length");
            		if(passLength!=null)
            		{
            		%>
            			<div><%= passLength %></div>
            		<%
            		session.removeAttribute("pass-length");
            		}
            	%>
            	<%
            		String serverErr =(String)session.getAttribute("server-error");
            		if(serverErr!=null)
            		{
            		%>
            			<div><%= serverErr %></div>
            		<%
            		session.removeAttribute("server-error");
            		}
            	%>
                <div class="input-box">
                    <input type="text" placeholder="Enter your name" required name="name">
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter your email" required name="email">
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter your Mobile" required name="mobile">
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Create password" required name="password">
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Confirm password" required name="cfpassword">
                </div>
                <div class="policy">
                    <input type="checkbox">
                    <h3>I accept all terms & condition</h3>
                </div>
                <div class="input-box button">
                    <input type="Submit" value="Register Now" href='index.html'>
                </div>
            
            </form>
        </div>
    </body>
</html>
    