package com.shreeya.user.exceptions;



import com.shreeya.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*this annotation basically indicates that this
class will become the centralized exception handler of the
entire project*/

@RestControllerAdvice
public class GlobalExceptionHandler {

    //now if exception comes then we have to send the response as well as status codes so we create below code

    // by this statement we indicate that when "resource not found exception" occurs, program flow
    // will go to this handler method
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();

        //here we are constructing an API response using builder pattern with message: message
        //with request success and status;  build method is used to build the entire object
        //advantage of builder pattern is we an create any c    lass object in one line
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        //returning the response created
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);

    }
}
