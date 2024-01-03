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
        QuestItem item1 = new QuestItem("Початок: \n Ви отримали листа від вченого, який розповідає, що з'явилася загроза з іншого виміру і світ потребує вашої допомоги. Погоджуєтеся вирушити в подорож?",
                Arrays.asList(option1_1, option1_2), null, "Гра закінчена. Ви відмовилися від виклику.");

        DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", -1);
        QuestItem item2 = new QuestItem("Відкриття порталу: \n Вчений розповідає, що є ворота між вимірами, і вам потрібно відкрити їх, щоб потрапити в інший світ. Згодні вирушити на пошук воріт?",
                Arrays.asList(option2_1, option2_2), null, "Гра закінчена. Ви не ризикнули.");

        DialogOption option3_1 = new DialogOption("Так", 4);
        DialogOption option3_2 = new DialogOption("Ні", -1);
        QuestItem item3 = new QuestItem("Зустріч із магістром: \n Під час вашого дослідження ви знаходите магістра, який володіє знанням про ворота. Він просить вас допомогти йому збирати потрібні ресурси. Погоджуєтеся вам допомогти?",
                Arrays.asList(option3_1, option3_2), null, "Зрада: \n Ви відмовляєтеся допомогти магістру, і він виявляється вашим ворогом. Він намагається закрити вас в іншому вимірі. Гра закінчена.");

        DialogOption option4_1 = new DialogOption("Так", 5);
        DialogOption option4_2 = new DialogOption("Ні", -1);
        QuestItem item4 = new QuestItem("Пошук ресурсів: \n Ви згоджуєтеся допомогти магістру і вирушаєте в пошук необхідних ресурсів. Знаходите загадковий артефакт. Взяти його з собою?",
                Arrays.asList(option4_1, option4_2), null, "Загублені: \n Ви загубилися в іншому вимірі. Вас оточують непривітні істоти, і ви не можете знайти шлях назад. Ви гинете від атак істот. Гра закінчена.");

        DialogOption option5_1 = new DialogOption("Так", 6);
        DialogOption option5_2 = new DialogOption("Ні", -1);
        QuestItem item5 = new QuestItem("Відкриття воріт: \n Ви знаходите всі необхідні ресурси та повертаєтеся до магістра. Разом ви відкриваєте ворота в інший вимір. Готові вирушити?",
                Arrays.asList(option5_1, option5_2), null,
                "Пастка: \n Ви потрапляєте в пастку, яку влаштував магістр. Він виявляється вашим ворогом і залишає вас в іншому вимірі. Гра закінчена.");

        DialogOption option6_1 = new DialogOption("Так", 100);
        DialogOption option6_2 = new DialogOption("Ні", 8);
        QuestItem item6 = new QuestItem("Інший світ: \n Ви входите в ворота і опиняєтеся в іншому вимірі. Знаходите, що цей світ під загрозою теж. Готові вирушити в рятівну подорож?",
                Arrays.asList(option6_1, option6_2), "Конфронтация: \n Зустрічаєте владаря іншого виміру, який виявляється ворогом. Ви повинні зібрати союзників та зброю, щоб перемогти його.", null);

        DialogOption option7_1 = new DialogOption("Так", 100);
        DialogOption option7_2 = new DialogOption("Ні", 6);
        QuestItem item7 = new QuestItem("Знайдені союзники: \n Ви знаходите істоти, які готові допомогти вам у боротьбі проти ворога. Готові вирушити разом з ними?",
                Arrays.asList(option7_1, option7_2), "Битва: \n Разом із союзниками ви розпочинаєте велику битву з ворогом. Вона триває довго, але ви перемагаєте. Перемога!", null);

        DialogOption option8_1 = new DialogOption("Так", 9);
        DialogOption option8_2 = new DialogOption("Ні", -1);
        QuestItem item8 = new QuestItem("Знайдена зброя: \n Ви відмовляєтеся від союзників і йдете шукати потужну зброю, яка може допомогти вам у битві. Знайшли ви магічний меч. Взяти його з собою?",
                Arrays.asList(option8_1, option8_2), null,
                "Смертельна помилка: \n Магічний меч обертається проти вас і атакує. Ви не в змозі витримати його силу. Гра закінчена.");

        DialogOption option9_1 = new DialogOption("Так", 100);
        DialogOption option9_2 = new DialogOption("Ні", -1);
        QuestItem item9 = new QuestItem("Боротьба з ворогом: \n Ви знаходите ворога та розпочинаєте боротьбу. З магічним мечем ви здатні йому протистояти. Перемога в боротьбі!",
                Arrays.asList(option9_1, option9_2), "Фінал: \n Ви повертаєтеся в свій вимір і відчуваєте себе героєм. Світ збережено. Перемога!",
                "Фінал: \n Ви не змогли перемогти ворога і опиняєтеся в іншому вимірі назавжди. Гра закінчена.");

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
