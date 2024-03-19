package com.shreeya.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    //extra properties can also be added that you want to manage
    public ResourceNotFoundException(){
        super("Resource not found on Server!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);

    }
}
