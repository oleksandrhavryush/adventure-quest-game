<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Game Result</h1>
    <% String result = (String) session.getAttribute("result"); %>
    <p class="mt-4"><%= result %></p>
    <a href="quest-servlet" class="btn btn-primary mt-3">Start Again</a>
</div>
</body>
</html>
