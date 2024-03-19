package com.shreeya.user.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

//as we are using lombok, so we can just write annotations to reduce the biolerplate code as shown below

@Getter //to create getters
@Setter //to create setters
@AllArgsConstructor // to create parameterized constructor
@NoArgsConstructor //to create no args constructor
@Builder  // to follow builder pattern for creation of object of this class
public class ApiResponse {

    private String message; //for error handler message
    private boolean success; // to check wether request was successful or not

    private HttpStatus status; //to check the status , for example not found or something else?


}
