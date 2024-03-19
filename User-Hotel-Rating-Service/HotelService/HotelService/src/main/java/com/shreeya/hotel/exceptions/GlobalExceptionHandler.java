package com.shreeya.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*The @RestControllerAdvice annotation is a specialization of the
@ControllerAdvice
annotation that allows you to handle exceptions across the whole application,
not just to an individual controller.*/

/*
It is a composed annotation that is annotated with both @ControllerAdvice
and @ResponseBody, which essentially means @ExceptionHandler methods are rendered to the response body
        through message conversion (versus view resolution or template rendering).
*/

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException ex){
        Map map = new HashMap();
        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }


}
