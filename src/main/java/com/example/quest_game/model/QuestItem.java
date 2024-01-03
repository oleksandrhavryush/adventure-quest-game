package com.example.quest_game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestItem {
    private String question;
    private List<DialogOption> dialogOptions;
    private String positiveResult;
    private String negativeResult;
}
