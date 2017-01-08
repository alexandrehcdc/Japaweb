<%-- 
    Document   : viewLogin
    Created on : Sep 24, 2016, 7:01:02 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Japaweb - Login</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="masterpage.jsp"/>
 
    <style>
            .login-form {
                width: 25rem;
                height: 18.75rem;
                position: fixed;
                top: 50%;
                margin-top: -9.375rem;
                left: 50%;
                margin-left: -12.5rem;
                background-color: #ffffff;            
                -webkit-transform: scale(.8);
                transform: scale(.8);
            }
            .logo {
                    position: fixed;
                    text-align: center;
                    left: 40%;
                    top: -6%;
                    max-width: 100%;
                    height: auto;
            }
        </style>
    </head> 
        <script>
            function validateForm() {
                var login = document.forms["LoginForm"]["username"].value;
                var password = document.forms["LoginForm"]["password"].value;
                if (login === null || login === "") {
                    alert("Por favor, insira o seu nome de usuário.");
                    return false;
                } else if (password === null || password === ""){
                    alert("Por favor, insira a sua senha");
                }
            }
        </script>
    
    <body>
        <div class="logo">
            <img src="utils/japaweb.png">
        </div>
        <div class="login-form padding20 block-shadow">
            <form name="LoginForm" action="Login" method="post" onsubmit="return validateForm()">
                <h2 class="text-light">Bem-vindo ao Japaweb!</h2>
                <hr class="thin"/>
                <div class="input-control text full-size">
                    <input type="text" name="username" placeholder="Usuário">
                </div>
                <br>
                <div class="input-control password full-size">
                    <input type="password" name="password" placeholder="Senha"><br></div>
                <div class="form-actions">
                    <input type="submit" value="Entrar"><br>
                </div>
            </form>
            <form action="Signup" method="GET">
                    <input type="submit" value="Cadastre-se já!">
            </form>
        </div>
    </body>