package com.ufrn.eaj.demo.resources.exception;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.ufrn.eaj.demo.services.exceptions.AuthorizationException;
import com.ufrn.eaj.demo.services.exceptions.DataIntegrityException;
import com.ufrn.eaj.demo.services.exceptions.FileException;
import com.ufrn.eaj.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandarError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação", e.getMessage(), request.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()){
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandarError> authorization(AuthorizationException e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso Negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }

    @ExceptionHandler(FileException.class)
    public ResponseEntity<StandarError> file(FileException e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Acesso Negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(AmazonServiceException.class)
    public ResponseEntity<StandarError> amazonService(AmazonServiceException e, HttpServletRequest request){
        HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
        StandarError err = new StandarError(System.currentTimeMillis(), code.value(), "Acesso Negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(code).body(err);
    }

    @ExceptionHandler(AmazonClientException.class)
    public ResponseEntity<StandarError> amazonClient(AmazonClientException e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Acesso Negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(AmazonS3Exception.class)
    public ResponseEntity<StandarError> amazonS3(AmazonS3Exception e, HttpServletRequest request){

        StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Acesso Negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
