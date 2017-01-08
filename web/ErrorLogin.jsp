<%-- 
    Document   : ErrorLogin
    Created on : Oct 19, 2016, 10:47:11 AM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Japaweb</title>
        <script>
            function redirectForm() {
                alert("Os dados inseridos não constam no nosso banco de dados. Insira novamente ou realize o seu cadastro!");
                return true;
            }
        </script>
    </head>
    <body>
        <form name="ReturnLogin" action="Login.jsp" method="GET" onsubmit="return redirectForm()">
        </form>
    </body>
</html>
