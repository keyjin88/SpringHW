package ru.vavtech.hw01.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.ClassPathResource;
import ru.vavtech.hw01.exceptions.QuestionsReadException;
import ru.vavtech.hw01.model.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class QuestionDaoCsv implements QuestionDAO {
    private final String path;

    public List<Question> getQuestions() {
        try {
            var csvParser = new CSVParser(new InputStreamReader(new ClassPathResource(path).getInputStream()), CSVFormat.Builder.create()
                    .setIgnoreEmptyLines(false)
                    .setAllowMissingColumnNames(true)
                    .setDelimiter(';')
                    .build());
            return csvParser.getRecords().stream().map(record -> Question.builder()
                    .question(record.get(0))
                    .correctAnswer(record.get(1))
                    .build()).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            log.error("getQuestions error: {}", e.getMessage());
            throw new QuestionsReadException();
        }
    }
}
