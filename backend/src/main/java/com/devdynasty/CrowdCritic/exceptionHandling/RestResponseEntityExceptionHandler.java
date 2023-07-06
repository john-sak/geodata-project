package com.devdynasty.CrowdCritic.exceptionHandling;

import com.devdynasty.CrowdCritic.exception.KeyWordNotFoundException;
import com.devdynasty.CrowdCritic.exception.PrefectureNotFoundException;
import com.devdynasty.CrowdCritic.model.ErrorModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


//TODO USE FOR ALL EXCEPTIONS RETURNING  RESPONSE ENTITIES ACCORDINGLY
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorModel> hendleException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"EXCEPTION", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<ErrorModel> handleBadCredentialsExceptionHandler(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"BAD_CREDENTIALS", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }



    @ExceptionHandler(PrefectureNotFoundException.class)
    private ResponseEntity<ErrorModel> hendlePrefectureNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"PREFECTURENOTFOUND", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(KeyWordNotFoundException.class)
    private ResponseEntity<ErrorModel> hendleKeyWordNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"KEYWORDNOTFOUND", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){

        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"Entity not found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {ValidationException.class})
    private ResponseEntity<ErrorModel> handleMethodArgumentNotValidException(ValidationException ex){

        ErrorModel error = new ErrorModel(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(),"Entity not found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }









}
