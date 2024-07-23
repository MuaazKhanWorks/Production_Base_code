package com.Try.Production_Base.Validation;

import com.Try.Production_Base.Exception.InternalServerError;
import com.Try.Production_Base.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class ApplicationExceptionHandler {

    // For Validation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    // For Exception Handling and Response.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String ,String> handleBusinessExcaption(UserNotFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("ErrorMessage",ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError.class)
    public Map<String ,String> handleBusinessExcaption(InternalServerError ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("ErrorMessage",ex.getMessage());
        return errorMap;
    }
}
