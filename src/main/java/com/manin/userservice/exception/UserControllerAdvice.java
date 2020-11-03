package com.manin.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerAdvice {

    /**
     * TODO: now to handle handleMethodArgumentNotValidException and similar that are already being handled
     *  in @{ResponseEntityExceptionHandler.class}, so we need to override this class and and handle all exceptions
     *  ourselves with our custom exceptionFormat, since this functionality will be required everywhere(ProductService,
     *  InventoryService, Sales/InvoiceService), therefore we need a parent module for graceful implementation.
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String error = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new ApiError("error", error);
    }
}
