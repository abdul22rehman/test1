package com.pankaj.pr2.exception;

import com.pankaj.pr2.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandleException {
@ExceptionHandler
    public ResponseEntity<ErrorDetails>HandleException(ResourceNotFound e,WebRequest request){
    ErrorDetails errorDetails=new ErrorDetails(new Date(),e.getMessage(), request.getDescription(true));
    return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
}
@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>globalException(Exception e,WebRequest request){
    ErrorDetails errorDetails=new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
}


}
