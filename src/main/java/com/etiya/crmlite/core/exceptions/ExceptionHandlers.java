package com.etiya.crmlite.core.exceptions;

import com.etiya.crmlite.core.exceptions.types.BusinessException;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import com.etiya.crmlite.core.utilities.results.ErrorResult;
import com.etiya.crmlite.core.utilities.results.Result;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleNotFoundException(NotFoundException exception){
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"VALIDATION.EXCEPTION");
        return errorDataResult;
    }


    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBusinessExceptions(BusinessException businessException){
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS.EXCEPTION");
        return errorDataResult;
    }
}