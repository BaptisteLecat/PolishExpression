<%--
  Created by IntelliJ IDEA.
  User: BaptisteLecat
  Date: 27/10/2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-5.1.3-dist/css/bootstrap.css">
    <title>SGP - App</title>
</head>
<body>
<h1>La page de register</h1>

<div class="container h-100">
    <div class="col d-flex justify-content-center flex-nowrap">
        <form method="post">
            <div class="form-group">
                <label for="inputName">Nom</label>
                <input type="text" class="form-control" id="inputName" name="inputName" placeholder="Nom" required>
            </div>
            <div class="form-group">
                <label for="inputFirstName">Prénom</label>
                <input type="text" class="form-control" id="inputFirstName" name="inputFirstName" placeholder="Prénom" required>
            </div>
            <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="email" class="form-control" id="inputEmail" name="inputEmail" aria-describedby="emailHelp" placeholder="Email" required>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="inputPassword">Mot de passe</label>
                <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Mot de passe" required>
            </div>
            <p><a href="login">J'ai déjà un compte</a></p>
            <button type="submit" class="btn btn-primary">Enregistrement</button>
            <%

                if(request.getAttribute("errorMessage") != null){
                    String errorMessage =(String)request.getAttribute("errorMessage");
            %>
            <div class="mb-3">
                <p> <%= errorMessage %></p>
            </div>
            <%
                }
            %>
        </form>
    </div>
</div>

</body>
</html>