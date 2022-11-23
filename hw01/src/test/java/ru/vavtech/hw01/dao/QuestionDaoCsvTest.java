package ru.vavtech.hw01.dao;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vavtech.hw01.exceptions.QuestionsReadException;
import ru.vavtech.hw01.model.Question;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuestionDaoCsvTest {

    @Test
    @DisplayName("Проверка успешного чтения из файла, когда он есть")
    void getQuestionsTest() {
        var questionDao = new QuestionDaoCsv("/questions.csv");
        var questions = questionDao.getQuestions();

        assertThat(questions)
                .hasSize(2)
                .contains(Question.builder().question("The capital of Russia is").correctAnswer("Moscow").build(), Index.atIndex(0))
                .contains(Question.builder().question("3 * 3 = ").correctAnswer("9").build(), Index.atIndex(1));
    }

    @Test
    @DisplayName("Проверка вылетающей ошибки при чтении файла с вопросами")
    void getQuestionsWithErrorTest() {
        var questionDao = new QuestionDaoCsv("/dummy.csv");
        assertThatThrownBy(questionDao::getQuestions).isInstanceOf(QuestionsReadException.class);
    }
}