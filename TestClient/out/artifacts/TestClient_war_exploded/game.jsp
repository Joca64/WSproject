<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<jsp:useBean id="jogo" class="mypackage.WebServiceClient" scope="page"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Game</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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

<%
    List<String> titles = Arrays.asList("ID/Name","Description","Image","Genres","Themes","Developers","Publishers","Platforms","Franchise");
    int counter = 0;
    if(request.getParameter("name") != null){
        List<String> gameInfo = jogo.getGame(request.getParameter("name"), false);
        //out.println("Game Name <b>"+request.getParameter("name")+"</b>!");
        //out.println(gameInfo.toString());
        if(gameInfo==null){
            %>
            <script>
                alert("Game not found, please try again.");
                window.location.href = "/";
            </script>
            <%
        }else{
            for(String thing: gameInfo){
                %>
                <div class="media">
                    <div class="media-left">
                        <h4><%=titles.get(counter)%></h4>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading"><%=thing%></h4>
                    </div>
                </div>
                <%
                counter++;
            }
        }
    } else if(request.getParameter("id") != null){
        out.println("Game ID <b>"+request.getParameter("id")+"</b>!");
        List<String> gameInfo = jogo.getGame(request.getParameter("id"), true);
        out.println(gameInfo.toString());
    } else {
        %>
        <script>
            alert("Please enter a game id or name.");
            window.location.href = "/";
        </script>
        <%
    }
%>

</body>
</html>