<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<jsp:useBean id="cliente" class="mypackage.WebServiceClient" scope="page"/>

<html>
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
    <script type="text/javascript" src="app.js"></script>
</head>

<body>
<center><div class="page-header"><h1>Game Ontology<small> - Discover new games</small></h1></div></center>
<div class="row">
    <div class="panel panel-default col-xs-12 col-md-8">
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
</div>

<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <center><h3 class="panel-title">Games with most rating</h3></center>
        </div>
        <div class="panel-body">
            <%
                List<String> topGamesIDs = Arrays.asList("20457","20504","20669","2133","17280","20487");
                for (String topGamesID : topGamesIDs) {
            %>
            <div class="col-sm-6 col-md-2">
                <%
                    List<String> topGameInfo = cliente.getGame(topGamesID, true);
                %>
                <div class="thumbnail">
                    <img src="<%=topGameInfo.get(2)%>" width="200">
                    <div class="caption">
                        <center>
                            <h3><%=topGameInfo.get(0)%>
                            </h3>
                            <p><%=topGameInfo.get(1)%>
                            </p>
                            <p><span class="label label-default"><%=topGameInfo.get(3)%></span><span
                                    class="label label-default"><%=topGameInfo.get(4)%></span></p>
                            <p><a href="/game.jsp?id=<%=topGamesID%>" class="btn btn-primary" role="button">More
                                info</a></p>
                        </center>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>

</body>
</html>