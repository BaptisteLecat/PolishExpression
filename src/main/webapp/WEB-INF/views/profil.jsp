<%--
  Created by IntelliJ IDEA.
  User: BaptisteLecat & FxPelet
  Date: 16/11/2021
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@ page import="entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-5.1.3-dist/css/bootstrap.css">
    <title>SGP - App</title>
</head>
<body>
<%

    if(request.getAttribute("errorMessage") != null){
%>
<h1><%request.getAttribute("errorMessage"); %></h1>
<%
    }else{
%>

<%

    if((request.getAttribute("user") != null) && (request.getAttribute("listLeaderBoardUser") != null)){
        User user = (User) request.getAttribute("user");
        entity.LeaderBoard lastLeaderBoard = (entity.LeaderBoard) request.getAttribute("lastLeaderBoard");
        List<entity.LeaderBoard> listLeaderBoardUser = (List<entity.LeaderBoard>) request.getAttribute("listLeaderBoardUser");
        String bestScore = "Aucune partie";
        String dateLastGame = "Aucune partie";

        if(!listLeaderBoardUser.isEmpty()){
            bestScore = String.valueOf(listLeaderBoardUser.get(0).getScore());
        }

        if(lastLeaderBoard != null){
            dateLastGame = String.valueOf(lastLeaderBoard.getDate());
        }
%>
<h1>Profil</h1>
<div class="container">
    <div class="row">
        <div class="col">
<div class="card">
    <h5 class="card-header"><%= user.getName() + " " + user.getFirstName() %></h5>
    <div class="card-body">
        <div class="row">
            <div class="col-sm">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Email : <%= user.getEmail() %></li>
                    <li class="list-group-item">Meilleur Score : <%= bestScore %></li>
                    <li class="list-group-item">Date de derniere partie : <%= dateLastGame %></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
<%
    }
%>

<%
    }
%>
</body>
</html>
