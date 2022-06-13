<%--
  Created by IntelliJ IDEA.
  User: zhangtianxiang
  Date: 2022/6/2
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel = "stylesheet" type = text/css href = css/login.css>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>

<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form id = "merchantLogin" action="merchantLoginServlet" method="post">
            <h1>Merchant Login</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g" ></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in" ></i></a>
            </div>
            <span>or use your account</span>
            <input type="text" placeholder="ID" id="name_Merchant" name = "name_Merchant"/>
            <input type="password" placeholder="Password" id="password_Merchant" name = "password_Merchant"/>
            <script>
                const msg ="<%=request.getParameter("msg")%>";
                const name = "<%=request.getParameter("name")%>";
                if(msg!=='null'){
                    alert(msg)
                }
                else if(name!=='null'){
                    document.getElementById("name_Merchant").value = name;
                }
            </script>
            <button  id = "btn_Merchant">Sign In</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form id = "loginInfo" action="LoginServlet" method="post">
            <h1>Admin Login</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="text" placeholder="Name" id = "name_Login" name="name_Login" />
            <input type="password" placeholder="Password" id="password_Login" name = "password_Login"/>
            <script>
                const msg ="<%=request.getParameter("msg")%>";
                const name = "<%=request.getParameter("name")%>";
                if(msg!==null){
                    alert(msg)
                }
                else if(name!==null){
                    document.getElementById("name_Login").value = name;
                }
            </script>
            <button id = "btn_Login">Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back Merchant!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In As Admin</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Welcome Back Admin!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signUp">Sign In As Merchant</button>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="js/login.js"></script>
</html>
