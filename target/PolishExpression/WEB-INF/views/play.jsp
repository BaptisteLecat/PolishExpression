<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 18/11/2021
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="utils.GetRandomPolishExpression"%>


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
        <p>Entrer la valeur de l'expression suivante :
            <%= request.getAttribute("polishExpression") %>
        </p>

    </div>
    <form action="<%=request.getContextPath()%>/play" method="post">
        <div class="form-group">
            <label for="inputResultat">Entrer le résultat</label>
            <input type="number" class="form-control" id="inputResultat" name="inputResultat" placeholder="Résultat" required>
        </div>

        <button type="submit"  class="btn btn-primary">Envoyer</button>
    </form>

    <div >
        <p>Bravo vous avez répondu à toutes les questions, voici votre score :
        <%= request.getAttribute("goodResponse")%>
        /10 </p>
    </div>

</body>
</html>
