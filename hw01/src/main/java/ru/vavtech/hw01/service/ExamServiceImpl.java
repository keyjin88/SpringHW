package ru.vavtech.hw01.service;

import lombok.RequiredArgsConstructor;
import ru.vavtech.hw01.dao.QuestionDAO;
import ru.vavtech.hw01.model.Question;

import java.util.List;

@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final QuestionDAO questionDAO;

    @Override
    public List<Question> showAllQuestions() {
        return questionDAO.getQuestions();
    }
}
