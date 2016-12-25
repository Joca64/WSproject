<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">

<jsp:useBean id="cliente" class="mypackage.WebServiceClient" scope="page"/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Ontology</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--<script type="text/javascript" src="https://code.angularjs.org/1.6.0/angular.min.js"></script>
    <script type="text/javascript" src="app.js"></script>-->

</head>

<body>

<div class="view-container">
    <form action="/game.jsp" method="get">
        Game id: <input type="text" name="id">
        Game name: <input type="text" name="name">
        <input type="submit" value="Submit" />
    </form>
</div>

<div class="view-container">
    <a href="games.jsp">Listar jogos</a>
</div>

<%
    //cliente.setDeOnde("asdasdasdasdasdasasasddasds");
    //String result = cliente.chamarWebservice();
%>

</body>
</html>