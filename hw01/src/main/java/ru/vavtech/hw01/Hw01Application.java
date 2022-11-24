package ru.vavtech.hw01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vavtech.hw01.service.ExamService;

@Slf4j
public class Hw01Application {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var examService = context.getBean(ExamService.class);
        var questions = examService.showAllQuestions();
        for (var question : questions) {
            log.info("{}", question);
        }
        context.close();
    }

}
