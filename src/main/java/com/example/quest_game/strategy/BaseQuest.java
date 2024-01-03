package com.example.quest_game.strategy;

import com.example.quest_game.model.DialogOption;
import com.example.quest_game.model.QuestItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuest implements Quest {
    public static final Logger logger = LoggerFactory.getLogger(BaseQuest.class);

    protected Map<Integer, QuestItem> questMap = new HashMap<>();

    protected abstract void handleUserAnswer(HttpServletRequest request, HttpServletResponse response,
                                             HttpSession session, int currentQuestion, String userAnswer, QuestItem item)
            throws ServletException, IOException;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int currentQuestion = (int) session.getAttribute("currentQuestion");
        QuestItem item = getQuestItem(currentQuestion);
        String userAnswer = request.getParameter("userAnswer");

        handleUserAnswer(request, response, session, currentQuestion, userAnswer, item);
    }

    @Override
    public String processUserAnswer(QuestItem item, String userAnswer) {
        for (DialogOption option : item.getDialogOptions()) {
            if (option.getOptionText().equalsIgnoreCase(userAnswer)) {
                if ("Так".equalsIgnoreCase(userAnswer)) {
                    return item.getPositiveResult();
                } else if ("Ні".equalsIgnoreCase(userAnswer)) {
                    return item.getNegativeResult();
                }
            }
        }
        return null;
    }

}