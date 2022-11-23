package ru.vavtech.hw01.service;

import ru.vavtech.hw01.model.Question;

import java.util.List;

public interface ExamService {

    /**
     * Получить список вопросов с ответами
     * @return список вопросов с ответами
     */
    List<Question> showAllQuestions();

}
