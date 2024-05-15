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

        DialogOption option1_1 = new DialogOption("Yes", 2);
        DialogOption option1_2 = new DialogOption("No", -1);
        QuestItem item1 = new QuestItem("<p><h6>Start:</h6> You received a letter from a scientist who tells you that a threat from another dimension has appeared and the world needs your help. " +
                "<br><br><em>Do you agree to go on a journey?</em></p>",
                Arrays.asList(option1_1, option1_2), null, "<p>The game is over. You refused the challenge.</p>");

        DialogOption option2_1 = new DialogOption("Yes", 3);
        DialogOption option2_2 = new DialogOption("No", -1);
        QuestItem item2 = new QuestItem("<p><h6>Opening the portal:</h6> The scientist tells you that there are gates between dimensions, and you need to open them to get to another world. " +
                "<br><br><em>Do you agree to go in search of the gates?</em></p>",
                Arrays.asList(option2_1, option2_2), null, "<p>The game is over. You didn't take the risk.</p>");

        DialogOption option3_1 = new DialogOption("Yes", 4);
        DialogOption option3_2 = new DialogOption("No", -1);
        QuestItem item3 = new QuestItem("<p><h6>Meeting with the master:</h6> During your research, you find a master who has knowledge of the gates. " +
                "He asks you to help him collect the necessary resources. " +
                "<br><br><em>Do you agree to help him?</em></p>",
                Arrays.asList(option3_1, option3_2), null, "<p><h6>Betrayal:</h6> You refuse to help the master, and he turns out to be your enemy. " +
                "He tries to lock you in another dimension. The game is over.</p>");

        DialogOption option4_1 = new DialogOption("Yes", 5);
        DialogOption option4_2 = new DialogOption("No", -1);
        QuestItem item4 = new QuestItem("<p><h6>Resource search:</h6> You agree to help the master and go in search of the necessary resources. Find a mysterious artifact. " +
                "<br><br><em>Take it with you?</em></p>",
                Arrays.asList(option4_1, option4_2), null, "<p><h6>Lost:</h6> You get lost in another dimension. " +
                "You are surrounded by unfriendly creatures, and you can't find your way back. You die from creature attacks. The game is over.</p>");

        DialogOption option5_1 = new DialogOption("Yes", 6);
        DialogOption option5_2 = new DialogOption("No", -1);
        QuestItem item5 = new QuestItem("<p><h6>Opening the gates:</h6> You find all the necessary resources and return to the master. Together you open the gates to another dimension. " +
                "<br><br><em>Ready to go?</em></p>",
                Arrays.asList(option5_1, option5_2), null,
                "<p><h6>Trap:</h6> You fall into a trap set up by the master. He turns out to be your enemy and leaves you in another dimension. The game is over.</p>");

        DialogOption option6_1 = new DialogOption("Yes", 100);
        DialogOption option6_2 = new DialogOption("No", 8);
        QuestItem item6 = new QuestItem("<p><h6>Another world:</h6> You enter the gates and find yourself in another dimension. Find that this world is also under threat. " +
                "<br><br><em>Ready to go on a rescue journey?</em></p>",
                Arrays.asList(option6_1, option6_2), "<p><h6>Confrontation:</h6> You meet the ruler of another dimension, who turns out to be an enemy. " +
                "You must gather allies and weapons to defeat him.</p>", null);

        DialogOption option7_1 = new DialogOption("Yes", 100);
        DialogOption option7_2 = new DialogOption("No", 6);
        QuestItem item7 = new QuestItem("<p><h6>Found allies:</h6> You find creatures who are ready to help you in the fight against the enemy. " +
                "<br><br><em>Ready to go with them?</em></p>",
                Arrays.asList(option7_1, option7_2), "<p><h6>Battle:</h6> Together with allies, you start a great battle with the enemy. " +
                "It lasts a long time, but you win. Victory!</p>", null);

        DialogOption option8_1 = new DialogOption("Yes", 9);
        DialogOption option8_2 = new DialogOption("No", -1);
        QuestItem item8 = new QuestItem("<p><h6>Found weapon:</h6> You refuse from allies and go to look for a powerful weapon that can help you in the battle. You find a magical sword. " +
                "<br><br><em>Take it with you?</em></p>",
                Arrays.asList(option8_1, option8_2), null,
                "<p><h6>Deadly mistake:</h6> The magical sword turns against you and attacks. You are not able to withstand its power. The game is over.</p>");

        DialogOption option9_1 = new DialogOption("Yes", 100);
        DialogOption option9_2 = new DialogOption("No", -1);
        QuestItem item9 = new QuestItem("<p><h6>Fight with the enemy:</h6> You find the enemy and start the fight. With a magical sword, you can resist him. " +
                "<br><br><em>Start the fight?</em></p>",
                Arrays.asList(option9_1, option9_2), "<p><h6>Final:</h6> You return to your dimension and feel like a hero. The world is saved. Victory!</p>",
                "<p><h6>Final:</h6> You could not defeat the enemy and end up in another dimension forever. The game is over.</p>");

        questMap.put(1, item1);
        questMap.put(2, item2);
        questMap.put(3, item3);
        questMap.put(4, item4);
        questMap.put(5, item5);
        questMap.put(6, item6);
        questMap.put(7, item7);
        questMap.put(8, item8);
        questMap.put(9, item9);
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
