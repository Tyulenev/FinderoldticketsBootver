package ru.tyulenev.finderoldticketsspringboot.finderoldtickets.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketGlobalExceptionHandling {
    @ExceptionHandler //Метод для обработки исключения
    public ResponseEntity<TicketIncorrectData> handleException(
            TicketNotFoundException exception) {
        TicketIncorrectData data = new TicketIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<TicketIncorrectData>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<TicketIncorrectData> handleException(
            Exception exception) {
        TicketIncorrectData data = new TicketIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<TicketIncorrectData>(data, HttpStatus.BAD_REQUEST);
    }
}
