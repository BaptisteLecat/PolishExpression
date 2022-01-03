<%--
  Created by IntelliJ IDEA.
  User: BaptisteLecat
  Date: 16/11/2021
  Time: 11:18
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

<div class="container">
    <button type="button" class="btn btn-primary btn-lg" onclick='window.location.href = "play";'>Lancer une partie</button>
</div>

<div class="container-md">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Score</th>
        </tr>
        </thead>
        <tbody>
        <%

            if(request.getAttribute("listLeaderBoard") != null){
                List<entity.LeaderBoard> listLeaderBoard =(List<entity.LeaderBoard>)request.getAttribute("listLeaderBoard");
                int index = 0;
                for (entity.LeaderBoard leaderBoard: listLeaderBoard)
                {
                    index++;
        %>

        <tr>
            <th scope="row"><%= index %></th>
            <td><%= leaderBoard.getUser().getName() %></td>
            <td><%= leaderBoard.getUser().getFirstName() %></td>
            <td><%= leaderBoard.getScore() %></td>
            <td><button type="button" class="btn btn-primary" onclick='window.location.href = "profil?userId=<%= leaderBoard.getUser().getId() %>";'>Profil</button></td>
        </tr>
        <% }
        }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
