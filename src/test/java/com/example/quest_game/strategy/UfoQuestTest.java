package com.example.quest_game.strategy;

import com.example.quest_game.model.DialogOption;
import com.example.quest_game.model.QuestItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UfoQuestTest {

    private UfoQuest ufoQuest;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ufoQuest = new UfoQuest();
    }

    @Test
    @DisplayName("Initialize quest")
    void initializeQuest() {
        ufoQuest.initializeQuest();

        DialogOption option1_1 = new DialogOption("Так", 2);
        DialogOption option1_2 = new DialogOption("Ні", -1);
        QuestItem item1 = new QuestItem("Ви втрачаєте пам'ять. Прийняти виклик НЛО?", Arrays.asList(option1_1, option1_2), null, "Програш");

        DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", -1);
        QuestItem item2 = new QuestItem("Ви прийняли виклик. Піднятися на капітанський місток?", Arrays.asList(option2_1, option2_2), null, "Програш");

        DialogOption option3_1 = new DialogOption("Так", -1);
        DialogOption option3_2 = new DialogOption("Ні", -1);
        QuestItem item3 = new QuestItem("Ви піднялись на місток. Хто ви? Розкажете правду?", Arrays.asList(option3_1, option3_2), "Виграш", "Програш");

        assertEquals(item1, ufoQuest.getQuestItem(1));
        assertEquals(item2, ufoQuest.getQuestItem(2));
        assertEquals(item3, ufoQuest.getQuestItem(3));
    }

    @Test
    @DisplayName("Get quest item")
    void getQuestItem() {
        ufoQuest.initializeQuest();

        DialogOption option1_1 = new DialogOption("Так", 2);
        DialogOption option1_2 = new DialogOption("Ні", -1);
        QuestItem item1 = new QuestItem("Ви втрачаєте пам'ять. Прийняти виклик НЛО?", Arrays.asList(option1_1, option1_2), null, "Програш");

        DialogOption option2_1 = new DialogOption("Так", 3);
        DialogOption option2_2 = new DialogOption("Ні", -1);
        QuestItem item2 = new QuestItem("Ви прийняли виклик. Піднятися на капітанський місток?", Arrays.asList(option2_1, option2_2), null, "Програш");

        DialogOption option3_1 = new DialogOption("Так", -1);
        DialogOption option3_2 = new DialogOption("Ні", -1);
        QuestItem item3 = new QuestItem("Ви піднялись на місток. Хто ви? Розкажете правду?", Arrays.asList(option3_1, option3_2), "Виграш", "Програш");

        assertEquals(item1, ufoQuest.getQuestItem(1));
        assertEquals(item2, ufoQuest.getQuestItem(2));
        assertEquals(item3, ufoQuest.getQuestItem(3));
        assertEquals(null, ufoQuest.getQuestItem(4));
    }

    @Test
    @DisplayName("Handle user answer with correct answer")
    void handleUserAnswerWithCorrectAnswer() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 3;
        String userAnswer = "Так";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        when(request.getParameter("answer")).thenReturn(userAnswer);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        // Act
        ufoQuest.handleUserAnswer(request, response, session, currentQuestion, userAnswer, item);

        // Assert
        verify(session).setAttribute("result", "Виграш");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("Handle user answer with wrong answer")
    void handleUserAnswerWithWrongAnswer() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 3;
        String userAnswer = "Ні";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        when(request.getParameter("answer")).thenReturn(userAnswer);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        // Act
        ufoQuest.handleUserAnswer(request, response, session, currentQuestion, userAnswer, item);

        // Assert
        verify(session).setAttribute("result", "Програш");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("Handle user answer with next question")
    void handleUserAnswerWithNextQuestion() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 1;
        String userAnswer = "Так";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        when(request.getParameter("answer")).thenReturn(userAnswer);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/quest.jsp")).thenReturn(dispatcher);

        // Act
        ufoQuest.handleUserAnswer(request, response, session, currentQuestion, userAnswer, item);

        // Assert
        verify(session).setAttribute("currentQuestion", 2);
        QuestItem nextItem = ufoQuest.getQuestItem(2);
        verify(request).setAttribute("questItem", nextItem);
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("Handle user answer with null request")
    void handleUserAnswerWithNullRequest() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 1;
        String userAnswer = "Так";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            ufoQuest.handleUserAnswer(null, response, session, currentQuestion, userAnswer, item);
        });
    }

    @Test
    @DisplayName("Handle user answer with null response")
    void handleUserAnswerWithNullResponse() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 1;
        String userAnswer = "Так";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        when(request.getParameter("answer")).thenReturn(userAnswer);
        when(request.getSession()).thenReturn(session);

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            ufoQuest.handleUserAnswer(request, null, session, currentQuestion, userAnswer, item);
        });
    }

    @Test
    @DisplayName("Handle user answer with null session")
    void handleUserAnswerWithNullSession() throws ServletException, IOException {
        // Arrange
        ufoQuest.initializeQuest();
        int currentQuestion = 1;
        String userAnswer = "Так";
        QuestItem item = ufoQuest.getQuestItem(currentQuestion);

        when(request.getParameter("answer")).thenReturn(userAnswer);
        when(request.getSession()).thenReturn(null);

        // Act and Assert
        assertThrows(NullPointerException.class, () -> {
            ufoQuest.handleUserAnswer(request, response, null, currentQuestion, userAnswer, item);
        });
    }
}