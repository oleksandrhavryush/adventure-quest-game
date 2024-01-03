package com.example.quest_game.servlet;

import com.example.quest_game.model.QuestItem;
import com.example.quest_game.strategy.AdventureQuest;
import com.example.quest_game.strategy.PirateQuest;
import com.example.quest_game.strategy.Quest;
import com.example.quest_game.strategy.UfoQuest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "questServlet", value = "/quest-servlet")
public class Quest_Servlet extends HttpServlet {
    private Quest quest;

    public void setQuestStrategy(Quest quest) {
        this.quest = quest;
    }

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setAttribute("currentQuestion", 1);
        session.setAttribute("result", null);

        String questType = request.getParameter("type");

        if ("adventure".equals(questType)) {
            setQuestStrategy(new AdventureQuest());
        } else if ("ufo".equals(questType)) {
            setQuestStrategy(new UfoQuest());
        } else if ("pirate".equals(questType)) {
            setQuestStrategy(new PirateQuest());
        }

        quest.initializeQuest();

        QuestItem item = quest.getQuestItem(1);
        request.setAttribute("questItem", item);
        request.getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quest.execute(request, response);
    }

    public void destroy() {
    }
}
