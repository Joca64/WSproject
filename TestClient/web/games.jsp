<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="jogos" class="mypackage.WebServiceClient" scope="page"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Games</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>

<ul class="list-group">
<%
    int counter = 0;
    for(String jogo: jogos.getGames(0,0)){
        counter++;
%>
<li class="list-group-item">
    <span class="badge"><%= counter%></span>
    <a href="/game.jsp?name=<%= jogo%>"><%= jogo%></a>
</li>
<%
    }
%>
</ul>

</body>
</html>
