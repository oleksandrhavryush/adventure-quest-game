package com.example.quest_game.strategy;

import com.example.quest_game.model.QuestItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Quest {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    QuestItem getQuestItem(int questionNumber);

    String processUserAnswer(QuestItem item, String userAnswer);

    void initializeQuest();
}

