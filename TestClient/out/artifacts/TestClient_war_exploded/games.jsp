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

<div class="container-fluid">
    <center><div class="page-header"><h1>Game Ontology<small> - Discover new games</small></h1></div></center>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="panel panel-default col-md-6">
            <div class="panel-heading">
                <h3 class="panel-title">Search</h3>
            </div>
            <div class="panel-body">
                <!--<div class="view-container">
                    <form action="/game.jsp" method="get">
                        Game id: <input type="text" name="id">
                        Game name: <input type="text" name="name">
                        <input type="submit" value="Submit" />
                    </form>
                </div>-->

                <div class="row">
                    <div class="input-group form-horizontal">
                        <input type="text" class="form-control" placeholder="What to search..." id="inputValue">
                        <span>Search for </span>
                        <select class="btn" id="select1">
                            <option value="game" selected>Game</option>
                            <option value="developer">Developer</option>
                            <option value="publisher">Publisher</option>
                            <option value="franchise">Franchise</option>
                        </select>
                        <span> by </span>
                        <select class="btn" id="select2">
                            <option value="id" selected>ID</option>
                            <option value="name">Name</option>
                        </select>
                        <button class="btn btn-default" type="button" onclick="searchButton()">Search</button>
                    </div><!-- /input-group -->
                </div>
            </div>
        </div>
        <div class="panel panel-default col-xs-6 col-md-4">
            <div class="panel-heading">
                <h3 class="panel-title">Others</h3>
            </div>
            <div class="panel-body">
                <div class="view-container">
                    <a href="games.jsp">Listar jogos</a>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<div class="container-fluid">
    <div class="col-md-1"></div>
    <div class="col-md-10">
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
    </div>
    <div class="col-md-1"></div>
</div>

</body>
</html>
