<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Form</title> 

        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <<link rel="stylesheet" href="../css/login.css"/>

    </head>
    <body>
        <div class="container">
            <div class="wrapper">
                <div class="title"><span>Login</span></div>
                <form action="../LoginService" method="post">
                    <div class="row">
                        <i class="fas fa-user"></i>
                        <input type="text" name="email" placeholder="Email or Phone" required>
                    </div>
                    <div class="row">
                        <i class="fas fa-lock"></i>
                        <input type="password" name="password" placeholder="Password" required>
                    </div>
                    <div class="pass"><a href="#">Forgot password?</a></div>
                    <div class="row button">
                        <input type="submit" value="Login">
                    </div>
                    <div class="signup-link">Not a member? <a href="/Lead_Mangement_System/">Register</a></div>
                </form>
            </div>
        </div>


          </body>

</html>