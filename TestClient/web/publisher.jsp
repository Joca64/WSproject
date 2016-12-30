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
    <center>
        <div class="page-header">
            <h1>Game Ontology
                <small> - Discover new games</small>
            </h1>
        </div>
    </center>
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
    List<String> titles = Arrays.asList("Name", "ID", "Description", "Country", "Website", "Games Published");
    int counter = 0;
    if (request.getParameter("name") != null || request.getParameter("id") != null) {
        List<String> companyInfo;
        if (request.getParameter("name") != null)
            companyInfo = jogo.getCompany(request.getParameter("name"), false, "Publisher");
        else {
            companyInfo = jogo.getCompany(request.getParameter("id"), true, "Publisher");
        }
        if (companyInfo.size() == 0) {
%>
<script>
    alert("Publisher not found, please try again.");
    window.location.href = "/";
</script>
<%
} else {
%>
<div class="row">
    <center><h2>Publisher - <%=companyInfo.get(0)%>
    </h2></center>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="panel panel-default col-md-8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Property</th>
                    <th>Value(s)</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (String thing : companyInfo) {
                %>
                <tr>
                    <td><%=titles.get(counter)%>
                    </td>
                    <td>
                        <%
                            if (counter == 4) { //website
                                if (thing.equals("N/A")) {
                        %>
                        <%=thing%>
                    </td>
                    <%
                    } else {
                    %>
                    <a target="_blank" href="<%=thing%>"><%=thing%>
                    </a></td>
                    <%
                        }
                    } else if (counter == 5) { //games
                        String[] games = thing.split("\\+");
                        for (String game : games) {
                    %>
                    <a href="game.jsp?name=<%=game%>"><%=game%>
                    </a>
                    <%
                        }
                    %>
                    </td>
                    <%
                    } else {
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
        <div class="col-md-2"></div>
    </div>
</div>
<%
    }
} else {
%>
<script>
    alert("Please enter a publisher id or name.");
    window.location.href = "/";
</script>
<%
    }
%>

</body>
</html>