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
    <%
    if(request.getAttribute("turn") != null){
        int turn =(int)request.getAttribute("turn");
        if(request.getAttribute("goodResponse") != null){
            int goodResponse =(int)request.getAttribute("goodResponse");
                if(turn >= 10){%>
                    <div>
                        <p>Bravo vous avez répondu à toutes les questions, voici votre score :
                            <%= goodResponse %> /10</p>
                    </div>
                    <button type="submit" class="btn btn-primary" id="homeId" onclick='window.location.href = "home";'>Hall of Shame</button>
                <%}else{
                    if(request.getAttribute("polishExpression") != null){
                    String polishExpression =(String)request.getAttribute("polishExpression");%>
                        <div>
                            <p>Entrer la valeur de l'expression suivante : <%= polishExpression %></p>
                        </div>
                        <form action="<%=request.getContextPath()%>/play" method="post">
                            <div class="form-group">
                                <label for="inputResultat">Entrer le résultat</label>
                                <input type="number" step="0.01" class="form-control" id="inputResultat" name="inputResultat" placeholder="Résultat" required>
                            </div>
                            <button type="submit" class="btn btn-primary" >Envoyer</button>
                        </form>
                    <%}%>
                        <div>
                            <p> Vous avez répondu à <%= turn %> expression polonaise sur 10.</p>
                        </div>

                    <%
            }
        }else{%>
            <p>Une erreur est survenue : goodResponse</p>
        <%}
    }else{%>
        <p>Une erreur est survenue : turn</p>
    <%}%>
    </body>
</html>