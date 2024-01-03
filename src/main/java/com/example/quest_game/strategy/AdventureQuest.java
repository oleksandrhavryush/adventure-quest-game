package com.example.quest_game.strategy;

import com.example.quest_game.model.DialogOption;
import com.example.quest_game.model.QuestItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

public class AdventureQuest extends BaseQuest {

    @Override
    public void initializeQuest() {
        DialogOption option1_1 = new DialogOption("Так", 2);
        DialogOption option1_2 = new DialogOption("Ні", -1);
        QuestItem item1 = new QuestItem("Ви прокидаєтеся в незнайомому місці без пам'яті. Прийняти виклик?",
                Arrays.asList(option1_1, option1_2), null, "Гра закінчена. Ви відмовилися від виклику.");

        DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", -1);
        QuestItem item2 = new QuestItem("Незнайомець пропонує вам допомогу. Прийняти його пропозицію?",
                Arrays.asList(option2_1, option2_2), null, "Перейти до пункту 4.");

        DialogOption option3_1 = new DialogOption("Йдете за маршрутом на карті", 5);
        DialogOption option3_2 = new DialogOption("Йдете в протилежному напрямку", -1);
        QuestItem item3 = new QuestItem("Незнайомець дає вам карту і їжу. Що ви робите далі?",
                Arrays.asList(option3_1, option3_2), null, "Перейти до пункту 6.");

        // Додайте інші пункти ігри аналогічно

        questMap.put(1, item1);
        questMap.put(2, item2);
        questMap.put(3, item3);
        // Додайте інші пункти ігри аналогічно
    }

    @Override
    protected void handleUserAnswer(HttpServletRequest request, HttpServletResponse response,
                                    HttpSession session, int currentQuestion, String userAnswer, QuestItem item)
            throws ServletException, IOException {
        String result = processUserAnswer(item, userAnswer);

        if (result != null) {
            logger.info("Quest result: {}", result);
            session.setAttribute("result", result);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            for (DialogOption option : item.getDialogOptions()) {
                if (option.getOptionText().equals(userAnswer)) {
                    currentQuestion = option.getNextQuestion();
                    break;
                }
            }

            session.setAttribute("currentQuestion", currentQuestion);
            QuestItem nextItem = getQuestItem(currentQuestion);
            logger.info("Moving to next question: {}", currentQuestion);
            request.setAttribute("questItem", nextItem);
            request.getRequestDispatcher("/quest.jsp").forward(request, response);
        }
    }

    @Override
    public QuestItem getQuestItem(int questionNumber) {
        return questMap.get(questionNumber);
    }
}
