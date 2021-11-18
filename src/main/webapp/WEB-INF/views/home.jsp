<%--
  Created by IntelliJ IDEA.
  User: TechnoCraft
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

        if(request.getAttribute("errorMessage") != null){
            List<entity.LeaderBoard> listLeaderBoard =(List<entity.LeaderBoard>)request.getAttribute("errorMessage");
     for (entity.LeaderBoard leaderBoard: listLeaderBoard)
    { %>

    <tr>
        <th scope="row">1</th>
        <td><%= leaderBoard.getUser().getName() %></td>
        <td><%= leaderBoard.getUser().getFirstName() %></td>
        <td><%= leaderBoard.getScore() %></td>
    </tr>
    <% }
    }
    %>
    </tbody>
</table>
</body>
</html>
