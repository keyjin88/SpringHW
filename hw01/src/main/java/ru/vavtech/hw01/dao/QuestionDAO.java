package ru.vavtech.hw01.dao;

import ru.vavtech.hw01.model.Question;

import java.util.List;

public interface QuestionDAO {

    /**
     * Получить список вопросов с ответами
     * @return список вопросов с ответами
     */
    List<Question> getQuestions();
}
