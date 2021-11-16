package com.example.api.configuration;

import com.example.api.controller.CustomerInexistException;
import com.example.api.controller.RealEstatePropertyNonExist;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionCustomerHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CustomerInexistException.class})
    protected ResponseEntity<Object> handlerNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "User not found...", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({RealEstatePropertyNonExist.class})
    protected ResponseEntity<Object> handlerNotFoundProperty(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Property not found...", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
