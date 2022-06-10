package uz.yt.springdata.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerResource{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException e, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(er -> {
                    String fieldName = ((FieldError) er).getField();
                    String message = er.getDefaultMessage();
                    errors.put(fieldName, message);
                });
        return ResponseEntity.status(400).body(errors);
    }
}
