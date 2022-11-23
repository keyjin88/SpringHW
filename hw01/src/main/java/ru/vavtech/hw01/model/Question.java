package ru.vavtech.hw01.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private String question;
    private String correctAnswer;
}
