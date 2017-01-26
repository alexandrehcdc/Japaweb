<%-- 
    Document   : Signup
    Created on : Oct 14, 2016, 9:52:28 AM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:import url="masterpage.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Japaweb - Cadastro</title>
        <style>
            .login-form {
                width: 25rem;
                height: 22rem;
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
                    top: -5%;
                    max-width: 100%;
            }
            font {
                font-family: "Segoe UI";
            }

        </style>
        <script>
            function validateSignup() {
                var login = document.forms["Signup"]["username"].value;
                var password = document.forms["Signup"]["password"].value;  
                if (login === null || login === "") {
                    alert("Por favor, insira o seu nome de usuário.");
                    return false;
                } else if (password === null || password === ""){
                    alert("Por favor, insira a sua senha");
                }
            }
        </script>
    </head>
    <body>
        <div class="logo">
            <img src="utils/japaweb.png">
        </div>
        <div class="login-form padding20 block-shadow">
            <form name="Signup" action="Signup" method="post" onsubmit="return validateSignup()">
                <h2 class="text-light">Cadastro</h2>
                <hr class="thin"/>
                <div class="input-control text full-size">
                    <input type="text" name="username" placeholder="Usuário">
                </div>
                <br>
                <div class="input-control password full-size">
                    <input type="password" name="password" placeholder="Senha"><br>
                </div>
                <div class="input-control text full-size">
                    <input type="text" name="email" placeholder="Endereço de e-mail">
                </div>
                <div class="input-control text full-size">
                    <input type="number" name="age" placeholder="Idade">
                </div>
                <div class="form-actions">
                    <input type="submit" value="Enviar"><br>
                </div>
            </form>
        </div>
    </body>
</html>
