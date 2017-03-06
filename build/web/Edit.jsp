<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.VO.UserVO"%>
<%@page import="Model.DAO.UserDAO"%>
<%
    userVO user = (userVO) session.getAttribute("currentSessionUser");
%>
<!DOCTYPE html>

<html>
    <head>
        <c:import url="masterpage.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar perfil</title>
        <style>
            .login-form {
                width: 25rem;
                height: 28rem;
                position: fixed;
                top: 35%;
                margin-top: -9.375rem;
                left: 50%;
                margin-left: -12.5rem;
                background-color: #ffffff;            
                -webkit-transform: scale(.8);
                transform: scale(.8);
            }
        </style>
    </head>
    <c:import url="appbar.jsp"/>
    <div class="login-form padding20 block-shadow">
            <form name="LoginForm" action="Edit" method="post" onsubmit="return validateForm()">
                <h2 class="text-light">Editar perfil</h2>
                <hr class="thin"/>
                <div class="input-control text full-size">
                    <input type="text" name="name" value="<%=user.getName()%>" placeholder="Nome"><br>
                </div>
                <div class="input-control text full-size">
                    <input type="text" name="username" value="<%=user.getUsername()%>" placeholder="Usuário" readonly><br>
                </div>
                <div class="input-control password full-size">
                    <input type="password" name="password" value="<%=user.getPassword()%>" placeholder="Senha"><br>
                </div>
                <div class="input-control password full-size">
                    <input type="text" name="email" value="<%=user.getEmail()%>" placeholder="E-mail"><br>
                </div>
                <div class="input-control password full-size">
                    <input type="number" name="age" value="<%=user.getAge()%>" placeholder="Idade"><br>
                </div>
                <div class="input-control password full-size">
                    <input type="text" name="address" value="<%=user.getAddress()%>" placeholder="Endereço"><br>
                </div>
                <div class="form-actions">
                    <input type="submit" value="Enviar"><br>
                </div>
            </form>
        </div>
</html>