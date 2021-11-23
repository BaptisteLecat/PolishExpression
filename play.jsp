<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 18/11/2021
  Time: 18:38
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
<h1>Calcul mental</h1>
    <div>
        <p>Entrer la valeur de l'expression suivante : ${ polishExpression } </p>
        </p>
    </div>

    <div class="form-group">
        <label for="inputResultat">Entrer le résultat</label>
        <input type="text" class="form-control" id="inputResultat" name="inputResultat" placeholder="Résultat" required>
    </div>

    <button type="submit" class="btn btn-primary">Envoyer</button>
</body>
</html>
