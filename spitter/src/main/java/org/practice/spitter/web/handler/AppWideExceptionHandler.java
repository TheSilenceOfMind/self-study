package org.practice.spitter.web.handler;

import org.practice.spitter.web.exception.SpittleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(SpittleNotFoundException.class)
    public String handleSpittleNotFoundException() {
        return "error/spittle_not_found";
    }

}
