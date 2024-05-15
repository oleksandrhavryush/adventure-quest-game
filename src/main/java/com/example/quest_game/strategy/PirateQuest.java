package com.example.quest_game.strategy;

import com.example.quest_game.model.DialogOption;
import com.example.quest_game.model.QuestItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

public class PirateQuest extends BaseQuest {

    @Override
    public void initializeQuest() {

        DialogOption option1_1 = new DialogOption("Yes", 2);
        DialogOption option1_2 = new DialogOption("No", -1);
        QuestItem item1 = new QuestItem("<p><h6>Start:</h6> You wake up on the shore of an island after a shipwreck. You are the only one who survived. " +
                "<br><br><em>Accept the challenge?</em></p>",
                Arrays.asList(option1_1, option1_2), null, "<p>The game is over. You refused the challenge.</p>");

        DialogOption option2_1 = new DialogOption("Yes", 3);
        DialogOption option2_2 = new DialogOption("No", 4);
        QuestItem item2 = new QuestItem("<p><h6>Island overview:</h6> You look around and see that the island is covered with dense forest. " +
                "You also notice smoke rising from behind the trees. " +
                "<br><br><em>Go to the smoke?</em></p>",
                Arrays.asList(option2_1, option2_2), null, null);

        DialogOption option3_1 = new DialogOption("Yes", 5);
        DialogOption option3_2 = new DialogOption("No", -1);
        QuestItem item3 = new QuestItem("<p><h6>Found pirate captain:</h6> You find a wounded pirate captain. " +
                "He says that his ship sank due to a storm, and he is the last of his crew. He asks you to help him. " +
                "<br><br><em>Help him?</em></p>",
                Arrays.asList(option3_1, option3_2), null,
                "<p><h6>Betrayal:</h6> You refuse to help the pirate captain and want to go away. But he doesn't let you do it. " +
                        "He pulls a gun from under his jacket and shoots you. The game is over.</p>");

        DialogOption option4_1 = new DialogOption("Yes", 6);
        DialogOption option4_2 = new DialogOption("No", -1);
        QuestItem item4 = new QuestItem("<p><h6>Solo search:</h6> You refuse to help the pirate captain and go to search for treasures on your own. " +
                "You know that there must be hidden treasures on the island, because you heard about it from your captain. " +
                "<br><br><em>Go deeper into the island?</em></p>",
                Arrays.asList(option4_1, option4_2), "<p><h6>Meeting with a wild beast:</h6> You meet a wild beast. You have no weapons to protect yourself. " +
                "You try to run away, but the beast is faster than you. It attacks you and tears you to pieces. The game is over.</p>",
                "<p><h6>Lost:</h6> You are lost. You can't find your way back to the shore. " +
                        "You wander around the island, but don't find anything that could help you. You die of hunger and thirst. The game is over.</p>");

        DialogOption option5_1 = new DialogOption("Yes", 7);
        DialogOption option5_2 = new DialogOption("No", -1);
        QuestItem item5 = new QuestItem("<p><h6>Treasure map:</h6> The pirate captain gives you a treasure map. " +
                "He says that he can't go with you, but he will ask you to share with him if you find something valuable. You promise him this. " +
                "<br><br><em>Go by the route on the map?</em></p>",
                Arrays.asList(option5_1, option5_2), null,
                "<p><h6>Trap:</h6> You fall into a trap. You step on a hidden board that activates a mechanism. " +
                        "Sharp spikes fly out of the ground and pierce you. The game is over.</p>");

        DialogOption option6_1 = new DialogOption("Yes", 100);
        DialogOption option6_2 = new DialogOption("No", 8);
        QuestItem item6 = new QuestItem("<p><h6>Found a cave:</h6> You go deeper into the island and find a large cave. " +
                "You hear strange sounds from inside. You think there might be something interesting there. " +
                "<br><br><em>Enter the cave?</em></p>",
                Arrays.asList(option6_1, option6_2), "<p><h6>Disaster:</h6> You enter the cave and find that it is full of lava and volcanic activity. " +
                "You don't have time to get back out as the cave starts to collapse. You end up under the rubble and can't breathe. The game is over.</p>",
                null);

        DialogOption option7_1 = new DialogOption("Yes", 100);
        DialogOption option7_2 = new DialogOption("No", 6);
        QuestItem item7 = new QuestItem("<p><h6>Meeting with the natives:</h6> You go by the route on the map and find a settlement of natives. " +
                "You see that they live in primitive conditions, but look friendly. " +
                "<br><br><em>Communicate with the natives?</em></p>",
                Arrays.asList(option7_1, option7_2), "<p><h6>Friendship:</h6> You communicate with the natives and find out that they know about the treasures. " +
                "They say that they are protecting them from evil people who want to steal them. They offer you to help them in this. " +
                "You agree and gain their trust. They show you the treasure hideout and allow you to take part of them. Victory!</p>",
                null);

        DialogOption option8_1 = new DialogOption("Yes", 9);
        DialogOption option8_2 = new DialogOption("No", -1);
        QuestItem item8 = new QuestItem("<p><h6>Found entrance to the dungeon:</h6> You go further and find an entrance to the dungeon. " +
                "You see that there is an inscription at the entrance: <br><br><em>\"Only the brave can enter. Only the wise can leave\".</em><br> You think there might be something valuable there. " +
                "<br><br><em>Enter the dungeon?</em></p>",
                Arrays.asList(option8_1, option8_2), null,
                "<p><h6>Deadly traps:</h6> During your further journey, the pirate captain follows you and attacks you. You fight him, but he defeats you.</p>");

        DialogOption option9_1 = new DialogOption("Yes", 100);
        DialogOption option9_2 = new DialogOption("No", -1);
        QuestItem item9 = new QuestItem("<p><h6>Found ancient statue:</h6> You entered the dungeon and go by the route on the map and find an ancient statue. " +
                "You see that it holds a key in its hands. You think it can open something important. " +
                "<br><br><em>Take the key?</em></p>",
                Arrays.asList(option9_1, option9_2), "<p><h6>Final:</h6> You took the key and used it to open a secret entrance to the pyramid. " +
                "You enter the pyramid and find the main treasure chest. You see that it is filled with gold, jewels and rare artifacts. " +
                "You feel joy and satisfaction. Victory!</p>",
                "<p><h6>Final:</h6> When you enter the pyramid, you hear the door close behind you. You are trapped. You can't get out of the pyramid. The game is over.</p>");

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
