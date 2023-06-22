package com.example.zadaniesi.Error;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ResponseBody
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String , Object> handleValidatorException(MethodArgumentNotValidException e){
        Map<String , Object> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().stream()
                .forEach(entry->errors
                        .put(entry.getField(),entry.getDefaultMessage()));
        return errors;
    }

}
