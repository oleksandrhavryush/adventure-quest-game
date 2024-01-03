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
        DialogOption option1_1 = new DialogOption("Так", 2);
        DialogOption option1_2 = new DialogOption("Ні", -1);
        QuestItem item1 = new QuestItem("Початок: \n Ви прокидаєтеся на березі острова після корабельної аварії. Ви - єдиний, хто залишився в живих. Прийняти виклик?",
                Arrays.asList(option1_1, option1_2), null, "Гра закінчена. Ви відмовилися від виклику.");

        DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", 4);
        QuestItem item2 = new QuestItem("Огляд острова: \n Ви дивитеся навколо і бачите, що острів вкритий густим лісом. Ви також помічаєте дим, що піднімається з-за дерев. Йти до диму?",
                Arrays.asList(option2_1, option2_2), null, null);

        DialogOption option3_1 = new DialogOption("Так", 5);
        DialogOption option3_2 = new DialogOption("Ні", 6);
        QuestItem item3 = new QuestItem("Знайдений піратський капітан: \n Ви знаходите пораненого піратського капітана. Він каже, що його корабель затонув через шторм, і він - останній з його команди. Він просить вас допомогти йому. Допомогти йому?",
                Arrays.asList(option3_1, option3_2), null, null);

        DialogOption option4_1 = new DialogOption("Так", 7);
        DialogOption option4_2 = new DialogOption("Ні", 8);
        QuestItem item4 = new QuestItem("Самотній пошук: \n Ви відмовляєтеся допомогти піратському капітану і йдете шукати скарби самостійно. Ви знаєте, що на острові повинні бути сховані скарби, адже ви чули про це від свого капітана. Йти вглиб острова?",
                Arrays.asList(option4_1, option4_2), null, null);

        DialogOption option5_1 = new DialogOption("Так", -1);
        DialogOption option5_2 = new DialogOption("Ні", 10);
        QuestItem item5 = new QuestItem("Карта скарбів: \n Піратський капітан дає вам карту скарбів. Він каже, що він не може йти з вами, але він попросить вас поділитися з ним, якщо ви знайдете щось цінне. Ви обіцяєте йому це. Йти за маршрутом на карті?",
                Arrays.asList(option5_1, option5_2), null, "Скарби знайдено: \n Ви знаходите скарби за маршрутом на карті. Ви бачите скриню, наповнену золотом, коштовностями й рідкісними артефактами. Ви відчуваєте радість і задоволення. Перемога!");

        DialogOption option6_1 = new DialogOption("Так", 3);
        DialogOption option6_2 = new DialogOption("Ні", -1);
        QuestItem item6 = new QuestItem("Зрада: \n Ви відмовляєтеся допомогти піратському капітану і хочете йти геть. Але він не дає вам це зробити. Він витягає з-під своєї куртки пістолет і стріляє в вас. Гра закінчена. Спробувати знову?",
                Arrays.asList(option6_1, option6_2), null, "Програш");

        DialogOption option7_1 = new DialogOption("Так", 4);
        DialogOption option7_2 = new DialogOption("Ні", -1);
        QuestItem item7 = new QuestItem("Зустріч з диким звіром: \n Ви зустрічаєте дикого звіра. Ви не маєте зброї, щоб захистити себе. Ви намагаєтеся втекти, але звір швидше вас. Він нападає на вас і розірве вас на шматки. Гра закінчена. Спробувати знову?",
                Arrays.asList(option7_1, option7_2), null, "Програш");

        DialogOption option8_1 = new DialogOption("Так", 4);
        DialogOption option8_2 = new DialogOption("Ні", -1);
        QuestItem item8 = new QuestItem("Загублені: \n Ви загубилися. Ви не можете знайти шлях назад до берега. Ви блукаєте по острову, але не знаходите нічого, що могло б вам допомогти. Ви вмираєте від голоду і спраги. Гра закінчена. Спробувати знову?",
                Arrays.asList(option8_1, option8_2), null, "Програш");

        DialogOption option9_1 = new DialogOption("Так", -1);
        DialogOption option9_2 = new DialogOption("Ні", -1);
        QuestItem item9 = new QuestItem("Скарби знайдено: \n Ви знаходите скарби за маршрутом на карті. Ви бачите скриню, наповнену золотом, коштовностями й рідкісними артефактами. Ви відчуваєте радість і задоволення. Перемога!",
                Arrays.asList(option9_1, option9_2), "Перемога!", null);

        DialogOption option10_1 = new DialogOption("Так", 5);
        DialogOption option10_2 = new DialogOption("Ні", -1);
        QuestItem item10 = new QuestItem("Пастка: \n Ви потрапляєте в пастку. Ви крокуєте на приховану дошку, яка активує механізм. З-під землі вилітають гострі шипи, які пронизують вас. Гра закінчена. Спробувати знову?",
                Arrays.asList(option10_1, option10_2), null, "Програш");

        // Додайте інші пункти ігри аналогічно

        questMap.put(1, item1);
        questMap.put(2, item2);
        questMap.put(3, item3);
        questMap.put(4, item4);
        questMap.put(5, item5);
        questMap.put(6, item6);
        questMap.put(7, item7);
        questMap.put(8, item8);
        questMap.put(9, item9);
        questMap.put(10, item10);
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
