<%@ page import="com.example.quest_game.model.DialogOption" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.quest_game.model.QuestItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Гра-квест</title>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Гра-квест</h1>
    <% QuestItem questItem = (QuestItem) request.getAttribute("questItem"); %>
    <div class="mt-4">
        <% if (questItem != null) { %>
        <p><%= questItem.getQuestion() %></p>
        <form action="quest-servlet" method="post">
            <% List<DialogOption> dialogOptions = questItem.getDialogOptions(); %>
            <% for (DialogOption option : dialogOptions) { %>
            <div class="form-check">
                <input type="radio" id="<%= option.getOptionText() %>" name="userAnswer" value="<%= option.getOptionText() %>" class="form-check-input">
                <label for="<%= option.getOptionText() %>" class="form-check-label"><%= option.getOptionText() %></label><br>
            </div>
            <% } %>
            <button type="submit" class="btn btn-primary mt-3">Відповісти</button>
        </form>
        <% } else { %>
        <p>Помилка: Об'єкт questItem є null.</p>
        <% } %>
    </div>
</div>
</body>
</html>
