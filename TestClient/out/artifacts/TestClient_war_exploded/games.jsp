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
    <title>Jogos</title>
</head>
<body>

<li>
<%
    int counter = 0;
    for(String jogo: jogos.getGames()){
        counter++;
%>

    <%= counter%>:<%= jogo%>,

<%
    }
%>
</li>

</body>
</html>
