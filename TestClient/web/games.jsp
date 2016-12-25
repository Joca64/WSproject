<%--
  Created by IntelliJ IDEA.
  User: itspm
  Date: 16/12/2016
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean id="jogos" class="mypackage.WebServiceClient" scope="page"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>Jogos</title>
</head>
<body>

<ul class="list-group">
<%
    int counter = 0;
    for(String jogo: jogos.getGames()){
        counter++;
%>
<li class="list-group-item">
    <span class="badge"><%= counter%></span>
    <%= jogo%>
</li>
<%
    }
%>
</ul>

</body>
</html>
