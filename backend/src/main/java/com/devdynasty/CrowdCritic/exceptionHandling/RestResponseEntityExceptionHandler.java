package com.devdynasty.CrowdCritic.exceptionHandling;

import com.devdynasty.CrowdCritic.exception.*;
import com.devdynasty.CrowdCritic.model.ErrorModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
@ResponseBody
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorModel> handleException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"EXCEPTION", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }



    @ExceptionHandler(TokenNotFoundException.class)
    private ResponseEntity<ErrorModel> handleTokenNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }


    @ExceptionHandler(RefreshTokenException.class)
    private ResponseEntity<ErrorModel> handleRefreshTokenException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }


    @ExceptionHandler(UserEmailExistsException.class)
    private ResponseEntity<ErrorModel> handleUserEmailExistsException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"USER_EMAIL_EXISTS", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }


    @ExceptionHandler(UsernameExistsException.class)
    private ResponseEntity<ErrorModel> handleUsernameExistsException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"USER_NAME_EXISTS", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }







    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<ErrorModel> handleBadCredentialsException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.FORBIDDEN, LocalDateTime.now(),"BAD_CREDENTIALS", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.FORBIDDEN);

    }


    @ExceptionHandler(AreaOfInterestNotFoundException.class)
    private ResponseEntity<ErrorModel> handleAreaOfInterestNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"AREA_OF_INTEREST_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }






    @ExceptionHandler(PrefectureNotFoundException.class)
    private ResponseEntity<ErrorModel> hendlePrefectureNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"PREFECTURE_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(KeyWordNotFoundException.class)
    private ResponseEntity<ErrorModel> hendleKeyWordNotFoundException(Exception ex){
        ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"KEYWORD_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){

        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, LocalDateTime.now(),"ENTITY_NOT_FOUND_EXCEPTION", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {ValidationException.class})
    private ResponseEntity<ErrorModel> handleMethodArgumentNotValidException(ValidationException ex){

        ErrorModel error = new ErrorModel(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(),"VALIDATION_EXCEPTION", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }




}
