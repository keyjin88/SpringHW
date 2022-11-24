package ru.vavtech.hw01.exceptions;

public class QuestionsReadException extends RuntimeException {

    public QuestionsReadException() {
        super("Ошибка при чтении файла с вопросами.");
    }
}
