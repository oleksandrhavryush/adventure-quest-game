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
        QuestItem item2 = new QuestItem("Огляд острова: \n Ви дивитеся навколо і бачите, що острів вкритий густим лісом. " +
                "Ви також помічаєте дим, що піднімається з-за дерев. Йти до диму?",
                Arrays.asList(option2_1, option2_2), null, null);

        DialogOption option3_1 = new DialogOption("Так", 5);
        DialogOption option3_2 = new DialogOption("Ні", -1);
        QuestItem item3 = new QuestItem("Знайдений піратський капітан: \n Ви знаходите пораненого піратського капітана. " +
                "Він каже, що його корабель затонув через шторм, і він - останній з його команди. Він просить вас допомогти йому. Допомогти йому?",
                Arrays.asList(option3_1, option3_2), null, "Зрада: \n Ви відмовляєтеся допомогти піратському капітану і хочете йти геть. Але він не дає вам це зробити. " +
                "Він витягає з-під своєї куртки пістолет і стріляє в вас. Гра закінчена.");

        DialogOption option4_1 = new DialogOption("Так", 6);
        DialogOption option4_2 = new DialogOption("Ні", -1);
        QuestItem item4 = new QuestItem("Самотній пошук: \n Ви відмовляєтеся допомогти піратському капітану і йдете шукати скарби самостійно. " +
                "Ви знаєте, що на острові повинні бути сховані скарби, адже ви чули про це від свого капітана. Йти вглиб острова?",
                Arrays.asList(option4_1, option4_2), "Зустріч з диким звіром: \n Ви зустрічаєте дикого звіра. Ви не маєте зброї, щоб захистити себе. " +
                "Ви намагаєтеся втекти, але звір швидше вас. Він нападає на вас і розірве вас на шматки. Гра закінчена.", "Загублені: \n Ви загубилися. Ви не можете знайти шлях назад до берега. " +
                "Ви блукаєте по острову, але не знаходите нічого, що могло б вам допомогти. Ви вмираєте від голоду і спраги. Гра закінчена.");

        DialogOption option5_1 = new DialogOption("Так", 7);
        DialogOption option5_2 = new DialogOption("Ні", -1);
        QuestItem item5 = new QuestItem("Карта скарбів: \n Піратський капітан дає вам карту скарбів. " +
                "Він каже, що він не може йти з вами, але він попросить вас поділитися з ним, якщо ви знайдете щось цінне. Ви обіцяєте йому це. Йти за маршрутом на карті?",
                Arrays.asList(option5_1, option5_2), null,
                "Пастка: \n Ви потрапляєте в пастку. Ви крокуєте на приховану дошку, яка активує механізм. " +
                "З-під землі вилітають гострі шипи, які пронизують вас. Гра закінчена.");

        DialogOption option6_1 = new DialogOption("Так", 100);
        DialogOption option6_2 = new DialogOption("Ні", 8);
        QuestItem item6 = new QuestItem("Знайдена печера: \n Ви йдете вглиб острова і знаходите велику печеру. " +
                "Ви чуєте дивні звуки зсередини. Ви думаєте, що там може бути щось цікаве. Зайти в печеру?",
                Arrays.asList(option6_1, option6_2), "Катастрофа: \n Ви заходите в печеру і виявляєте, що вона повна лави і вулканічної активності. " +
                "Ви не встигаєте вийти назад, як печера починає обвалюватися. Ви опиняєтеся під завалами і не можете дихати. Гра закінчена.",
                null);

        DialogOption option7_1 = new DialogOption("Так", 100);
        DialogOption option7_2 = new DialogOption("Ні", 6);
        QuestItem item7 = new QuestItem("Зустріч з туземцями: \n Ви йдете за маршрутом на карті і знаходите поселення туземців. " +
                "Ви бачите, що вони живуть у примітивних умовах, але виглядають дружелюбно. Спілкуватися з туземцями?",
                Arrays.asList(option7_1, option7_2), "Дружба: \n Ви спілкуєтеся з туземцями і виявляєте, що вони знають про скарби. " +
                "Вони кажуть, що вони охороняють їх від злих людей, які хочуть їх викрасти. Вони пропонують вам допомогти їм у цьому. " +
                "Ви погоджуєтеся і отримуєте їх довіру. Вони показують вам схованку скарбів і дозволяють вам взяти частину з них. Перемога!",
                null);

        DialogOption option8_1 = new DialogOption("Так", 9);
        DialogOption option8_2 = new DialogOption("Ні", -1);
        QuestItem item8 = new QuestItem("Знайдений вхід в підземелля: \n Ви йдете далі і знаходите вхід в підземелля. " +
                "Ви бачите, що на вході є напис: \"Тільки сміливі можуть увійти. Тільки розумні можуть вийти\". Ви думаєте, що там може бути щось цінне. Увійти в підземелля?",
                Arrays.asList(option8_1, option8_2), null,
                "Смертельні пастки: \n Під час вашого подальшого шляху піратський капітан вирушає за вами і нападає вас. Ви боретеся з ним, але він вас перемагає.");

        DialogOption option9_1 = new DialogOption("Так", 100);
        DialogOption option9_2 = new DialogOption("Ні", -1);
        QuestItem item9 = new QuestItem("Знайдена старовинна статуя: \n Ви увійшли в підземелля та йдете за маршрутом на карті і знаходите старовинну статую. " +
                "Ви бачите, що вона має в руках ключ. Ви думаєте, що він може відкрити щось важливе. Взяти ключ?",
                Arrays.asList(option9_1, option9_2), "Фінал: \n Ви взяли ключ і використали його, щоб відкрити таємний вхід в піраміду. " +
                "Ви входите в піраміду і знаходите головну скриню з скарбами. Ви бачите, що вона наповнена золотом, коштовностями і рідкісними артефактами. " +
                "Ви відчуваєте радість і задоволення. Перемога!",
                "Фінал: Коли ви входите в піраміду, ви чуєте, як за вами зачиняється двері. Ви опиняєтеся у пастці. Ви не можете вийти з піраміди. Гра закінчена.");


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
