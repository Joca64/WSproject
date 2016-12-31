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
    <script type="text/javascript" src="app.js"></script>
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

<%
    List<String> titles = Arrays.asList("Name","ID","Description","Image","Genres","Themes","Developers","Publishers","Platforms","Franchise");
    int counter = 0;
    if(request.getParameter("name") != null || request.getParameter("id") != null){
        List<String> gameInfo;
        if(request.getParameter("name") != null)
            gameInfo = jogo.getGame(request.getParameter("name"), false);
        else{
            gameInfo = jogo.getGame(request.getParameter("id"), true);
        }
        if(gameInfo.size() == 0){
%>
<script>
    alert("Game not found, please try again.");
    window.location.href = "/";
</script>
<%
}else{
%>
<div class="row">
    <center><h2>Game - <%=gameInfo.get(0)%></h2></center>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="panel panel-default col-md-3">
            <img style="width: 100%" src="<%=gameInfo.get(3)%>" >
        </div>
        <div class="panel panel-default col-md-7">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Property</th>
                    <th>Value(s)</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for(String thing: gameInfo){
                %>
                <tr>
                    <td><%=titles.get(counter)%></td>
                    <td>
                <%
                    if(counter==4){ //themes
                        String[] genres = thing.split("\\+");
                        for(String genre : genres){
                %>
                        <a href="genre.jsp?name=<%=genre%>"><%=genre%></a>
                        <%
                            }
                        %>
                    </td>
                    <%
                    }else if(counter==5){ //themes
                        String[] themes = thing.split("\\+");
                        for(String theme : themes){
                %>
                        <a href="theme.jsp?name=<%=theme%>"><%=theme%></a>
                        <%
                            }
                        %>
                    </td>
                    <%
                    }else if(counter==6){ //developers
                            String[] developers = thing.split("\\+");
                            for(String developer : developers){
                %>
                        <a href="developer.jsp?name=<%=developer%>"><%=developer%></a>
                        <%
                            }
                        %>
                    </td>
                    <%
                    }else if(counter==7){ //publishers
                        String[] publishers = thing.split("\\+");
                        for(String publisher : publishers){
                %>
                    <a href="publisher.jsp?name=<%=publisher%>"><%=publisher%></a>
                    <%
                        }
                    %>
                    </td>
                    <%
                    }else if(counter==8){ //platforms
                        String[] platforms = thing.split("\\+");
                        for(String platform : platforms){
                    %>
                    <span><%=platform%></span>
                    <%
                        }
                    %>
                    </td>
                    <%
                    }else if(counter==9){ //franchises
                        String[] franchises = thing.split("\\+");
                        if(franchises[0].equals("N/A")){
                    %>
                        <%=franchises[0]%></td>
                    <%
                        }else{
                        for(String franchise : franchises){
                    %>
                    <a href="franchise.jsp?name=<%=franchise%>"><%=franchise%></a>
                    <%
                        }
                    %>
                    </td>
                    <%
                    }}else{
                %>
                    <%=thing%></td>
                <%
                    }
                    counter++;
                %>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
            <div class="col-md-1"></div>
    </div>
</div>
<%
    }
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