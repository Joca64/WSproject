<%--
  Created by IntelliJ IDEA.
  User: itspm
  Date: 16/12/2016
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="jogo" class="mypackage.WebServiceClient" scope="page"/>

<html>
<head>
    <title>Jogo</title>
</head>
<body>

<%
    if (request.getParameter("id") == "" && request.getParameter("name").equals("")) {
        out.println("Please enter a game id or name.");
    } else if(request.getParameter("id") == ""){
        out.println("Game Name <b>"+request.getParameter("name")+"</b>!");
        List<String> gameInfo = jogo.getGame(request.getParameter("name"), false);
        out.println(gameInfo.toString());
    } else{
        out.println("Game ID <b>"+request.getParameter("id")+"</b>!");
        List<String> gameInfo = jogo.getGame(request.getParameter("id"), true);
        out.println(gameInfo.toString());
    }

%>

</body>
</html>