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
          QuestItem item1 = new QuestItem("<p><h6>Початок:</h6> Ви отримали листа від вченого, який розповідає, що з'явилася загроза з іншого виміру і світ потребує вашої допомоги. " +
                  "<br><br><em>Погоджуєтеся вирушити в подорож?</em></p>",
                  Arrays.asList(option1_1, option1_2), null, "<p>Гра закінчена. Ви відмовилися від виклику.</p>");

          DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", -1);
        QuestItem item2 = new QuestItem("<p><h6>Відкриття порталу:</h6> Вчений розповідає, що є ворота між вимірами, і вам потрібно відкрити їх, щоб потрапити в інший світ. " +
                "<br><br><em>Згодні вирушити на пошук воріт?</em></p>",
                Arrays.asList(option2_1, option2_2), null, "<p>Гра закінчена. Ви не ризикнули.</p>");

        DialogOption option3_1 = new DialogOption("Так", 4);
        DialogOption option3_2 = new DialogOption("Ні", -1);
        QuestItem item3 = new QuestItem("<p><h6>Зустріч із магістром:</h6> Під час вашого дослідження ви знаходите магістра, який володіє знанням про ворота. " +
                "Він просить вас допомогти йому збирати потрібні ресурси. " +
                "<br><br><em>Погоджуєтеся вам допомогти?</em></p>",
                Arrays.asList(option3_1, option3_2), null, "<p><h6>Зрада:</h6> Ви відмовляєтеся допомогти магістру, і він виявляється вашим ворогом. " +
                "Він намагається закрити вас в іншому вимірі. Гра закінчена.</p>");

        DialogOption option4_1 = new DialogOption("Так", 5);
        DialogOption option4_2 = new DialogOption("Ні", -1);
        QuestItem item4 = new QuestItem("<p><h6>Пошук ресурсів:</h6> Ви згоджуєтеся допомогти магістру і вирушаєте в пошук необхідних ресурсів. Знаходите загадковий артефакт. " +
                "<br><br><em>Взяти його з собою?</em></p>",
                Arrays.asList(option4_1, option4_2), null, "<p><h6>Загублені:</h6> Ви загубилися в іншому вимірі. " +
                "Вас оточують непривітні істоти, і ви не можете знайти шлях назад. Ви гинете від атак істот. Гра закінчена.</p>");

        DialogOption option5_1 = new DialogOption("Так", 6);
        DialogOption option5_2 = new DialogOption("Ні", -1);
        QuestItem item5 = new QuestItem("<p><h6>Відкриття воріт:</h6> Ви знаходите всі необхідні ресурси та повертаєтеся до магістра. Разом ви відкриваєте ворота в інший вимір. " +
                "<br><br><em>Готові вирушити?</em></p>",
                Arrays.asList(option5_1, option5_2), null,
                "<p><h6>Пастка:</h6> Ви потрапляєте в пастку, яку влаштував магістр. Він виявляється вашим ворогом і залишає вас в іншому вимірі. Гра закінчена.</p>");

        DialogOption option6_1 = new DialogOption("Так", 100);
        DialogOption option6_2 = new DialogOption("Ні", 8);
        QuestItem item6 = new QuestItem("<p><h6>Інший світ:</h6> Ви входите в ворота і опиняєтеся в іншому вимірі. Знаходите, що цей світ під загрозою теж. " +
                "<br><br><em>Готові вирушити в рятівну подорож?</em></p>",
                Arrays.asList(option6_1, option6_2), "<p><h6>Конфронтация:</h6> Зустрічаєте владаря іншого виміру, який виявляється ворогом. " +
                "Ви повинні зібрати союзників та зброю, щоб перемогти його.</p>", null);

        DialogOption option7_1 = new DialogOption("Так", 100);
        DialogOption option7_2 = new DialogOption("Ні", 6);
        QuestItem item7 = new QuestItem("<p><h6>Знайдені союзники:</h6> Ви знаходите істоти, які готові допомогти вам у боротьбі проти ворога. " +
                "<br><br><em>Готові вирушити разом з ними?</em></p>",
                Arrays.asList(option7_1, option7_2), "<p><h6>Битва:</h6> Разом із союзниками ви розпочинаєте велику битву з ворогом. " +
                "Вона триває довго, але ви перемагаєте. Перемога!</p>", null);

        DialogOption option8_1 = new DialogOption("Так", 9);
        DialogOption option8_2 = new DialogOption("Ні", -1);
        QuestItem item8 = new QuestItem("<p><h6>Знайдена зброя:</h6> Ви відмовляєтеся від союзників і йдете шукати потужну зброю, яка може допомогти вам у битві. Знайшли ви магічний меч. " +
                "<br><br><em>Взяти його з собою?</em></p>",
                Arrays.asList(option8_1, option8_2), null,
                "<p><h6>Смертельна помилка:</h6> Магічний меч обертається проти вас і атакує. Ви не в змозі витримати його силу. Гра закінчена.</p>");

        DialogOption option9_1 = new DialogOption("Так", 100);
        DialogOption option9_2 = new DialogOption("Ні", -1);
        QuestItem item9 = new QuestItem("<p><h6>Боротьба з ворогом:</h6> Ви знаходите ворога та розпочинаєте боротьбу. З магічним мечем ви здатні йому протистояти. " +
                "<br><br><em>Почати боротьбу?</em></p>",
                Arrays.asList(option9_1, option9_2), "<p><h6>Фінал:</h6> Ви повертаєтеся в свій вимір і відчуваєте себе героєм. Світ збережено. Перемога!</p>",
                "<p><h6>Фінал:</h6> Ви не змогли перемогти ворога і опиняєтеся в іншому вимірі назавжди. Гра закінчена.</p>");

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
